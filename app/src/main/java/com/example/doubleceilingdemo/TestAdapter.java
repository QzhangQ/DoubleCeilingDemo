package com.example.doubleceilingdemo;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class TestAdapter extends BaseMultiItemQuickAdapter<TestBean, BaseViewHolder> {
    public TestAdapter(List<TestBean> data){
        super(data);
        addItemType(TestBean.ITEM_HEAD_TYPE, R.layout.layout_head_view);
        addItemType(TestBean.ITEM_SEARCH_TYPE, R.layout.layout_head_search_view);
        addItemType(TestBean.ITEM_LIST_TYPE, R.layout.layout_list_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {
        switch (item.getItemType()){
            case 1:
            case 2:
                break;
            case 3:
                helper.setText(R.id.tv_title,item.getTitle());
                helper.setText(R.id.tv_content,item.getContent());
                break;
        }
    }
}
