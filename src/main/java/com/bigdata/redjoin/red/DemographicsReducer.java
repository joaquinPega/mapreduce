package com.bigdata.redjoin.red;

import com.bigdata.redjoin.DemographicsReport;
import com.bigdata.redjoin.JoinTags;
import com.bigdata.redjoin.TaggedText;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * Identifies records with same key and different tag to calculate demographic stats
 * Created by jose.rozanec
 */
public class DemographicsReducer extends MapReduceBase implements Reducer<Text, TaggedText, Text, Text> {

    /**
     *
     * @param key - ZIP
     * @param values - values to be considered for calculations
     * @param collector - collector where to output the values
     * @param reporter - allows to report progress
     * @throws IOException
     */
    @Override
    public void reduce(Text key, Iterator<TaggedText> values, OutputCollector<Text, Text> collector, Reporter reporter) throws IOException {
        DemographicsReport demographicsReport = new DemographicsReport(key.toString());
        //TODO complete!
        /*
             Given a DemographicsReport instance where to collect information to be reported,
             collect values for a given key.
             When no more values for a key are provided, information provided by the
             DemographicsReport instance will be used to output the zip code and following information:
              - total persons
              - number of persons 18+ years old
              - persons per km2
              - percentage of male population

             Information will be sent in the following format: "%s, %s, %s, %s"
        */
        String report = String.format("%s, %s, %s, %s",
                demographicsReport.getTotalPersons(),
                demographicsReport.getTotalPersons() - demographicsReport.getLess18(),
                (double) demographicsReport.getTotalPersons() / (double) demographicsReport.getKm2(),
                100 * demographicsReport.getMale() / (double) demographicsReport.getTotalPersons());
        collector.collect(key, new Text(report));
    }
}
