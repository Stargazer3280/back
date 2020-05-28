package com.example.demo.entity;

public class MissingStatistics {
    private Integer no;
    private String id;
    private String location;
    private String date;
    private Integer number;
    private String reportingUnit;

    @Override
    public String toString() {
        return "MissingStatistics{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", number=" + number +
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }
}