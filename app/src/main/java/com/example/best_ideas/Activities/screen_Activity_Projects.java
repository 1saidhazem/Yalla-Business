package com.example.best_ideas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.best_ideas.Adapters.Adapter_Pager_Category;
import com.example.best_ideas.Fragments.ItemsFragment;
import com.example.best_ideas.Models.Projects;
import com.example.best_ideas.databinding.ActivityScreenProjectsBinding;
import com.example.best_ideas.Adapters.onItemClickListenerRV;

import java.util.ArrayList;

public class screen_Activity_Projects extends AppCompatActivity implements onItemClickListenerRV {

    ActivityScreenProjectsBinding binding;
    public static String key;
//    private String tabs[] = {"المشاريع الكبيرة", "المشاريع المتوسطة", "المشاريع الصغيرة"};
//    private static DatabaseAccess db;
//    String category, name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScreenProjectsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        db = DatabaseAccess.getInstance(this);
//        db.open();

        Intent intent = getIntent();
        key = intent.getStringExtra(MainActivity.key);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(ItemsFragment.newInstance(key));

        {//        int i;
//        for (i = 0; i >= projects.size(); i++) {
//            category = projects.get(i).getCategory();
//            name = projects.get(i).getName();
//            description = projects.get(i).getDescription();
//        }
//        String category = String.valueOf(getProductsByCategory("المشاريع الكبيرة"));

//        ArrayList<Projects> list1 = null;
//        int i = 0;
//        if (key.equals("Technical")){
//            list1=db.getAllProjectByCategory("TechnicalProjects");
//            for (i=0 ;i<=list1.size();i++){
//
//            }
//        }else if (key.equals("Service")){
//            list1=db.getAllProjectByCategory("ServiceProjects");
//        }else if (key.equals("Industrial")){
//            list1=db.getAllProjectByCategory("IndustrialProjects");
//        }else if (key.equals("Agricultural")){
//            list1=db.getAllProjectByCategory("AgriculturalProjects");
//        }else if (key.equals("CommercialAndFinancial")){
//            list1=db.getAllProjectByCategory("CommercialAndFinancialProjects");
//        }

//        list.add(ItemsFragment.newInstance("name",key));
//        list.add(ItemsFragment.newInstance("name", key));
        }

        Adapter_Pager_Category adapter_pager_category =
                new Adapter_Pager_Category(this, list);
        binding.pager.setAdapter(adapter_pager_category);

//        new TabLayoutMediator(binding.tabCategory, binding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//
//                tab.setText(String.valueOf(tabs[position]));
//            }
//        }).attach();

    }

    @Override
    public void onItemClickedListener(Projects projects) {
        String name = projects.getName();
        String description = projects.getDescription();
        String cost = projects.getCost();
//        int img = projects.getImg();
        Intent intent = new Intent(getBaseContext(), Project_Details_Activity.class);
        intent.putExtra("name",name);
        intent.putExtra("description",description);
        intent.putExtra("cost",cost);
        startActivity(intent);
    }

//    public static ArrayList<Projects> getProductsByCategory(String category) {
//        ArrayList<Projects> all=null;
//        if (MainActivity.key.equals("Technical")) {
//            all = db.getAllTechnicalProjects();
//            for (int i = 0; i < all.size(); i++) {
//                if (all.get(i).getCategory().equals(category)) {
//                    all.add(all.get(i));
//                }
//            }
//        }
//        else if (MainActivity.key.equals("Service")) {
//            all = db.getAllServiceProjects();
//            for (int i = 0; i < all.size(); i++) {
//                if (all.get(i).getCategory().equals(category)) {
//                    all.add(all.get(i));
//                }
//            }
//        }
//        else if (MainActivity.key.equals("Industrial")) {
//            all = db.getAllIndustrialProjects();
//            for (int i = 0; i < all.size(); i++) {
//                if (all.get(i).getCategory().equals(category)) {
//                    all.add(all.get(i));
//                }
//            }
//        }
//        else if (MainActivity.key.equals("Agricultural")) {
//            all = db.getAllAgriculturalProjects();
//            for (int i = 0; i < all.size(); i++) {
//                if (all.get(i).getCategory().equals(category)) {
//                    all.add(all.get(i));
//                }
//            }
//        }
//        else if (MainActivity.key.equals("CommercialAndFinancial")) {
//            all = db.getAllCommercialAndFinancialProjects();
//            for (int i = 0; i < all.size(); i++) {
//                if (all.get(i).getCategory().equals(category)) {
//                    all.add(all.get(i));
//                }
//            }
//        }
//
//
//            return all;
//        }

}
