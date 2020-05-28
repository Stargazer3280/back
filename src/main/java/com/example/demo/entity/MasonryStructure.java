package com.example.demo.entity;

public class MasonryStructure {
    private Integer no;
    private String id;
    private String date;
    private String location;
    private String basicallyIntactSquare;
    private String slightDamagedSquare;
    private String moderateDamagedSquare;
    private String seriousDamagedSquare;
    private String destroyedSquare;
    private String note;
    private String reportingUnit;

    @Override
    public String toString() {
        return "MasonryStructure{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", basicallyIntactSquare='" + basicallyIntactSquare + '\'' +
                ", slightDamagedSquare='" + slightDamagedSquare + '\'' +
                ", moderateDamagedSquare='" + moderateDamagedSquare + '\'' +
                ", seriousDamagedSquare='" + seriousDamagedSquare + '\'' +
                ", destroyedSquare='" + destroyedSquare + '\'' +
                ", note='" + note + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getBasicallyIntactSquare() {
        return basicallyIntactSquare;
    }

    public void setBasicallyIntactSquare(String basicallyIntactSquare) {
        this.basicallyIntactSquare = basicallyIntactSquare;
    }

    public String getSlightDamagedSquare() {
        return slightDamagedSquare;
    }

    public void setSlightDamagedSquare(String slightDamagedSquare) {
        this.slightDamagedSquare = slightDamagedSquare;
    }

    public String getModerateDamagedSquare() {
        return moderateDamagedSquare;
    }

    public void setModerateDamagedSquare(String moderateDamagedSquare) {
        this.moderateDamagedSquare = moderateDamagedSquare;
    }

    public String getSeriousDamagedSquare() {
        return seriousDamagedSquare;
    }

    public void setSeriousDamagedSquare(String seriousDamagedSquare) {
        this.seriousDamagedSquare = seriousDamagedSquare;
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
