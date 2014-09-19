package com.bigdata.docs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

/**
 * Serializes given documents to XML format.
 * Created by jose.rozanec
 */
public class DocumentReducer extends MapReduceBase implements Reducer<IntWritable, Document, Text, Text> {
    private Serializer serializer;
    private StringWriter writer;

    public DocumentReducer(){
        serializer = new Persister();
    }

    /**
     * Takes Document instances and transforms them to XML format.
     * If some error occurs when serializing Document into XML,
     * the value "<failure/>" will be sent.
     * @param key - yyyyMMdd document value
     * @param values - Document instances with same yyyyMMdd
     * @param collector - collects values to be sent to output
     * @param reporter - reports progress from a task so that the job is not killed perceived as slow/unresponsive
     * @throws IOException
     */
    @Override
    public void reduce(IntWritable key, Iterator<Document> values, OutputCollector<Text, Text> collector,
                       Reporter reporter) throws IOException {
        /*
            Serialize document instances to XML using key as output key Text value
            and SimpleXML library to perform the serialization (http://simple.sourceforge.net/)
         */
    	try {
    		while(values.hasNext()){
    			writer=new StringWriter();
    			serializer.write(values.next(), writer);
				collector.collect(new Text(key.toString()), new Text(writer.toString()));
				System.out.println(writer.toString());
    		}
		} catch (Exception e) {
			collector.collect(new Text(key.toString()), new Text("<failure/>"));
		}
    	
    }
}
