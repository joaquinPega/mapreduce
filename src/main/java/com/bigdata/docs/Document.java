package com.bigdata.docs;

import org.apache.hadoop.io.Writable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

/*
     //TODO!
     Implement the org.apache.hadoop.io.Writable interface.
     This is required so that the class serializes between map and reduce phase.
 */

/**
 * Created by jose.rozanec
 */
@Root
public class Document implements Serializable {
    @Attribute
    private int yyyyMMdd;
    @Attribute
    private String uuid;
    @Element
    private String author;

    /**
     * This constructor is required for serialization purposes.
     */
    private Document(){}

    public Document(int yyyyMMdd, String uuid, String author) {
        this.yyyyMMdd = yyyyMMdd;
        this.uuid = uuid;
        this.author = author;
    }

    public int getYyyyMMdd() {
        return yyyyMMdd;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAuthor() {
        return author;
    }

}
