package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class report_main extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ReportAdapter reportAdapter;
    private Spinner spinner;
    private Spinner spinner2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        Button submitButton = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reportAdapter = new ReportAdapter();
        recyclerView.setAdapter(reportAdapter);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ramp_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.elevator_options, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rampReport = spinner.getSelectedItem().toString();
                String elevatorReport = spinner2.getSelectedItem().toString();

                // Check if both reports are selected
                if (!rampReport.equals("Select Ramp") && !elevatorReport.equals("Select Elevator")) {
                    // Show error message if both reports are selected
                    showToast("You can only select one type of report");
                } else if (!rampReport.equals("Select Ramp")) {
                    // Add Ramp report to RecyclerView with descriptive text
                    reportAdapter.addReport(new Report("Ramp malfunction: " + rampReport));
                } else if (!elevatorReport.equals("Select Elevator")) {
                    // Add Elevator report to RecyclerView with descriptive text
                    reportAdapter.addReport(new Report("Elevator out of order: " + elevatorReport));
                } else {
                    // Show error message if no report is selected
                    showToast("Please select a report");
                }
            }
        });

    }

    // Utility method to show Toast messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}