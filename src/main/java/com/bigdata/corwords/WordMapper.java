package com.bigdata.corwords;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Maps word occurrences (which words pair with another one) If you have an
 * input as "Hello, today is a nice day" the mapper should output the following
 * tuples: [(hello, today), (today, is), (is, a), (a, nice), (nice, day)]
 */
public class WordMapper extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
	private Text first = new Text();
	private Text second = new Text();

	/**
	 * Normalize a string removing punctuation marks, blank spaces and
	 * transforming it to lowercase
	 * 
	 * @param string
	 *            - String to be normalized
	 * @return - String - normalized string, never <code>null</code>
	 */
	private String normalize(String string) {
		return string.replace(",", "").replace("\\.", "").replace("!", "")
				.replace("¡", "").replace("?", "").replace("¿", "")
				.toLowerCase().trim();
	}

	/**
	 *
	 * @param key
	 *            - to be ignored
	 * @param value
	 *            - string line to be processed
	 * @param collector
	 *            - where results should be put
	 * @param reporter
	 *            - report progress so that the job is not killed if takes too
	 *            much time
	 * @throws IOException
	 */
	public void map(Text key, Text value,OutputCollector<Text, Text> collector, Reporter reporter)
			throws IOException {
		/*
		 * If you have an input as "Hello, today is a nice day" the mapper
		 * should output the following tuples: [(hello, today), (today, is),
		 * (is, a), (a, nice), (nice, day)]
		 */
		StringTokenizer tokenizer = new StringTokenizer(
				normalize(value.toString()));
		if (tokenizer.hasMoreTokens()) { // checks for empty archive
			first.set(tokenizer.nextToken());
		}
		while (tokenizer.hasMoreTokens()) { // collects the data
			second.set(tokenizer.nextToken());
			collector.collect(first, second);
			first.set(second);

		}
	}
}
