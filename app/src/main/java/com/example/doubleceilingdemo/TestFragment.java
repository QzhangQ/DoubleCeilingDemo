package com.example.doubleceilingdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TestFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.et_search_content)
    EditText etSearchContent;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.ll_item_view)
    LinearLayout llItemView;

    private List<TestBean> mData ;
    private TestAdapter mAdapter;
    Unbinder unbinder;
    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        mData = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        for (int i = 0 ;i< 20;i++){
            if (i ==0){
                TestBean bean = new TestBean();
                bean.setType(1);
                mData.add(bean);
            }else if (i == 1){
                TestBean bean = new TestBean();
                bean.setType(2);
                mData.add(bean);
            }else {
                TestBean bean = new TestBean();
                bean.setType(3);
                bean.setTitle("测试"+i);
                bean.setTitle("测试内容测试内容测试内容测试内容");
                mData.add(bean);
            }

        }

        mAdapter = new TestAdapter(mData);
        mAdapter.bindToRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int position = layoutManager.findFirstVisibleItemPosition();

                if (position > 0) {
                    llItemView.setVisibility(View.VISIBLE);
                } else {
                    llItemView.setVisibility(View.GONE);
                }

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
