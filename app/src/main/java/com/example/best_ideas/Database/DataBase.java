package com.example.best_ideas.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBase extends SQLiteAssetHelper {

    public static final String DB_NAME = "best_ideas.db";
    public static final int DB_VERSION = 1;


    // جدول المشاريع الزراعية
    public static final String TB_AGRICULTURAL_PROJECTS ="AgriculturalProjects";
    public static final String AGRICULTURAL_PROJECTS_NAME ="Agricultural_name";
    public static final String AGRICULTURAL_PROJECTS_DESCRIPTION ="Agricultural_description";
    public static final String AGRICULTURAL_PROJECTS_CATEGORY ="Agricultural_category";
    public static final String AGRICULTURAL_PROJECTS_IMG ="Agricultural_img";
    public static final String AGRICULTURAL_PROJECTS_COST ="Agricultural_cost";

    // جدول المشاريع التجارية والمالية
    public static final String TB_COMMERCIAL_AND_FINANCIAL_PROJECTS ="CommercialAndFinancialProjects";
    public static final String COMMERCIAL_AND_FINANCIAL_PROJECTS_NAME ="CommercialAndFinancial_name";
    public static final String COMMERCIAL_AND_FINANCIAL_PROJECTS_DESCRIPTION ="CommercialAndFinancial_description";
    public static final String COMMERCIAL_AND_FINANCIAL_PROJECTS_CATEGORY ="CommercialAndFinancial_category";
    public static final String COMMERCIAL_AND_FINANCIAL_PROJECTS_IMG ="CommercialAndFinancial_img";
    public static final String COMMERCIAL_AND_FINANCIAL_PROJECTS_COST ="CommercialAndFinancial_cost";

    // جدول المشاريع الصناعية
    public static final String TB_INDUSTRIAL_PROJECTS ="IndustrialProjects";
    public static final String INDUSTRIAL_PROJECTS_NAME ="Industrial_name";
    public static final String INDUSTRIAL_PROJECTS_DESCRIPTION ="Industrial_description";
    public static final String INDUSTRIAL_PROJECTS_CATEGORY ="Industrial_category";
    public static final String INDUSTRIAL_PROJECTS_IMG ="Industrial_img";
    public static final String INDUSTRIAL_PROJECTS_COST ="Industrial_cost";

    // جدول المشاريع الخدماتية
    public static final String TB_SERVICE_PROJECTS ="ServiceProjects";
    public static final String SERVICE_PROJECTS_NAME ="Service_name";
    public static final String SERVICE_PROJECTS_DESCRIPTION ="Service_description";
    public static final String SERVICE_PROJECTS_CATEGORY ="Service_category";
    public static final String SERVICE_PROJECTS_IMG ="Service_img";
    public static final String SERVICE_PROJECTS_COST ="Service_cost";

    // جدول المشاريع التقنية
    public static final String TB_TECHNICAL_PROJECTS ="TechnicalProjects";
    public static final String TECHNICAL_PROJECTS_NAME ="Technical_name";
    public static final String TECHNICAL_PROJECTS_DESCRIPTION ="Technical_description";
    public static final String TECHNICAL_PROJECTS_CATEGORY ="Technical_category";
    public static final String TECHNICAL_PROJECTS_IMG ="Technical_img";
    public static final String TECHNICAL_PROJECTS_COST ="Technical_cost";



    public DataBase(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }
}
