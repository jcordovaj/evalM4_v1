package com.evalfinal.evalm4;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String titulo;
    private String autor;
    private String fraseCorta;
    private String descripcion;
    private int idImagen;

    // Constructor
    public Book(String titulo, String autor, String fraseCorta,
                String descripcion, int idImagen) {
        this.titulo      = titulo;
        this.autor       = autor;
        this.fraseCorta  = fraseCorta;
        this.descripcion = descripcion;
        this.idImagen    = idImagen;
    }

    // Getters
    public String getTitulo() {

        return titulo;
    }

    public String getAutor() {

        return autor;
    }

    public String getFraseCorta() {

        return fraseCorta;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public int getIdImagen() {

        return idImagen;
    }

    // Implementación de Parcelable para pasar objetos entre fragments
    protected Book(Parcel in) {
        titulo      = in.readString();
        autor       = in.readString();
        fraseCorta  = in.readString();
        descripcion = in.readString();
        idImagen    = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {

            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {

            return new Book[size];
        }
    };

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(autor);
        dest.writeString(fraseCorta);
        dest.writeString(descripcion);
        dest.writeInt(idImagen);
    }
}