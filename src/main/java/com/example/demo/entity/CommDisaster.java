package com.example.demo.entity;

import java.util.Arrays;

public class CommDisaster {
    private Integer no;
    private String id;
    private String date;
    private String location;
    private String type;
    private String grade;
    private byte[] picture;
    private String note;
    private String reportingUnit;

    @Override
    public String toString() {
        return "CommDisaster{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", note='" + note + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }
}
