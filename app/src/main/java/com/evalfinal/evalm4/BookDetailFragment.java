package com.evalfinal.evalm4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.evalfinal.evalm4.databinding.FragmentBookDetailBinding;

public class BookDetailFragment extends Fragment {

    private FragmentBookDetailBinding binding;

    public BookDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Obtener el objeto Book
        Book book = BookDetailFragmentArgs.fromBundle(getArguments()).getBook();

        // 2. Mostrar la información en los elementos de la vista
        if (book != null) {
            binding.bookTitulo.setText(book.getTitulo());
            binding.bookAutor.setText(book.getAutor());
            binding.bookFrase.setText(book.getFraseCorta());
            binding.bookDescripcion.setText(book.getDescripcion());

            // 3. Cargar la imagen usando Glide
            Glide.with(this)
                    .load(book.getIdImagen())
                    .into(binding.bookImage);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}