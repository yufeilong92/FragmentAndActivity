package com.xuechuan.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

import com.xuechuan.myapplication.fragment.TiemFragment;

import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends BaseActivity {
    public static final String TAG = "【" + Main2Activity.class.getSimpleName() + "】==：";
    private FrameLayout mFlvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        FragmentManager f = getSupportFragmentManager();
        FragmentTransaction transaction = f.beginTransaction();
        transaction.replace(R.id.flv_content, new TiemFragment(),Main2Activity.class.getName());
        transaction.commit();
    }


    @Override
    public void NParamNResultMethod() {
    }

    @Override
    public <Parame> void WParamNResultMethod(Parame parame) {
        Log.e(TAG, "WParamNResultMethod: " + parame);
    }

    @Override
    public <Result> Result NParamWResultMethod() {
        ArrayList<String> list = new ArrayList<>();
        int a = 30;
        for (int i = 0; i < a; i++) {
            list.add(new Date().getTime() + "");
        }
        return (Result) list;
    }

    @Override
    public <Result, Paramet> Result ParamAndResultMethod(Paramet paramet) {
        return null;
    }

    private void initView() {
        mFlvContent = (FrameLayout) findViewById(R.id.flv_content);
    }
}
