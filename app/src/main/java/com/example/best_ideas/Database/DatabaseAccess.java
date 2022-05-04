package com.example.best_ideas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.best_ideas.Models.Projects;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DataBase(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = this.openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }



    // دالة استرجاع بيانات أفضل المشاريع التقنية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getBestTechnicalProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_TECHNICAL_PROJECTS + " LIMIT 5 ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_COST));
                Projects p = new Projects(name, description, image ,cost);// category
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    public boolean addTechnicalImg(byte[] img) {
        ContentValues values = new ContentValues();
        values.put(DataBase.TECHNICAL_PROJECTS_IMG, img);
        long result = database.insert(DataBase.TB_TECHNICAL_PROJECTS, null, values);

        return result != -1;
    }

    // دالة استرجاع بيانات أفضل المشاريع التجارية و المالية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getBestCommercialAndFinancialProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_COMMERCIAL_AND_FINANCIAL_PROJECTS + " LIMIT 5 ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_COST));
                Projects p = new Projects(name, description, image ,cost);// , category
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع بيانات أفضل المشاريع الصناعية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getBestIndustrialProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_INDUSTRIAL_PROJECTS + " LIMIT 5 ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_COST));
                Projects p = new Projects(name,description,image,cost);// , category
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع بيانات أفضل المشاريع الخدماتية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getBestServiceProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_SERVICE_PROJECTS + " LIMIT 5 ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_COST));
                Projects p = new Projects(name,description,image,cost);//  category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع بيانات أفضل المشاريع الزراعية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getBestAgriculturalProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_AGRICULTURAL_PROJECTS + " LIMIT 5 ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_IMG));
                String category = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_COST));
                Projects p = new Projects(name,description,image,cost);// category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }


    // دالة استرجاع بيانات كل المشاريع الزراعية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getAllAgriculturalProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_AGRICULTURAL_PROJECTS, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.AGRICULTURAL_PROJECTS_COST));
                Projects p = new Projects(name,description,image,cost);// category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع بيانات كل المشاريع التجارية و المالية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getAllCommercialAndFinancialProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_COMMERCIAL_AND_FINANCIAL_PROJECTS, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.COMMERCIAL_AND_FINANCIAL_PROJECTS_COST));
                Projects p = new Projects(name,description,image,cost);// category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع كل أفضل المشاريع الصناعية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getAllIndustrialProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_INDUSTRIAL_PROJECTS, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.INDUSTRIAL_PROJECTS_COST));
                Projects p = new Projects(name, description,image,cost);// category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع كل أفضل المشاريع الخدماتية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getAllServiceProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_SERVICE_PROJECTS, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.SERVICE_PROJECTS_COST));
                Projects p = new Projects(name, description,image,cost);//  category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }

    // دالة استرجاع كل أفضل المشاريع التقنية لعرضها في الشاشة الرئيسية
    public ArrayList<Projects> getAllTechnicalProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DataBase.TB_TECHNICAL_PROJECTS, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_NAME));
                String description = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_DESCRIPTION));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_IMG));
//                String category = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_CATEGORY));
                String cost = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_COST));
                Projects p = new Projects(name, description,image,cost);//  category,
                projects.add(p);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return projects;
    }


// public ArrayList<Projects> getAllProjectByCategory(String tn) {
////        ArrayList<Projects> projects = new ArrayList<>();
////        Cursor cursor = database.rawQuery("SELECT * FROM " + tn,null);
////
////        if (cursor != null && cursor.moveToFirst()) {
////            do {
////                String catego = cursor.getString(cursor.getColumnIndex(DataBase.TECHNICAL_PROJECTS_CATEGORY));
////
////                Projects p1 = new Projects(catego);
////                projects.add(p1);
////            }
////            while (cursor.moveToNext());
////            cursor.close();
////        }
////        return projects;
////    }

}
