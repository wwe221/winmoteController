package com.something.wimotetab;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

public class Fragment1 extends Fragment {
    ClThread cl;
    public Fragment1() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("프레그먼트1 @@");
        cl =((MainActivity) getActivity()).getCl();

        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }
}
