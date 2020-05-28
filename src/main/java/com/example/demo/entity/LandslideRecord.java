package com.example.demo.entity;

import org.apache.ibatis.annotations.Mapper;

import java.util.Arrays;

@Mapper
public class LandslideRecord {
    private Integer no;
    private String id;
    private String location;
    private String date;
    private String type;
    private String status;
    private String note;
    private byte[] picture;
    private String reportingUnit;

    @Override
    public String toString() {
        return "LandslideRecord{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", picture=" + Arrays.toString(picture) +
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }
}
