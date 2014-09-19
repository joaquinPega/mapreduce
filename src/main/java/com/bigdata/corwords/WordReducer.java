package com.bigdata.corwords;

import com.google.common.collect.Sets;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


/**
 * Counts the number of different co-occurrences for a given word.
 * Ex.: for word "hello" and co-occurrences ["world", "beauty", "animal"]
 * you should get ("hello", 3)
 */
public class WordReducer extends MapReduceBase implements Reducer<Text, Text, Text, IntWritable> {

    /**
     *
     * @param key - given word
     * @param values - words that occur with the given word (key)
     * @param collector - collects the output
     * @param reporter - allows to report progress, so that the task is not killed if slow
     * @throws IOException
     */
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, IntWritable> collector, Reporter reporter)
            throws IOException {
       
        /*
            Ex.: for word "hello" and co-occurrences ["world", "beauty", "animal"]
            you should get ("hello", 3)
        */
    	int sum =0;
    	while(values.hasNext()){
    		sum++;
    		values.next();
    	}
    	collector.collect(key, new IntWritable(sum));
    	
    }
}
