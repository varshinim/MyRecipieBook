package com.eleven.group.myrecipiebook.adapter;

import com.eleven.group.myrecipiebook.R;
import com.eleven.group.myrecipiebook.fragment.GridFragment;

public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.OnRecipeSelectedInterface listener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        this.listener = listener;
    } // GridAdapter()

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    } // getLayoutId()

    @Override
    protected void onRecipeSelected(int index) {
        listener.onGridRecipeSelected(index);
    } // onRecipeSelected()

} // GridAdapter