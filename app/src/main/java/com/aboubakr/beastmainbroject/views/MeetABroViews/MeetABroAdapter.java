package com.aboubakr.beastmainbroject.views.MeetABroViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.activities.BaseActivity;
import com.aboubakr.beastmainbroject.entities.Brother;

import java.util.ArrayList;

//Adapters provide a binding from an app-specific data set
// to views that are displayed within a RecyclerView.
// provide the views with data

public class MeetABroAdapter extends RecyclerView.Adapter<MeetABroViewHolder> implements View.OnClickListener{
    private ArrayList<Brother> brothers;
    private LayoutInflater inflater;
    private BaseActivity activity;
    private OnBrotherClickedListener listner;

    public MeetABroAdapter(BaseActivity activity, OnBrotherClickedListener listner) {
        this.activity = activity;
        this.listner = listner;
        inflater = activity.getLayoutInflater();
        brothers = new ArrayList<>();
    }

    public ArrayList<Brother> getBrothers() {
        return brothers;
    }

    @Override
    public MeetABroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
        View listView = inflater.inflate(R.layout.list_meet_a_bro,parent,false);
        listView.setOnClickListener(this);
        return new MeetABroViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(MeetABroViewHolder holder, int position) {
        //Called by RecyclerView to display the data at the specified position
        // Bind the views to the adapter
        holder.populate(activity,brothers.get(position));

    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof  Brother){
            Brother brother =(Brother) view.getTag();
            listner.OnBrotherClicked(brother);
        }
    }


    public interface OnBrotherClickedListener {
        void OnBrotherClicked(Brother brother);
    }
}
