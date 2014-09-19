package com.bigdata.redjoin;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by jose.rozanec
 */
/*
     Implement the org.apache.hadoop.io.Writable interface
 */
public class TaggedText implements Serializable,Writable {

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

	@Override
	public void readFields(DataInput in) throws IOException {
		this.tag = WritableUtils.readString(in);
		this.text = WritableUtils.readString(in);
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, this.tag);
		WritableUtils.writeString(out, this.text);
		
	}
}
