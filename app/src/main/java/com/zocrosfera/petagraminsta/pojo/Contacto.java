package com.zocrosfera.petagraminsta.pojo;

/**
 * Created by rafaelocrin on 5/11/16.
 */

public class Contacto {
    private String nombreCompleto;
    private String urlFoto;
    private String id;
    private int likes = 0;

    public Contacto()
    {

    }
    public Contacto(String nombreCompleto, String urlFoto, int likes) {
        this.nombreCompleto = nombreCompleto;
        this.urlFoto = urlFoto;
        this.likes = likes;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
