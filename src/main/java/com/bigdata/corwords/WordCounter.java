package com.bigdata.corwords;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCounter extends Configured implements Tool {
	// where to put the data in hdfs when we're done
	private static final String OUTPUT_PATH = "output";

	// where to read the data from.
	private static final String INPUT_PATH = "input";

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new WordCounter(), args);
		System.exit(res);
	}

	public int run(String[] args) throws Exception {
		return 0;
		//TODO: acomodar esto por favor
//		Configuration conf = getConf();
//		Job job = new Job(conf, "Word COunter 1");
//
//		job.setJarByClass(WordCounter.class);
//		
//		job.setMapperClass(WordMapper.class);
//		job.setReducerClass(WordReducer.class);
//
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(Text.class);
//
//		FileInputFormat.addInputPath(job, new Path(INPUT_PATH));
//		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
//		
//		return job.waitForCompletion(true) ? 0 : 1;
	}
}
