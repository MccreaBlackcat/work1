package com.example.thinkpad.work1;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class AFragment extends Fragment {
    //碎片管理器
    FragmentManager fm;

    //碎片C
    CFragment cFragment;

    ListView lv_title;

    String[] mData = {"aaa","bbb","ccc","ddd","eee","fff","ggg","hhh","iii","jjj","kkk","lll","mmm","nnn","ooo","ppp"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_a,container ,false);
        View view = inflater.inflate(R.layout.fragment_a,null);
        fm = getFragmentManager();
        lv_title = (ListView) view.findViewById(R.id.lv_title);
        MyAdapter myAdapter = new MyAdapter(mData,inflater);
        lv_title.setAdapter(myAdapter);
        lv_title.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fm.beginTransaction().hide(cFragment).commit();
                cFragment = new CFragment();
                //添加到碎片管理器中
                Bundle bundle = new Bundle();
                bundle.putString("title",mData[position]);
                cFragment.setArguments(bundle);
                fm.beginTransaction().add(R.id.fl_fragContainer,cFragment).commit();
                fm.beginTransaction().show(cFragment).commit();
            }
        });

        //若AFragment未实例化过
        if (cFragment == null) {
            //实例化
            cFragment = new CFragment();
            //添加到碎片管理器中
            Bundle bundle = new Bundle();
            bundle.putString("title",mData[0]);
            cFragment.setArguments(bundle);
            fm.beginTransaction().add(R.id.fl_fragContainer,cFragment).commit();

        }
        //若已经实例化，直接展示
        else{
            fm.beginTransaction().show(cFragment).commit();
        }

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
