package com.aboubakr.beastmainbroject.views.rushViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.activities.BaseActivity;
import com.aboubakr.beastmainbroject.entities.RushEvent;

import java.util.ArrayList;
import java.util.List;

/*
 * >> Header  << *
 * >>  List   << *
 * >> Footer  << *
 *
 */

public class RushEventAdapter extends RecyclerView.Adapter {
    public static final int VIEW_TYPE_LIST_HEADER = 1;
    public static final int VIEW_TYPE_LIST_EXPANDABLE_LIST_HEADER = 2;
    public static final int VIEW_TYPE_LIST_EXPANDABLE_LIST_CHILD = 3;
    public static final int VIEW_TYPE_LIST_FOOTER = 4;

    private List<RushItem> data;
    private BaseActivity activity;
    private LayoutInflater inflater;
    private RushEventListener listener;

    public RushEventAdapter(BaseActivity activity, RushEventListener listener) {
        this.activity = activity;
        this.listener = listener;

        inflater = activity.getLayoutInflater();
        data = new ArrayList<RushItem>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expandableHeaderView = inflater.inflate(R.layout.list_rush_expandable_header, parent, false);
        View rushEventView = inflater.inflate(R.layout.list_rush_event, parent, false);
        View rushHeaderView = inflater.inflate(R.layout.header_fragment_rush, parent, false);
        View rushFooterView = inflater.inflate(R.layout.footer_rush_fragment, parent, false);

        switch (viewType) {
            case VIEW_TYPE_LIST_HEADER:
                return new RushHeaderViewHolder(rushHeaderView);
            case VIEW_TYPE_LIST_EXPANDABLE_LIST_CHILD:
                final RushEventsViewHolder holder = new RushEventsViewHolder(rushEventView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RushEvent rushEvent = (RushEvent) holder.itemView.getTag();
                        listener.OnRushEventClicked(rushEvent);
                    }
                });
                return holder;
            case VIEW_TYPE_LIST_FOOTER:
                return new RushFooterViewHolder(rushFooterView);
            case VIEW_TYPE_LIST_EXPANDABLE_LIST_HEADER:
                return new RushExpandableHeaderViewHolder(expandableHeaderView);
        }

        throw new IllegalArgumentException("ViewType: " + viewType + " is not supported in this adapter");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RushExpandableHeaderViewHolder) {
            position--;

            final RushItem rushItem = data.get(position);
            final RushExpandableHeaderViewHolder itemController = (RushExpandableHeaderViewHolder) holder;

            itemController.referralItem = rushItem;
            itemController.headerName.setText(rushItem.header);

            if (rushItem.invisibleChildren == null) {
                // list is not collapsed
                itemController.buttonToggle.setImageResource(R.mipmap.close);
            } else {
                // list is collapsed
                itemController.buttonToggle.setImageResource(R.mipmap.expand);
            }

            itemController.backgroundLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rushItem.invisibleChildren == null) {
                        rushItem.invisibleChildren = new ArrayList<RushItem>();
                        int count = 0;
                        int position = data.indexOf(itemController.referralItem);
                        while (data.size() > position+1 && data.get(position+1).type == VIEW_TYPE_LIST_EXPANDABLE_LIST_CHILD) {
                            rushItem.invisibleChildren.add(data.remove(position+1));
                            count++;
                        }

                        notifyItemRangeRemoved(position+1, count);
                        itemController.buttonToggle.setImageResource(R.mipmap.expand);
                    } else {
                        int position = data.indexOf(itemController.referralItem);
                        int index = position+1;

                        for (RushItem item : rushItem.invisibleChildren) {
                            data.add(index, item);
                            index++;
                        }

                        notifyItemRangeInserted(position+1, index - position - 1);
                        itemController.buttonToggle.setImageResource(R.mipmap.close);
                        rushItem.invisibleChildren = null;
                    }
                }
            });
        } else if (holder instanceof RushEventsViewHolder) {
            position--;
            RushEventsViewHolder rushEventsViewHolder = (RushEventsViewHolder) holder;
            rushEventsViewHolder.populate(data.get(position).rushEvent);
        } else if (holder instanceof RushHeaderViewHolder) {
            RushHeaderViewHolder rushHeaderViewHolder = (RushHeaderViewHolder) holder;
        } else if (holder instanceof  RushFooterViewHolder) {
            RushFooterViewHolder rushFooterViewHolder = (RushFooterViewHolder) holder;
            rushFooterViewHolder.populate(activity);
        }
    }

    @Override
    public int getItemCount() {
        int count = 2;
        count += data.size();
        return count;
    }

    public List<RushItem> getData() {
        return data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_LIST_HEADER;
        }
        position--;

        if (position < data.size()) {
            return data.get(position).type;
        }
        position -= data.size();

        if (position < data.size()) {
            return VIEW_TYPE_LIST_FOOTER;
        }
        position--;

        throw new IllegalArgumentException("We are at the end of the end of the adapter and another view is being added. Check adapter. Position: " + position);
    }


    public interface RushEventListener {
        void OnRushEventClicked(RushEvent rushEvent);
    }
}
