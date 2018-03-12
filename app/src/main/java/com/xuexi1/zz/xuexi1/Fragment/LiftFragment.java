package com.xuexi1.zz.xuexi1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuexi1.zz.xuexi1.R;

/**
 * Created by Administrator on 2018-03-02.
 */

public class LiftFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_lift,container,false);
        return view;
    }
}
