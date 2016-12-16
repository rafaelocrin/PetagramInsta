package com.zocrosfera.petagraminsta.db;

import android.content.ContentValues;
import android.content.Context;

import com.zocrosfera.miscontactos.R;
import com.zocrosfera.petagraminsta.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public class ConstructorContactos {

    private Context context;
    private ArrayList<Contacto> contactos;
    private static final int LIKE = 1;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Rafael Quirino");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "677555444");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "rafael@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.ironman);
        db.insertarContacto(contentValues);

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Mafalda");
        contentValues1.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "677555664");
        contentValues1.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mafalda@gmail.com");
        contentValues1.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.batman);
        db.insertarContacto(contentValues1);

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Pedro");
        contentValues2.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "677556644");
        contentValues2.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "pedro@gmail.com");
        contentValues2.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.flash);
        db.insertarContacto(contentValues2);
    }

    public void darLikeAlContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
