package com.example.demo.entity;

public class CivilStructure {
    private Integer no;
    private String id;
    private String date;
    private String location;
    private String basicallyIntactSquare;
    private String damagedSquare;
    private String destroyedSquare;
    private String note;
    private String reportingUnit;

    @Override
    public String toString() {
        return "CivilStructure{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", basicallyIntactSquare='" + basicallyIntactSquare + '\'' +
                ", damagedSquare='" + damagedSquare + '\'' +
                ", destroyedSquare='" + destroyedSquare + '\'' +
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

    public String getBasicallyIntactSquare() {
        return basicallyIntactSquare;
    }

    public void setBasicallyIntactSquare(String basicallyIntactSquare) {
        this.basicallyIntactSquare = basicallyIntactSquare;
    }

    public String getDamagedSquare() {
        return damagedSquare;
    }

    public void setDamagedSquare(String damagedSquare) {
        this.damagedSquare = damagedSquare;
    }

    public String getDestroyedSquare() {
        return destroyedSquare;
    }

    public void setDestroyedSquare(String destroyedSquare) {
        this.destroyedSquare = destroyedSquare;
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