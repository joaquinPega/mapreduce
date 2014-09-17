package com.bigdata.redjoin.parse;

import com.bigdata.redjoin.Person;

/**
 * Created by jose.rozanec
 * Parses person records: id, name, surname, sex, bornYYYY, ZIP
 */
public class PersonRecordParser {

    public Person parseFromCSV(String line){
        String [] array = line.split(",");
        return new Person(array[0], array[1], array[2], array[3], Integer.parseInt(array[4]), array[5]);
    }
}
