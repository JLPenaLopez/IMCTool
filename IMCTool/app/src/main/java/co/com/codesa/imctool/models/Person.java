package co.com.codesa.imctool.models;

import java.io.Serializable;

/**
 * Created by jorgeluispenalopez on 13/10/16.
 */

public class Person implements Serializable{

    private String sbName;
    private String sbEmail;
    private int nuAge;
    private String sbSex;
    private String sbPassword;

    public Person() {
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getSbEmail() {
        return sbEmail;
    }

    public void setSbEmail(String sbEmail) {
        this.sbEmail = sbEmail;
    }

    public int getNuAge() {
        return nuAge;
    }

    public void setNuAge(int nuAge) {
        this.nuAge = nuAge;
    }

    public String getSbSex() {
        return sbSex;
    }

    public void setSbSex(String sbSex) {
        this.sbSex = sbSex;
    }

    public String getSbPassword() {
        return sbPassword;
    }

    public void setSbPassword(String sbPassword) {
        this.sbPassword = sbPassword;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sbName='" + sbName + '\'' +
                ", sbEmail='" + sbEmail + '\'' +
                ", nuAge=" + nuAge +
                ", sbSex='" + sbSex + '\'' +
                ", sbPassword='" + sbPassword + '\'' +
                '}';
    }
}
