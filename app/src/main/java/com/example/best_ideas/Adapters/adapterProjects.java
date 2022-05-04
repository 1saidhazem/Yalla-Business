package com.example.best_ideas.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.best_ideas.Models.Projects;
import com.example.best_ideas.R;
import com.example.best_ideas.databinding.CustomItemRvBinding;
import com.example.best_ideas.Activities.screen_Activity_Projects;

import java.util.ArrayList;

public class adapterProjects extends RecyclerView.Adapter<adapterProjects.ViewHolder> {

    private ArrayList<Projects> projects ;
    private onItemClickedPositionRV listener ;

    public adapterProjects(ArrayList<Projects> projects, onItemClickedPositionRV listener) {
        this.projects = projects;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from
                (parent.getContext())
                .inflate(R.layout.custom_item_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Projects p = projects.get(position);
        holder.bind(p);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        CustomItemRvBinding binding;
        Projects projects;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomItemRvBinding.bind(itemView);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClickedPosition(getAdapterPosition());
                }
            });
        }

        public void bind(Projects projects){
            this.projects = projects;

            binding.customItemTvName.setText(projects.getName());
            if (screen_Activity_Projects.key.equals("Technical")){
                binding.customItemImg.setImageResource(R.drawable.technique);
            }
            else if (screen_Activity_Projects.key.equals("Service")){
                binding.customItemImg.setImageResource(R.drawable.service);
            }
            else if (screen_Activity_Projects.key.equals("Industrial")){
                binding.customItemImg.setImageResource(R.drawable.industrial);
            }
            else if (screen_Activity_Projects.key.equals("Agricultural")){
                binding.customItemImg.setImageResource(R.drawable.agricultural);
            }
            else if (screen_Activity_Projects.key.equals("CommercialAndFinancial")){
                binding.customItemImg.setImageResource(R.drawable.commercial);
            }

        }
    }
}
