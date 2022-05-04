package com.example.best_ideas.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.best_ideas.Models.Projects;
import com.example.best_ideas.R;
import com.example.best_ideas.databinding.CustomItemMainRvBestBinding;

import java.util.ArrayList;

public class Adapter_bests_rv_main extends RecyclerView.Adapter<Adapter_bests_rv_main.bestTechnicalProjectsViewHolder> {
    private ArrayList<Projects> project_items;
    private onItemClickListenerRV listenerRV;
    private String key;

    public Adapter_bests_rv_main(String key, ArrayList<Projects> projects, onItemClickListenerRV listenerRV) {
        this.project_items = projects;
        this.listenerRV = listenerRV;
        this.key = key;
    }

    @NonNull
    @Override
    public bestTechnicalProjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_main_rv_best, parent, false);
        bestTechnicalProjectsViewHolder ViewHolder = new bestTechnicalProjectsViewHolder(v);

        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull bestTechnicalProjectsViewHolder holder, int position) {
        Projects projects = project_items.get(position);
        holder.bind(projects);
    }

    @Override
    public int getItemCount() {
        return project_items.size();
    }

    class bestTechnicalProjectsViewHolder extends RecyclerView.ViewHolder {
        CustomItemMainRvBestBinding binding;
        Projects projects;

        public bestTechnicalProjectsViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = CustomItemMainRvBestBinding.bind(itemView);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerRV.onItemClickedListener(projects);
                }
            });
        }

        public void bind(Projects projects) {
            this.projects = projects;

            binding.bestTvItemProjectName.setText(projects.getName());
            if (key.equals("Technical")) {
                binding.bestIvItemImg.setImageResource(R.drawable.technique);
            } else if (key.equals("Service")) {
                binding.bestIvItemImg.setImageResource(R.drawable.service);
            } else if (key.equals("Industrial")) {
                binding.bestIvItemImg.setImageResource(R.drawable.industrial);
            } else if (key.equals("Agricultural")) {
                binding.bestIvItemImg.setImageResource(R.drawable.agricultural);
            } else if (key.equals("CommercialAndFinancial")) {
                binding.bestIvItemImg.setImageResource(R.drawable.commercial);
            }
        }
    }
}
