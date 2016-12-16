package com.zocrosfera.petagraminsta.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zocrosfera.petagraminsta.adapter.RestApiAdapter;
import com.zocrosfera.petagraminsta.db.ConstructorContactos;
import com.zocrosfera.petagraminsta.fragment.IFollowerFragment;
import com.zocrosfera.petagraminsta.fragment.IPerfilFragment;
import com.zocrosfera.petagraminsta.fragment.IRecyclerViewFragmentView;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.pojo.PhotoProfileFollower;
import com.zocrosfera.petagraminsta.restApi.EndpointsApi;
import com.zocrosfera.petagraminsta.restApi.model.ContactoResponse;
import com.zocrosfera.petagraminsta.restApi.model.FollowerResponse;
import com.zocrosfera.petagraminsta.restApi.model.PhotoProfileFollowerResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private IFollowerFragment iFollowerFragment;
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;
    private ArrayList<Follower> followers;
    private ArrayList<PhotoProfileFollower> photoProfileFollowers;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        //obtenerMediosRecientes();
        obtenerFollowers();
    }


    public RecyclerViewFragmentPresenter(IFollowerFragment iFollowerFragment, Context context){
        this.iFollowerFragment = iFollowerFragment;
        this.context = context;
        //obtenerContactosBaseDatos();
        //obtenerMediosRecientes();
        obtenerFollowers();
    }

    public RecyclerViewFragmentPresenter(IPerfilFragment iPerfilFragment, Context context){
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        obtenerPhotoProfileFollower();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

//    @Override
//    public void obtenerMediosRecientes(String id) {
//
//        RestApiAdapter restApiAdapter = new RestApiAdapter();
//        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
//        //EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram();
//        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
//        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia(id);
//        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
//            @Override
//            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
//                ContactoResponse contactoResponse = response.body();
//                contactos = contactoResponse.getContactos();
//                mostrarContactosRV();
//            }
//
//            @Override
//            public void onFailure(Call<ContactoResponse> call, Throwable t) {
//                Toast.makeText(context, "Ha ocurrido un error de conexión, inténtalo novamete", Toast.LENGTH_SHORT).show();
//                Log.e("Fallo la conexión", t.toString());
//            }
//        });
//    }

    @Override
    public void obtenerFollowers() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonFollowers = restApiAdapter.construyeGsonDeserializadorFollowers();
        //EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonFollowers);
        Call<FollowerResponse> followerResponseCall = endpointsApi.getFollowers();
        followerResponseCall.enqueue(new Callback<FollowerResponse>() {
            @Override
            public void onResponse(Call<FollowerResponse> call, Response<FollowerResponse> response) {
                FollowerResponse followerResponse = response.body();
                followers = followerResponse.getFollowers();

                mostrarFollowersRV();
            }

            @Override
            public void onFailure(Call<FollowerResponse> call, Throwable t) {
                Toast.makeText(context, "Ha ocurrido un error de conexión, inténtalo novamete", Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexión", t.toString());
            }
        });
    }

    @Override
    public void obtenerPhotoProfileFollower() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonPhotoPFollowers = restApiAdapter.construyeGsonDeserializadorPhotoProfileFollowers();
        //EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonPhotoPFollowers);

        // TODO: pasar el id, de momento esta hardcodeado
        Call<PhotoProfileFollowerResponse> followerResponseCall = endpointsApi.getRecentMediaById();
        followerResponseCall.enqueue(new Callback<PhotoProfileFollowerResponse>() {
            @Override
            public void onResponse(Call<PhotoProfileFollowerResponse> call, Response<PhotoProfileFollowerResponse> response) {
                PhotoProfileFollowerResponse followerResponse = response.body();
                photoProfileFollowers = followerResponse.getPhotoProfileFollowers();

                mostrarPhotoPFollowersRV();
            }

            @Override
            public void onFailure(Call<PhotoProfileFollowerResponse> call, Throwable t) {
                Toast.makeText(context, "Ha ocurrido un error de conexión, inténtalo novamete", Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexión", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearContactoAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayoutVertical();
    }

    @Override
    public void mostrarFollowersRV() {
        iFollowerFragment.inicializarAdaptadorRV(iFollowerFragment.crearFollowerAdaptador(followers));
        iFollowerFragment.generarGridLayoutVertical();
    }


    @Override
    public void mostrarPhotoPFollowersRV() {
        iPerfilFragment.inicializarAdaptadorRV(iPerfilFragment.crearPhotoPFollowerAdaptador(photoProfileFollowers));
        iPerfilFragment.generarGridLayoutVertical();
    }
}
