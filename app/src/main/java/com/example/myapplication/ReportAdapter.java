package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {
    private List<Report> reports = new ArrayList<>();

    public void addReport(Report report) {
        reports.add(report);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report_custom, parent, false);
        return new ReportViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report report = reports.get(position);
        holder.bind(report);
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public static class ReportViewHolder extends RecyclerView.ViewHolder {
        private TextView rampTextView;
        private TextView elevatorTextView;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            rampTextView = itemView.findViewById(R.id.textRamp);
            elevatorTextView = itemView.findViewById(R.id.textElevator);
        }

        public void bind(Report report) {
            rampTextView.setText(report.getRampReport());
            elevatorTextView.setText(report.getElevatorReport());
        }
    }
}
