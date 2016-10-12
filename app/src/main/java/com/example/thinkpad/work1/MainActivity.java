package com.example.thinkpad.work1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    //碎片管理器
    FragmentManager fm;

    //碎片A
    AFragment aFragment;

    //碎片B
    BFragment bFragment;

    //单选按钮组
    RadioGroup rg_main;

    //fragment list 碎片列表
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //加载单选组
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        //获得碎片管理器
        fm = getSupportFragmentManager();
        //给单选按钮设置监听
        rg_main.setOnCheckedChangeListener(this);

        //若AFragment未实例化过
        if (aFragment == null) {
            //实例化
            aFragment = new AFragment();
            //添加到碎片管理器中
            fm.beginTransaction().add(R.id.fl_container,aFragment).commit();
            //添加至碎片列表
            fragmentList.add(aFragment);
        }
        //若已经实例化，直接展示
        else{
            fm.beginTransaction().show(aFragment).commit();
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        hideAllFragment();
        switch (checkedId) {
            case R.id.rb_a:
                //若AFragment未实例化过
                if (aFragment == null) {
                    //实例化
                    aFragment = new AFragment();
                    //添加到碎片管理器中
                    fm.beginTransaction().add(R.id.fl_container,aFragment).commit();
                    //添加至碎片列表
                    fragmentList.add(aFragment);
                }
                //若已经实例化，直接展示
                else{
                    fm.beginTransaction().show(aFragment).commit();
                }
                break;
            case R.id.rb_b:
                //若AFragment未实例化过
                if (bFragment == null) {
                    //实例化
                    bFragment = new BFragment();
                    //添加到碎片管理器中
                    fm.beginTransaction().add(R.id.fl_container,bFragment).commit();
                    //添加至碎片列表
                    fragmentList.add(bFragment);
                }
                //若已经实例化，直接展示
                else{
                    fm.beginTransaction().show(bFragment).commit();
                }
                break;
            default:
                break;
        }
    }

    private void hideAllFragment() {
        //遍历碎片列表
        for (int i = 0 ; i < fragmentList.size() ; i ++) {
            //隐藏碎片布局
            fm.beginTransaction().hide(fragmentList.get(i)).commit();
        }
    }

}
