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
import com.zocrosfera.miscontactos.R;
//import com.zocrosfera.miscontactos.DetalleFollower;
import com.zocrosfera.petagraminsta.pojo.Follower;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 14/12/16.
 */

public class FollowerAdaptador extends RecyclerView.Adapter<FollowerAdaptador.FollowerViewHolder>{

    ArrayList<Follower> followers;
    Activity activity;

    public FollowerAdaptador(ArrayList<Follower> followers, Activity activity){

        this.followers = followers;
        this.activity = activity;
    }

    @Override
    public FollowerAdaptador.FollowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_follower, parent, false);
        return new FollowerAdaptador.FollowerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FollowerAdaptador.FollowerViewHolder FollowerViewHolder, int position) {
        final FollowerAdaptador.FollowerViewHolder auxFollowerViewHolder = FollowerViewHolder;
        final Follower follower = followers.get(position);
        // FollowerViewHolder.imgfoto.setImageResource(Follower.getUrlFoto());
        Picasso.with(activity)
                .load(follower.getProfilePicture())
                .placeholder(R.drawable.flash)
                .into(FollowerViewHolder.imgfoto);

        FollowerViewHolder.tvNombreCV.setText(follower.getUserName());

//        FollowerViewHolder.imgfoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(activity, DetalleFollower.class);
//                intent.putExtra("url", Follower.getUrlFoto());
//                intent.putExtra("like", Follower.getLikes());
////                intent.putExtra("email", Follower.getEmail());
//                activity.startActivity(intent);
//            }
//        });

//        FollowerViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//                Constructorfollowers constructorfollowers = new Constructorfollowers(activity);
//                constructorfollowers.darLikeAlFollower(Follower);
//
//                auxFollowerViewHolder.tvLikes.setText(String.valueOf(constructorfollowers.obtenerLikesFollower(Follower))
//                + " Likes");
//
//                Toast.makeText(activity, "Diste like a " + Follower.getNombre(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    public static class FollowerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfoto;
        private TextView tvNombreCV;
//        private TextView tvTelefonoCV;
//        private ImageButton btnLike;
        //private TextView tvLikes;


        public FollowerViewHolder(View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
//            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefono);
//            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            //tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
