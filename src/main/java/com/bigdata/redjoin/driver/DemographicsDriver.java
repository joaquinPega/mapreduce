package com.bigdata.redjoin.driver;

import com.bigdata.redjoin.map.MunicipalityMapper;
import com.bigdata.redjoin.map.PersonMapper;
import com.bigdata.redjoin.red.DemographicsReducer;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.util.Tool;

/**
 * Created by jose.rozanec
 */
public class DemographicsDriver extends Configured implements Tool {
    /**
     * Runs reduce side join.
     * @param args
     *      arg[0]: Municipality data file path
     *      arg[1]: Person data file path
     *      arg[2]: output file path
     * @return int - 0 if successfully executed
     * @throws Exception
     */
    public int run(String[] args) throws Exception {
        String municipalities = args[0];
        String persons = args[1];
        String output = args[2];

        //get the configuration parameters and assigns a job name
        JobConf conf = new JobConf(getConf(), DemographicsDriver.class);
        conf.setJobName("Demographics");

        //setting key value types for mapper and reducer outputs
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        //specifying the custom reducer class
        conf.setReducerClass(DemographicsReducer.class);

        //Specifying the input directories(@ runtime) and Mappers independently for inputs from multiple sources
        MultipleInputs.addInputPath(conf, new Path(municipalities), TextInputFormat.class, MunicipalityMapper.class);
        MultipleInputs.addInputPath(conf, new Path(persons), TextInputFormat.class, PersonMapper.class);

        //remove out directory if exists, to avoid issues
        FileSystem hdfs = FileSystem.get(conf);
        if (hdfs.exists(new Path(output)))
            hdfs.delete(new Path(output), true);

        //Specifying the output directory @ runtime
        FileOutputFormat.setOutputPath(conf, new Path(output));

        JobClient.runJob(conf);
        return 0;
    }
}
