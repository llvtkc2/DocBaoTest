package com.hdpsolutions.docbaotest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hdpsolutions.docbaotest.R;
import com.hdpsolutions.docbaotest.adapter.CategoriesAdapter;
import com.hdpsolutions.docbaotest.utils.ScreenUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private CategoriesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_categories_fragment, container, false);
        ButterKnife.bind(this, view);

        initLayout();
        initValues();

        return view;
    }

    private void initValues() {

    }

    private void initLayout() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        String[] data = getResources().getStringArray(R.array.categories);
        mAdapter = new CategoriesAdapter(data, ScreenUtils.getDisplayMetrics(getActivity()).widthPixels / 2);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }
}
