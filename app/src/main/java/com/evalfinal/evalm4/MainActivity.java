package com.evalfinal.evalm4;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.evalfinal.evalm4.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_fragment_host);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
            BottomNavigationView bottomNav = binding.bottomNavigation;
            bottomNav.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.splashFragment) {
                    navController.popBackStack(R.id.splashFragment, false);
                    navController.navigate(R.id.splashFragment);
                } else if (itemId == R.id.bookListFragment) {
                    navController.popBackStack(R.id.bookListFragment, false);
                    navController.navigate(R.id.bookListFragment);
                } else if (itemId == R.id.creditsFragment) {
                    navController.popBackStack(R.id.creditsFragment, false);
                    navController.navigate(R.id.creditsFragment);
                } else {
                    Log.e(TAG, "ID de elemento no reconocido: " + itemId);
                }
                return true;
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}