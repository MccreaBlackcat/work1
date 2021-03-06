package com.example.thinkpad.work1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InflaterActivity extends Activity {

    LinearLayout ll_inflate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);
        ll_inflate = (LinearLayout) findViewById(R.id.ll_inflater);

//        addText1();
//        addText2();
        addText3();

    }

    /**
     * 把一个文本添加到当前布局，inflate只有resource参数
     */
    public void addText1() {
        //实例化加载器
        LayoutInflater inflater = LayoutInflater.from(this);
        //加载一个文本布局，由于么有父容器，则layout_text中的layout相关属性会失效
        TextView tv_data = (TextView) inflater.inflate(R.layout.layout_text, null);
        //添加到当前的线性布局
        ll_inflate.addView(tv_data);
    }

    /**
     * 把一个文本添加到当前布局，inflate三个参数都有，但是attachToRoot为false
     */
    public void addText2() {
        //实例化加载器
        LayoutInflater inflater = LayoutInflater.from(this);
        //加载一个文本布局，此时attachToRoot为false,root作为resource的ViewGroup
        //但是resource不会添加到root中
        TextView tv_data = (TextView) inflater.inflate(R.layout.layout_text, ll_inflate,false);
        //手动添加到当前的线性布局
        ll_inflate.addView(tv_data);
    }

    /**
     * 把一个文本添加到当前布局，inflate三个参数都有，但是attachToRoot为true
     */
    public void addText3() {
        //实例化加载器
        LayoutInflater inflater = LayoutInflater.from(this);
        //加载一个文本布局，此时attachToRoot为false,root作为resource的ViewGroup
        //resource自动添加到root中
        inflater.inflate(R.layout.layout_text, ll_inflate,true);
    }
}
