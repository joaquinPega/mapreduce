package com.bigdata.docs;

import com.google.gson.Gson;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

/**
 * Created by jose.rozanec
 */
public class DocumentMapper extends MapReduceBase
        implements org.apache.hadoop.mapred.Mapper<Text, Text, IntWritable, Document> {

    /**
     * Reads documents in json format and collects them as a Document instance
     * grouped by yyyyMMdd attribute
     * @param key - to be ignored
     * @param value - json record corresponding to single Document
     * @param collector - where output is collected
     * @param reporter - allows to report progress and avoid the job being killed if perceived as slow
     * @throws IOException
     */
    @Override
    public void map(Text key, Text value, OutputCollector<IntWritable, Document> collector, Reporter reporter)
            throws IOException {
        //TODO complete!
        /*
            Read a document from json format using the Gson library (https://code.google.com/p/google-gson/)
            Use the yyyyMMdd value as key to output the document
         */
    	Gson gson = new Gson();
    	gson.toJson(value.toString());
    	
    }
}
