package com.houtrry.coordinatorlayoutsamples.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.houtrry.coordinatorlayoutsamples.R;
import com.houtrry.coordinatorlayoutsamples.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/14 14:05
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class PagerFragment extends Fragment {

    private static final String ARG_TITLE = "arg_title";
    private Activity mActivity;

    public static Fragment newInstance(String title) {
        PagerFragment pagerFragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(ARG_TITLE, new String[]{title});
        pagerFragment.setArguments(bundle);
        return pagerFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_pager_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View rootView) {
        String titleStr = getArguments().getStringArray(ARG_TITLE)[0];
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(titleStr + ": 大漠孤烟直, " + i + " 长河落日圆");
        }
        CustomAdapter customAdapter = new CustomAdapter(data);
        recyclerView.setAdapter(customAdapter);
    }
}
