package com.example.myapplication;

public class Report {
    private String rampReport;
    private String elevatorReport;
    private String reportDescription;

    public Report(String rampReport, String elevatorReport) {
        this.rampReport = rampReport;
        this.elevatorReport = elevatorReport;
    }

    public String getRampReport() {
        return rampReport;
    }

    public Report(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public String getElevatorReport() {
        return elevatorReport;
    }
}
