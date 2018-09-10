package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xuechuan.myapplication.Main2Activity;
import com.xuechuan.myapplication.MainActivity;
import com.xuechuan.myapplication.R;

public class NoParameNoRsult extends BaseFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button mBtn1;

    public static final String INTERFACE_NPNR = NoParameNoRsult.class.getName() + "NPNR";

    public NoParameNoRsult() {
    }

    public static NoParameNoRsult newInstance(String param1, String param2) {
        NoParameNoRsult fragment = new NoParameNoRsult();
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
        View view = inflater.inflate(R.layout.fragment_no_parame_no_rsult, container, false);
        initView(view);
        return view;
    }

    public void onButtonPressed() {
        mFunctionManger.invokefunction(INTERFACE_NPNR);
    }

    private void initView(View view) {
        mBtn1 = (Button) view.findViewById(R.id.btn_1);

        mBtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                onButtonPressed();
                break;
        }
    }


    @Override
    public String INTERFACE() {
        return INTERFACE_NPNR;
    }

    @Override
    public Context c() {
        return getActivity();
    }
}
