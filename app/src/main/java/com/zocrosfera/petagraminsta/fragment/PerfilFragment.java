package com.zocrosfera.petagraminsta.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zocrosfera.miscontactos.R;
import com.zocrosfera.petagraminsta.adapter.ContactoAdaptador;
import com.zocrosfera.petagraminsta.adapter.ProfileFollowerAdaptador;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.PhotoProfileFollower;
import com.zocrosfera.petagraminsta.presentador.IRecyclerViewFragmentPresenter;
import com.zocrosfera.petagraminsta.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment{

    private ArrayList<Contacto> contactos;
    private RecyclerView listaPhotoProfileFollower;
    private IRecyclerViewFragmentPresenter presenter;

//    public PerfilFragment() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_follower, container, false);

        listaPhotoProfileFollower = (RecyclerView)v.findViewById(R.id.rvProfileFollower);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPhotoProfileFollower.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayoutVertical() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        listaPhotoProfileFollower.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ProfileFollowerAdaptador crearPhotoPFollowerAdaptador(ArrayList<PhotoProfileFollower> photoProfileFollowers) {
        return new ProfileFollowerAdaptador(photoProfileFollowers, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(ProfileFollowerAdaptador adaptador) {
        listaPhotoProfileFollower.setAdapter(adaptador);
    }
}
