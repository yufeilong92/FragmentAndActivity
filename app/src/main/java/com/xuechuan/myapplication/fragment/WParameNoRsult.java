package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xuechuan.myapplication.R;

public class WParameNoRsult extends BaseFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button mBtn2;
    public static final String INTERFACE_WITHPARAM = WParameNoRsult.class.getName() + "WPNR";

    public WParameNoRsult() {
    }


    public static WParameNoRsult newInstance(String param1, String param2) {
        WParameNoRsult fragment = new WParameNoRsult();
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
        View view = inflater.inflate(R.layout.fragment_wparame_no_rsult, container, false);
        initView(view);
        return view;
    }

    public void onButtonPressed() {
        mFunctionManger.invokefunction(INTERFACE_WITHPARAM, "你好");
    }

    private void initView(View view) {
        mBtn2 = (Button) view.findViewById(R.id.btn_2);

        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_2:
                onButtonPressed();
                break;
        }
    }


    @Override
    public String INTERFACE() {
        return INTERFACE_WITHPARAM;
    }
    @Override
    public Context c() {
        return getActivity();
    }
}
