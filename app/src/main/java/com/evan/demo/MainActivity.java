package com.evan.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment finalHost = NavHostFragment.create(R.navigation.mobile_navigation);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.nav_host, finalHost)
//                .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
//                .commit();

        Navigation.findNavController(this, R.id.my_nav_host_fragment).addOnNavigatedListener(new NavController.OnNavigatedListener() {
            @Override
            public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                destination.getLabel();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp();
    }
}
