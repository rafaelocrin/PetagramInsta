package com.zocrosfera.petagraminsta.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zocrosfera.miscontactos.R;
import com.zocrosfera.petagraminsta.adapter.ContactoAdaptador;
import com.zocrosfera.petagraminsta.adapter.FollowerAdaptador;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.presentador.IRecyclerViewFragmentPresenter;
import com.zocrosfera.petagraminsta.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 15/12/16.
 */

public class FollowerFragment extends Fragment implements IFollowerFragment{

    private ArrayList<Follower> followers;
    private RecyclerView listaFollowers;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaFollowers = (RecyclerView)v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFollowers.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayoutVertical() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        listaFollowers.setLayoutManager(gridLayoutManager);
    }

    @Override
    public FollowerAdaptador crearFollowerAdaptador(ArrayList<Follower> followers) {
        return new FollowerAdaptador(followers, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(FollowerAdaptador adaptador) {
        listaFollowers.setAdapter(adaptador);
    }
}
