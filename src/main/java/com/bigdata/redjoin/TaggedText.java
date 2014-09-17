package com.bigdata.redjoin;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by jose.rozanec
 */
/*
    TODO! Implement the org.apache.hadoop.io.Writable interface
 */
public class TaggedText implements Serializable {

    private String tag;
    private String text;

    /**
     * Constructor required for serialization.
     */
    private TaggedText(){}

    public TaggedText(String tag, String text) {
        this.tag = tag;
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public String getText() {
        return text;
    }
}
