package com.evalfinal.evalm4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.evalfinal.evalm4.databinding.FragmentCreditsBinding;

public class CreditsFragment extends Fragment {
    private FragmentCreditsBinding binding;

    public CreditsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreditsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
