package com.zocrosfera.petagraminsta.presentador;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public interface IRecyclerViewFragmentPresenter {

    public void obtenerContactosBaseDatos();

    //public void obtenerMediosRecientes(String id);

    public void obtenerFollowers();

    public void obtenerPhotoProfileFollower();

    public void mostrarContactosRV();

    public void mostrarFollowersRV();

    public void mostrarPhotoPFollowersRV();
}
