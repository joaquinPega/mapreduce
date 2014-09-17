package com.bigdata.redjoin.parse;

import com.bigdata.redjoin.Municipality;

/**
 * Created by jose.rozanec
 * Parses municipality records: ZIP, name, km2, trees
 */
public class MunicipalityRecordParser {

    public Municipality parseFromCSV(String line){
        String [] array = line.split(",");
        return new Municipality(array[0], array[1], array[2], array[3]);
    }
}
