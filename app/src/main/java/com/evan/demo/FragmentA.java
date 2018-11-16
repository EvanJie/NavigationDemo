package com.evan.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.a_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button next_btn = view.findViewById(R.id.next_button);
        next_btn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fragmentA_to_fragmentB));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavOptions options = new NavOptions.Builder()
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right)
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .build();

                Navigation.findNavController(v).navigate(R.id.action_fragmentA_to_fragmentB, null, options);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("AAAAA", "FragmentA destroy");
    }
}
