package com.brkat.tunnel.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brkat.tunnel.databinding.ItemLogBinding;
import com.brkat.tunnel.models.ConnectionLog;

import java.util.ArrayList;
import java.util.List;

/**
 * LogsAdapter - محول قائمة السجلات
 * يعرض سجلات الاتصال في RecyclerView
 */
public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.LogViewHolder> {

    private List<ConnectionLog> logs = new ArrayList<>();

    public void updateLogs(List<ConnectionLog> newLogs) {
        this.logs = newLogs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLogBinding binding = ItemLogBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new LogViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LogViewHolder holder, int position) {
        ConnectionLog log = logs.get(position);
        holder.bind(log);
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    /**
     * ViewHolder للسجل
     */
    public class LogViewHolder extends RecyclerView.ViewHolder {

        private ItemLogBinding binding;

        public LogViewHolder(ItemLogBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ConnectionLog log) {
            binding.logType.setText(log.getTypeString());
            binding.logMessage.setText(log.message);
            binding.logTime.setText(log.getFormattedTime());
        }
    }
}