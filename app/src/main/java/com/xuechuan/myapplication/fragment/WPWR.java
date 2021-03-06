package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xuechuan.myapplication.R;
import com.xuechuan.myapplication.vo.Student;


public class WPWR extends BaseFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button mBtn4;

    public WPWR() {
    }

    public static final String INTERFACE_WPWR = WPWR.class.getName() + "WPWR";

    public static WPWR newInstance(String param1, String param2) {
        WPWR fragment = new WPWR();
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
        View view = inflater.inflate(R.layout.fragment_wpwr, container, false);
        initView(view);
        return view;
    }

    public void onButtonPressed() {
        Student student = mFunctionManger.invokefunction(INTERFACE_WPWR, "我打你", Student.class);
        Log.e(TAG, "onButtonPressed: " + student.getAge() + student.getName() + student.getId());

    }


    private void initView(View view) {
        mBtn4 = (Button) view.findViewById(R.id.btn_4);

        mBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_4:
                onButtonPressed();
                break;
        }
    }


    @Override
    public String INTERFACE() {
        return INTERFACE_WPWR;
    }
    @Override
    public Context c() {
        return getActivity();
    }
}
