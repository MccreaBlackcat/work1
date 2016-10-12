package com.example.thinkpad.work1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * @description 展示fragment用法的Activity
 */
public class FragActivity extends FragmentActivity {

    //碎片管理器
    FragmentManager mFm;

    //碎片事务
    FragmentTransaction mFt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        //实例化碎片管理器
        mFm = getSupportFragmentManager();

        addFragmentB();
    }

    /**
     * @description 向碎片管理器中添加碎片B
     */
    private void addFragmentB() {
        //实例化碎片B
        BFragment bFragment = new BFragment();
        //实例化一个碎片事务
        mFt = mFm.beginTransaction();
        //执行一个添加事务碎片
        mFt.add(R.id.fl_fragContainer, bFragment, "TAGB");
        //提交事务
        mFt.commit();
    }

    public void addClick(View view) {
        //找到某个Fragment
        Fragment fragmentB = mFm.findFragmentByTag("TAGB");
        if (fragmentB == null) {
            addFragmentB();
        }
    }
    /**
     * @description 控件点击监听
     * @param view view
     */
    public void removeClick(View view) {
        switch (view.getId()) {
            case R.id.btn_removeB:
                //找到某个Fragment
                Fragment fragmentB = mFm.findFragmentByTag("TAGB");
                //防止重复删除
                if (fragmentB != null) {
                    //开启一个碎片事务
                    mFt = mFm.beginTransaction();
                    //移除对应碎片
                    mFt.remove(fragmentB);
                    //提交事务
                    mFt.commit();
                    break;
                }
        }
    }
}
