package com.evalfinal.evalm4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookListFragment extends Fragment {

    private RecyclerView rvBooks;
    private List<Book> bookList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBooks = view.findViewById(R.id.rv_books);

        // Creamos una lista para los libros ficticios que se van a mostrar (emula la BBDD)
        bookList = crearLibrosFake();

        // Inicializamos y configuramos el adaptador del RecyclerView
        BookAdapter adapter = new BookAdapter(bookList);
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        // Implementamos el listener para la navegación
        adapter.setOnItemClickListener(position -> {
            Book selectedBook = bookList.get(position);
            BookListFragmentDirections.ActionBookListFragmentToBookDetailFragment action =
                    BookListFragmentDirections.actionBookListFragmentToBookDetailFragment(selectedBook);
            NavHostFragment.findNavController(BookListFragment.this).navigate(action);
        });
    }
    // Ayuda memoria constructor de Book:
    // Str title, Str author, Str shortDescription, Str longDescription, int imageResourceId
    private List<Book> crearLibrosFake() {
        List<Book> books = new ArrayList<>();
        // Book1
        books.add(new Book(
                "Ancient Arts",
                "Megan Williams",
                "Una saga épica donde el destino del mundo pende de un hilo.",
                "En el reino de Gatopia, un joven 'Félix the cat', es elegido por una" +
                        " profecía ancestral, para embarcarse en una búsqueda épica. Debe encontrar" +
                        " las Nueve Vidas Perdidas antes de que el malvado Rey de las Pulgas " +
                        "conquiste el reino.",
                R.drawable.book1));
        // Book2
        books.add(new Book(
                "Alicia en Zombielandia",
                "Leguis Carril Jr.",
                "Atrapantes giros en la historia, un clásico renovado.",
                "Alicia en Zombielandia es una novela que reimagina el clásico de" +
                        " Lewis Carroll con un giro apocalíptico. Alicia se encuentra en un páramo" +
                        " desolado, donde debe luchar por su supervivencia mientras busca al" +
                        " Conejo Blanco.",
                R.drawable.book2));
        // Book3
        books.add(new Book(
                "Dosifica tu paciencia",
                "Peras con Manzanas",
                "Tu mejor guía para el crecimiento personal.",
                "Nuevamente, 'PERAS CON MANZANAS', nos sorprende con esta obra que" +
                        " conjuga lo mejor entre experiencia y sentido común, enseñanzas que tanta" +
                        " falta le hacen a este mundo enloquecido por el buenismo absurdo y carente" +
                        " de toda lógica.",
                R.drawable.book3));
        return books;
    }
}