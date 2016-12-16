package com.zocrosfera.petagraminsta.fragment;

import com.zocrosfera.petagraminsta.adapter.ContactoAdaptador;
import com.zocrosfera.petagraminsta.adapter.ProfileFollowerAdaptador;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.PhotoProfileFollower;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 16/12/16.
 */

public interface IPerfilFragment {
    public void generarLinearLayoutVertical();

    public void generarGridLayoutVertical();

    public ProfileFollowerAdaptador crearPhotoPFollowerAdaptador(ArrayList<PhotoProfileFollower> photoProfileFollowers);

    public void inicializarAdaptadorRV(ProfileFollowerAdaptador adaptador);
}
