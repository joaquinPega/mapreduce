package com.bigdata.redjoin.map;

import com.bigdata.redjoin.JoinTags;
import com.bigdata.redjoin.Person;
import com.bigdata.redjoin.TaggedText;
import com.bigdata.redjoin.parse.PersonRecordParser;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

/**
 * Created by jose.rozanec
 */
public class PersonMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, TaggedText> {

    private PersonRecordParser parser;

    public PersonMapper(){
        parser = new PersonRecordParser();
    }

    public void map(LongWritable key, Text value, OutputCollector<Text, TaggedText> output, Reporter reporter) throws IOException {
        //TODO complete!
        /*
            Ignore the key value
            Consider Text value comes in the following format: id,name,surname,sex,bornYYYY,ZIP
             where
             - id is the ID for that person
             - name is the name
             - surname is the surname
             - sex corresponds to the sex
             - bornYYYY is meant as the year the person was born
             - ZIP corresponds to the zip code where the person lives

            Use the PersonRecordParser to parse values and
            output a TaggedText with PERSON JoinTag and sex and bornYYYY value as Text("%s,%s")
         */
    }
}
