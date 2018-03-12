package com.xuexi1.zz.xuexi1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xuexi1.zz.xuexi1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018-03-02.
 */

public class OneFragment extends Fragment {
    @BindView(R.id.one_fragment)
    TextView oneFragment;
    Unbinder unbinder;
    private LocalBroadcastManager localBroadcastManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.one_fragment)
    public void onViewClicked() {
        Intent intent = new Intent("gaibian");
        Bundle bundle = new Bundle();
        bundle.putString("nnn","云");
        intent.putExtras(bundle);
        localBroadcastManager.sendBroadcast(intent);
    }
}
