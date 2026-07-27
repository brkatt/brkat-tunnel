package com.brkat.tunnel.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brkat.tunnel.databinding.ItemServerBinding;
import com.brkat.tunnel.models.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * ServersAdapter - محول قائمة السيرفرات
 * يعرض قائمة السيرفرات في RecyclerView
 */
public class ServersAdapter extends RecyclerView.Adapter<ServersAdapter.ServerViewHolder> {

    private List<Server> servers = new ArrayList<>();
    private OnServerClickListener listener;

    public interface OnServerClickListener {
        void onServerClick(Server server);
        void onServerLongClick(Server server);
    }

    public ServersAdapter(OnServerClickListener listener) {
        this.listener = listener;
    }

    public void updateServers(List<Server> newServers) {
        this.servers = newServers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemServerBinding binding = ItemServerBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ServerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ServerViewHolder holder, int position) {
        Server server = servers.get(position);
        holder.bind(server);
    }

    @Override
    public int getItemCount() {
        return servers.size();
    }

    /**
     * ViewHolder للسيرفر
     */
    public class ServerViewHolder extends RecyclerView.ViewHolder {

        private ItemServerBinding binding;

        public ServerViewHolder(ItemServerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Server server) {
            binding.serverName.setText(server.name);
            binding.serverProtocol.setText(server.protocol);
            binding.serverAddress.setText(server.address + ":" + server.port);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onServerClick(server);
                }
            });

            itemView.setOnLongClickListener(v -> {
                if (listener != null) {
                    listener.onServerLongClick(server);
                }
                return true;
            });
        }
    }
}