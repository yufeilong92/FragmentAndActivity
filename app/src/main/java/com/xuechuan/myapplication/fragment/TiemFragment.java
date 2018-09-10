package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xuechuan.myapplication.R;
import com.xuechuan.myapplication.adapter.TitmeAdapter;

import java.util.List;

public class TiemFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ListView mLvFragment;
    public static final String INTERFACE_TIME = TiemFragment.class.getName() + "time";

    public TiemFragment() {
    }

    public static TiemFragment newInstance(String param1, String param2) {
        TiemFragment fragment = new TiemFragment();
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
        View view = inflater.inflate(R.layout.fragment_tiem, container, false);
        initView(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        List<String> list = mFunctionManger.invokefunction(INTERFACE_TIME, List.class);
        TitmeAdapter adapter = new TitmeAdapter(getActivity(), list);
        mLvFragment.setAdapter(adapter);
        mLvFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFunctionManger.invokefunction(INTERFACE_TIME,"参数");
            }
        });
    }

    private void initView(View view) {
        mLvFragment = (ListView) view.findViewById(R.id.lv_fragment);
    }


    @Override
    public String INTERFACE() {
        return INTERFACE_TIME;
    }
    @Override
    public Context c() {
        return getActivity();
    }
}
