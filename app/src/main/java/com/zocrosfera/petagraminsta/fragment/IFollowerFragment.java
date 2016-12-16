package com.zocrosfera.petagraminsta.fragment;

import com.zocrosfera.petagraminsta.adapter.ContactoAdaptador;
import com.zocrosfera.petagraminsta.adapter.FollowerAdaptador;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.Follower;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 15/12/16.
 */

public interface IFollowerFragment {

    public void generarLinearLayoutVertical();

    public void generarGridLayoutVertical();

    public FollowerAdaptador crearFollowerAdaptador(ArrayList<Follower> followers);

    public void inicializarAdaptadorRV(FollowerAdaptador adaptador);
}
