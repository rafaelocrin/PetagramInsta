package com.zocrosfera.petagraminsta.restApi.model;

import com.zocrosfera.petagraminsta.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 12/12/16.
 */

public class ContactoResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
