package com.zocrosfera.petagraminsta.fragment;

import com.zocrosfera.petagraminsta.adapter.ContactoAdaptador;
import com.zocrosfera.petagraminsta.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayoutVertical();

    public ContactoAdaptador crearContactoAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
