package com.aboubakr.beastmainbroject.views.rushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.aboubakr.beastmainbroject.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RushExpandableHeaderViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_rush_expandable_header_buttonToggle)
    ImageView buttonToggle;

    @BindView(R.id.list_rush_expandable_header_layout)
    View backgroundLayout;

    @BindView(R.id.list_rush_expandable_header_headerName)
    TextView headerName;

    public RushItem referralItem;

    public RushExpandableHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


}
