package com.example.thinkpad.work1;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {


    TextView tv_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c, null);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(getArguments().getString("title"));


        return view;
    }

}
