package com.bigdata.redjoin;

/**
 * Created by jose.rozanec
 */
public class Municipality {
    private String zip;
    private String name;
    private String km2;
    private String trees;

    public Municipality(String zip, String name, String km2, String trees) {
        this.zip = zip;
        this.name = name;
        this.km2 = km2;
        this.trees = trees;
    }

    public String getTrees() {
        return trees;
    }

    public String getKm2() {
        return km2;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }
}
