package com.evalfinal.evalm4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class SplashFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencia al botón del layout
        Button goButton = view.findViewById(R.id.btn_go);

        // Listener al hacer clic en el botón
        goButton.setOnClickListener(v -> {
            NavController navController = NavHostFragment.findNavController(SplashFragment.this);
            navController.navigate(R.id.action_splashFragment_to_bookListFragment);
        });
    }
}