package com.bigdata.redjoin;

/**
 * Created by jose.rozanec
 */
public class DemographicsReport {
    private String zip;
    private long less18;
    private long totalPersons;
    private long km2;
    private long male;

    public DemographicsReport(String zip){
        this.zip = zip;
    }

    public void addPersonData(String born, String sex){
        if(born != null){
            if(Integer.valueOf(born) < 18){
                less18++;
            }
        }
        if(sex != null && sex.equalsIgnoreCase("m")){
            male++;
        }
        totalPersons++;
    }

    public void addMunicipalityArea(String km2){
        if(km2 != null){
            this.km2 = Long.parseLong(km2);
        }
    }

    public long getLess18() {
        return less18;
    }

    public long getTotalPersons() {
        return totalPersons;
    }

    public long getKm2() {
        return km2;
    }

    public long getMale() {
        return male;
    }
}
