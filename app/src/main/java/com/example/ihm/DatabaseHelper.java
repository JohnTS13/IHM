package com.example.ihm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Initialize Variable
    private static final String DATABASE_NAME = "chavas_garden";
    private static final int VERSION_DB = 1;
    private static final String TABLE1 = "flor";
    private static final String TABLE2 = "general";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION_DB);
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

    //mostrar datos
    public List<flor_planta> mostrarFlor(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE1+" WHERE habilitador=1", null);
        List<flor_planta> cursos = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                cursos.add(new flor_planta(cursor.getString(0), cursor.getString(1), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
            }while (cursor.moveToNext());
        }
        return cursos;
    }

    public void onInsertFlor(int id_flor){
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null){
            db.execSQL("UPDATE flor SET id_flor='"+ id_flor + "', habilitador='1'");
            db.close();
        }

    }
    public void onUpdateEstado(int id_flor, String estado){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("UPDATE flor SET id_flor='"+ id_flor + "', estado='"+ estado +"'");
            db.close();
        }

    }

    public void onUpdateGeneral(int id_general, String temperatura, String humedad){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("UPDATE general SET id_general='"+ id_general + "', temperatura='"+ temperatura +"', humedad='"+ humedad +"'");
            db.close();
        }
    }

    public void onDeleteFlor(int id_flor){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("UPDATE flor SET id_flor='"+ id_flor + "', habilitador='0'");
            db.close();
        }
    }

    public void agregaFlor(int id_flor, String nombre, String temperatura, String humedad, String familia, String reino, String estado, String habilitador){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("INSERT INTO flor VALUES ("+id_flor+",'"+nombre+"','"+temperatura+"','"+familia+"','"+reino+"','"+estado+"','"+habilitador+"'");
            db.close();
        }
    }
}
