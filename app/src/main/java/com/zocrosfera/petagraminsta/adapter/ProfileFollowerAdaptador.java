package com.zocrosfera.petagraminsta.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zocrosfera.miscontactos.R;
import com.zocrosfera.petagraminsta.pojo.PhotoProfileFollower;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 15/12/16.
 */

public class ProfileFollowerAdaptador extends RecyclerView.Adapter<ProfileFollowerAdaptador.ProfileFollowerViewHolder>{

    ArrayList<PhotoProfileFollower> photoProfileFollowers;
    Activity activity;

    public ProfileFollowerAdaptador(ArrayList<PhotoProfileFollower> photoProfileFollowers, Activity activity){

        this.photoProfileFollowers = photoProfileFollowers;
        this.activity = activity;
    }

    @Override
    public ProfileFollowerAdaptador.ProfileFollowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_profile_follower, parent, false);
        return new ProfileFollowerAdaptador.ProfileFollowerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProfileFollowerAdaptador.ProfileFollowerViewHolder profileFollowerViewHolder, int position) {
        final ProfileFollowerAdaptador.ProfileFollowerViewHolder auxProfileFollowerViewHolder = profileFollowerViewHolder;
        final PhotoProfileFollower photoProfileFollower = photoProfileFollowers.get(position);
        // FollowerViewHolder.imgfoto.setImageResource(Follower.getUrlFoto());
        Picasso.with(activity)
                .load(photoProfileFollower.getUrlFoto())
                .placeholder(R.drawable.flash)
                .into(profileFollowerViewHolder.imgFotoPerfil);

        profileFollowerViewHolder.tvRatingPerfil.setText(photoProfileFollower.getRatings());

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
        return 0;
    }

    public static class ProfileFollowerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerfil;
        private TextView tvRatingPerfil;

        public ProfileFollowerViewHolder(View itemView) {
            super(itemView);
            imgFotoPerfil = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            tvRatingPerfil = (TextView) itemView.findViewById(R.id.tvRatingPerfil);
        }
    }
}
