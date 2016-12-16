package com.zocrosfera.petagraminsta.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.DetalleContacto;
import com.zocrosfera.miscontactos.R;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 9/11/16.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {


    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){

        this.contactos = contactos;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final ContactoViewHolder auxContactoViewHolder = contactoViewHolder;
        final Contacto contacto = contactos.get(position);
        // contactoViewHolder.imgfoto.setImageResource(contacto.getUrlFoto());
        Picasso.with(activity)
                .load(contacto.getUrlFoto())
                .placeholder(R.drawable.flash)
                .into(contactoViewHolder.imgfoto);

        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()));

        contactoViewHolder.imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("url", contacto.getUrlFoto());
                intent.putExtra("like", contacto.getLikes());
//                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

//        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
//                constructorContactos.darLikeAlContacto(contacto);
//
//                auxContactoViewHolder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikesContacto(contacto))
//                + " Likes");
//
//                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfoto;
//        private TextView tvNombreCV;
//        private TextView tvTelefonoCV;
//        private ImageButton btnLike;
        private TextView tvLikes;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.imgFoto);
//            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
//            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefono);
//            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
