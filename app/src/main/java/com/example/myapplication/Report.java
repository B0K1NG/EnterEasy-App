package com.example.myapplication;

public class Report {
    private String rampReport;
    private String elevatorReport;

    public Report(String rampReport) {
        this.rampReport = rampReport;
    }

    public Report(String rampReport, String elevatorReport) {
        this.rampReport = rampReport;
        this.elevatorReport = elevatorReport;
    }

    public String getRampReport() {
        return rampReport;
    }

    public String getElevatorReport() {
        return elevatorReport;
    }
}
