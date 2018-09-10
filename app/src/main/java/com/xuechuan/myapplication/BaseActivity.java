package com.xuechuan.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.xuechuan.myapplication.fragment.BaseFragment;
import com.xuechuan.myapplication.fragment.NoParameNoRsult;
import com.xuechuan.myapplication.fragment.WPWR;
import com.xuechuan.myapplication.fragment.WParameNoRsult;
import com.xuechuan.myapplication.fragment.WResultOnly;
import com.xuechuan.myapplication.function.FunctionManger;
import com.xuechuan.myapplication.function.FunctionNPNR;
import com.xuechuan.myapplication.function.FunctionPAndR;
import com.xuechuan.myapplication.function.FunctionWPOnly;
import com.xuechuan.myapplication.function.FunctionWROnly;
import com.xuechuan.myapplication.vo.Student;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 9:25
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public abstract class BaseActivity extends AppCompatActivity {
    public void setFunctionManger(String tag, String npr, String wp, String wr, String pandr) {
        FragmentManager f = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) f.findFragmentByTag(tag);
        FunctionManger functionManger = FunctionManger.getInstance();
        fragment.setFunctionManger(functionManger.addFucntion(new FunctionNPNR(npr) {
            @Override
            public void funciton() {

                NParamNResultMethod();
            }
        })
                .addFucntion(new FunctionWPOnly(wp) {

                    @Override
                    public void function(Object s) {
                        WParamNResultMethod(s);
                    }
                })
                .addFucntion(new FunctionWROnly(wr) {
                    @Override
                    public Object function() {
                        return NParamWResultMethod();
                    }
                })
                .addFucntion(new FunctionPAndR(pandr) {
                    @Override
                    public Object funciton(Object msg) {
                        return ParamAndResultMethod(msg);
                    }
                }));

    }

    public abstract void NParamNResultMethod();

    public abstract <Parame> void WParamNResultMethod(Parame parame);

    public abstract <Result> Result NParamWResultMethod();

    public abstract <Result, Paramet> Result ParamAndResultMethod(Paramet paramet);


}
