package com.evalfinal.evalm4;

// Librerías

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final List<Book> bookList;
    private OnItemClickListener listener;

    // Listener para los botones
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.listener = listener;
    }

    public BookAdapter(List<Book> bookList) {

        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent,
                false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book currentBook = bookList.get(position);

        // con "Glide" mejoramos el rendimiento en la carga de imágenes
        Glide.with(holder.itemView.getContext())
                .load(currentBook.getIdImagen())
                .into(holder.bookImg);

        // Gestiona título y descripción
        holder.bookTitulo.setText(currentBook.getTitulo());
        holder.fraseCorta.setText(currentBook.getFraseCorta());
    }

    @Override
    public int getItemCount() {

        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public ImageView bookImg;
        public TextView bookTitulo;
        public TextView fraseCorta;
        public Button btnVerDetalle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImg       = itemView.findViewById(R.id.iv_book_img);
            bookTitulo    = itemView.findViewById(R.id.tv_book_titulo);
            fraseCorta    = itemView.findViewById(R.id.tv_frase_corta);
            btnVerDetalle = itemView.findViewById(R.id.btn_ver_detalles);

            // Listener para el botón de "Más detalles"
            btnVerDetalle.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
