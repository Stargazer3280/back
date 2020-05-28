package com.example.demo.entity;

import java.util.Arrays;

public class DisasterInfo {
    private Integer no;
    private String id;
    private String date;
    private String location;
    private float longitude;
    private float latitude;
    private float depth;
    private float magnitude;
    private byte[] picture;
    private String reportingUnit;

    @Override
    public String toString() {
        return "DisasterInfo{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", depth=" + depth +
                ", magnitude=" + magnitude +
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

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
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
