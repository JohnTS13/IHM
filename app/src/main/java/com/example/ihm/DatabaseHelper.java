/*package com.example.ihm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Initialize Variable
    private static final String DATABASE_NAME = "chavas_garden";
    private static final String TABLE1 = "flor";
    private static final String TABLE2 = "general";



    public DatabaseHelper(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int version ){
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create tables
        String flor = "CREATE TABLE flor(id_flor INTEGER PRIMARY KEY, nombre TEXT, temperatura TEXT,humedad TEXT, familia TEXT, reino TEXT, estado TEXT, habilitador TEXT)";
        String general = "CREATE TABLE general(id_general INTEGER PRIMARY KEY, temperatura TEXT, humedad TEXT)";
        db.execSQL(flor);
        db.execSQL(general);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop IF existing table
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        onCreate(db);
    }

    public Boolean onUpdateFlor(String id_flor, String estado, String habilitador){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int flor = Integer.parseInt(id_flor);
        contentValues.put("estado", estado);
        contentValues.put("habilitador", habilitador);
        contentValues.put("id_flor", flor);
        Cursor cursor = db.rawQuery(sql;: "SELECT * FROM flor WHERE id_flor=?", new String[] {flor});
        if (cursor.getCount()>0) {
            long resultado = db.update(table:"flor", nullColumnHack:null, contentValues);
            if (resultado == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return  false;
        }

    }

    public Boolean onUpdateGeneral(String id_general, String temperatura, String humedad){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int id_gen = Integer.parseInt(id_general);
        contentValues.put("temperatura", temperatura);
        contentValues.put("humedad", humedad);
        contentValues.put("id_general", id_gen);
        Cursor cursor = db.rawQuery(sql: "SELECT * FROM general WHERE id_general= ?", new String[] {id_gen});
        if (cursor.getCount()>0) {
            long resultado = db.update(table:"general", nullColumnHack:null, contentValues);

            if (resultado == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    /*public Boolean onDeleteFlor(String id_flor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int flor = Integer.parseInt(id_flor);
        String[] args = new String[]{"0"};
        Cursor cursor = db.rawQuery(sql: "SELECT * FROM flor WHERE id_flor= ?", new String[] {flor});
        if (cursor.getCount()>0) {
            long resultado = db.update("flor", "habilitador", args);

            if (resultado == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM flor", null);
        return  cursor;
    }
}*/
