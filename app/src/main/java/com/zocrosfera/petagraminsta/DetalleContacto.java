package com.zocrosfera.petagraminsta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zocrosfera.miscontactos.R;

public class DetalleContacto extends AppCompatActivity {


//    private TextView tvNombre;
//    private TextView tvTelefono;
//    private TextView tvEmail;

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        Bundle parametros = getIntent().getExtras();
        String url = parametros.getString("url");
        int likes = parametros.getInt("like");

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));
        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.flash)
                .into(imgFotoDetalle);
    }
//
//    public void llamar(View v) {
//        String telefono = tvTelefono.getText().toString();
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
//    }
//
//    public void enviarEmail(View v){
//
//        String email = tvEmail.getText().toString();
//        Intent emailIntent = new Intent(Intent.ACTION_SEND);
//        emailIntent.setData(Uri.parse("mailto:"));
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
//        emailIntent.setType("message/rfc822");
//        startActivity(Intent.createChooser(emailIntent, "Email "));
//    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }
}
