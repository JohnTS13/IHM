package com.example.ihm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Initialize Variable
    private static final String DATABASE_NAME = "chavas_garden";
    private static final String TABLE1 = "division";
    private static final String TABLE2 = "cuidado";
    private static final String TABLE3 = "familia";
    private static final String TABLE4 = "estado";
    private static final String TABLE5 = "reino";
    private static final String TABLE6 = "flor";



    public DatabaseHelper(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int version ){
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create tables
        String division = "CREATE TABLE "+TABLE1+"(id_division INTEGER PRIMARY KEY, nombre TEXT)";
        String cuidado = "CREATE TABLE "+TABLE2+"(id_cuidado INTEGER PRIMARY KEY, nivel TEXT)";
        String familia = "CREATE TABLE "+TABLE3+"(id_familia INTEGER PRIMARY KEY, nombre TEXT)";
        String estado = "CREATE TABLE "+TABLE4+"(id_estado INTEGER PRIMARY KEY, estado TEXT)";
        String reino = "CREATE TABLE "+TABLE5+"(id_reino INTEGER PRIMARY KEY, nombre TEXT)";
        String flor = "CREATE TABLE "+TABLE6+"(id_flor INTEGER PRIMARY KEY, id_familia INTEGER," +
                "id_reino INTEGER, id_division INTEGER, id_cuidado INTEGER, id_estado INTEGER," +
                "nombre TEXT, genero TEXT, humedad TEXT, temperatura TEXT," +
                "FOREIGN KEY(id_familia) REFERENCES familia(id_familia)," +
                "FOREIGN KEY(id_reino) REFERENCES reino(id_freino)," +
                "FOREIGN KEY(id_division) REFERENCES division(id_division)," +
                "FOREIGN KEY(id_cuidado) REFERENCES cuidado(id_cuidado)," +
                "FOREIGN KEY(id_estado) REFERENCES estado(id_estado))";
        db.execSQL(division);
        db.execSQL(cuidado);
        db.execSQL(familia);
        db.execSQL(estado);
        db.execSQL(reino);
        db.execSQL(flor);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop existing table
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE4);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE5);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE6);
        onCreate(db);
    }
}
