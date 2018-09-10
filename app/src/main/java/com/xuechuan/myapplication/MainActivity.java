package com.xuechuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.xuechuan.myapplication.adapter.FragemntAdapter;
import com.xuechuan.myapplication.adapter.TitmeAdapter;
import com.xuechuan.myapplication.fragment.NoParameNoRsult;
import com.xuechuan.myapplication.fragment.WPWR;
import com.xuechuan.myapplication.fragment.WParameNoRsult;
import com.xuechuan.myapplication.fragment.WResultOnly;
import com.xuechuan.myapplication.vo.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    public static final String TAG = "【" + MainActivity.class.getSimpleName() + "】==：";
    private ViewPager mViewpager;
    private TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<Fragment> mFragmets = addFragment();
        List<String> strings = addTitle();
        FragemntAdapter adapter = new FragemntAdapter(getSupportFragmentManager(), strings, mFragmets);
        mViewpager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewpager, true);
    }

    private List<String> addTitle() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("无参果");
        objects.add("有参");
        objects.add("有果");
        objects.add("有参果");
        return objects;
    }

    private List<Fragment> addFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(NoParameNoRsult.newInstance("", ""));
        fragments.add(WParameNoRsult.newInstance("", ""));
        fragments.add(WResultOnly.newInstance("", ""));
        fragments.add(WPWR.newInstance("", ""));
        return fragments;
    }

    @Override
    public void NParamNResultMethod() {
//        Log.e(TAG, "NParamNResultMethod: ");
    startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    @Override
    public <Parame> void WParamNResultMethod(Parame parame) {
        Log.e(TAG, "WParamNResultMethod: " + parame);
    }

    @Override
    public <Result> Result NParamWResultMethod() {
        Log.e(TAG, "NParamWResultMethod: " );
        Student student = new Student();
        student.setAge("12");
        student.setId(1);
        student.setName("小明");
        ArrayList<Student> list = new ArrayList<>();
        list.add(student);
        return (Result) list;
    }

    @Override
    public <Result, Paramet> Result ParamAndResultMethod(Paramet paramet) {
        Log.e(TAG, "ParamAndResultMethod: " + paramet);
        Student student = new Student();
        student.setName("小米");
        student.setAge("13");
        student.setId(2);
        return (Result) student;
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
    }
}
