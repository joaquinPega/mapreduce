package com.bigdata.redjoin.map;

import com.bigdata.redjoin.JoinTags;
import com.bigdata.redjoin.Municipality;
import com.bigdata.redjoin.TaggedText;
import com.bigdata.redjoin.parse.MunicipalityRecordParser;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

/**
 * Created by jose.rozanec
 * Maps text file with municipality data to text output.
 * Data contains: ZIP, name, km2, trees
 */
public class MunicipalityMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, TaggedText> {

    private MunicipalityRecordParser parser;

    public MunicipalityMapper(){
        parser = new MunicipalityRecordParser();
    }

    /**
     * Maps municipality data to a TaggedText instance
     * @param key - some key
     * @param value - municipality data in the following format: ZIP,name,km2,trees
     * @param output - collector to output data
     * @param reporter - allows to report progress to avoid the job being killed if perceived as slow/unresponsive
     * @throws IOException
     */
    public void map(LongWritable key, Text value, OutputCollector<Text, TaggedText> output, Reporter reporter) throws IOException {
        //TODO complete!
        /*
            Ignore the key value
            Consider Text value comes in the following format: ZIP,name,km2,trees
             where
             - ZIP is a zip code
             - name corresponds to the name of the geographic area identified by the ZIP
             - km2 holds the square kilometres of the area the ZIP covers
             - trees holds the number of trees planted in the area

            Use the MunicipalityRecordParser to parse values and
            output a TaggedText with MUNICIPALITY JoinTag and km2 value as Text
         */
    }
}
