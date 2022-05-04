package com.example.best_ideas.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.best_ideas.Adapters.adapterProjects;
import com.example.best_ideas.Database.DatabaseAccess;
import com.example.best_ideas.Models.Projects;
import com.example.best_ideas.databinding.FragmentItemsBinding;
import com.example.best_ideas.Adapters.onItemClickListenerRV;
import com.example.best_ideas.Adapters.onItemClickedPositionRV;

import java.util.ArrayList;


public class ItemsFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";
    private static final String ARG_PROJECT_KEY = "key";

    private String  key;  // category,
    private onItemClickListenerRV listener;

    DatabaseAccess db;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onItemClickListenerRV){
            listener = (onItemClickListenerRV) context;
        }
        else throw new ClassCastException("error Class Cast Exception");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public ItemsFragment() {
        // Required empty public constructor
    }

    public static ItemsFragment newInstance(String key) {  // String categoryName,
        ItemsFragment fragment = new ItemsFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_CATEGORY, categoryName);
        args.putString(ARG_PROJECT_KEY, key);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//          category = getArguments().getString(ARG_CATEGORY);
            key = getArguments().getString(ARG_PROJECT_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentItemsBinding binding = FragmentItemsBinding.inflate
                (getLayoutInflater(), container, false);

        db = DatabaseAccess.getInstance(getContext());
        db.open();

        adapterProjects adapter_rv_fragment = null;

        if (key.equals("Technical")) {
            ArrayList<Projects> projects = db.getAllTechnicalProjects();
            adapter_rv_fragment = new adapterProjects(projects, new onItemClickedPositionRV() {
                @Override
                public void onItemClickedPosition(int position) {
                    Projects p1 = projects.get(position);
                    listener.onItemClickedListener(p1);
                }
            });
            ini_rv(binding.fragmentItemsRV, adapter_rv_fragment);
        }
        else if (key.equals("Service")) {
            ArrayList<Projects> projects = db.getAllServiceProjects();
            adapter_rv_fragment = new adapterProjects(projects, new onItemClickedPositionRV() {
                @Override
                public void onItemClickedPosition(int position) {
                    Projects p1 = projects.get(position);
                    listener.onItemClickedListener(p1);
                }
            });
            ini_rv(binding.fragmentItemsRV, adapter_rv_fragment);
        }
        else if (key.equals("Industrial")) {
            ArrayList<Projects> projects = db.getAllIndustrialProjects();
            adapter_rv_fragment = new adapterProjects(projects, new onItemClickedPositionRV() {
                @Override
                public void onItemClickedPosition(int position) {
                    Projects p1 = projects.get(position);
                    listener.onItemClickedListener(p1);
                }
            });
            ini_rv(binding.fragmentItemsRV, adapter_rv_fragment);
        }
        else if (key.equals("Agricultural")) {
            ArrayList<Projects> projects = db.getAllAgriculturalProjects();
            adapter_rv_fragment = new adapterProjects(projects, new onItemClickedPositionRV() {
                @Override
                public void onItemClickedPosition(int position) {
                    Projects p1 = projects.get(position);
                    listener.onItemClickedListener(p1);
                }
            });
            ini_rv(binding.fragmentItemsRV, adapter_rv_fragment);
        }
        else if (key.equals("CommercialAndFinancial")) {
            ArrayList<Projects> projects = db.getAllCommercialAndFinancialProjects();
            adapter_rv_fragment = new adapterProjects(projects, new onItemClickedPositionRV() {
                @Override
                public void onItemClickedPosition(int position) {
                    Projects p1 = projects.get(position);
                    listener.onItemClickedListener(p1);
                }
            });
            ini_rv(binding.fragmentItemsRV, adapter_rv_fragment);
        }

        return binding.getRoot();
    }

    private void ini_rv(RecyclerView rv, adapterProjects adapter) {
        rv.setAdapter(adapter);
        rv.setHasFixedSize(false);
        rv.setLayoutManager(new
                LinearLayoutManager(requireContext(),
                RecyclerView.VERTICAL, false));
    }
}