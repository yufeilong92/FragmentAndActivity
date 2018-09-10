package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.xuechuan.myapplication.BaseActivity;
import com.xuechuan.myapplication.Main2Activity;
import com.xuechuan.myapplication.MainActivity;
import com.xuechuan.myapplication.function.FunctionManger;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication.fragment
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 9:15
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public abstract class BaseFragment<T extends BaseActivity> extends Fragment {
    public static final String TAG = "【" + BaseFragment.class.getSimpleName() + "】==：";
    protected FunctionManger mFunctionManger;
    private BaseActivity mBaseActivity;

    public void setFunctionManger(FunctionManger functionManger) {
        this.mFunctionManger = functionManger;
    }

    public abstract String INTERFACE();

    public abstract Context c();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (c()==context){
            mBaseActivity = (BaseActivity) context;
            mBaseActivity.setFunctionManger(getTag(), INTERFACE(), INTERFACE(), INTERFACE(), INTERFACE());
        }
    /*    if (context instanceof MainActivity ) {
       }*/
    }

}
