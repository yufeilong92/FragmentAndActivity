package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xuechuan.myapplication.R;
import com.xuechuan.myapplication.vo.Student;

import java.util.List;


public class WResultOnly extends BaseFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Button mBtn3;

    public WResultOnly() {
    }

    public static final String INTERFACE_WRESULT = WResultOnly.class.getName() + "WPNR";

    public static WResultOnly newInstance(String param1, String param2) {
        WResultOnly fragment = new WResultOnly();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_function_wresult_only, container, false);
        initView(view);
        return view;
    }

    public void onButtonPressed() {
        List<Student> list = mFunctionManger.invokefunction(INTERFACE_WRESULT, List.class);
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            Log.e(TAG, "onButtonPressed: " + student.getId() + student.getName() + student.getAge());
        }
    }


    private void initView(View view) {
        mBtn3 = (Button) view.findViewById(R.id.btn_3);
        mBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_3:
                onButtonPressed();
                break;
        }
    }

    @Override
    public String INTERFACE() {
        return INTERFACE_WRESULT;
    }
    @Override
    public Context c() {
        return getActivity();
    }
}
