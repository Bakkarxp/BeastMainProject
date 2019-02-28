package com.aboubakr.beastmainbroject.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.activities.BaseActivity;
import com.aboubakr.beastmainbroject.entities.EventCard;

import java.util.ArrayList;

////////////////////////////////
//*Header*//

//List Header//
//Community List//

//List Header//
//BrotherHood List//

//List Header//
//Social List//
////////////////////////////////


public class AboutUsAdapter extends RecyclerView.Adapter {
    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_LIST = 2;
    private final int VIEW_TYPE_BROTHERHOOD_LIST = 3;
    private final int VIEW_TYPE_SOCIAL_LIST = 4;
    private final int VIEW_TYPE_LIST_HEADER = 5;

    private LayoutInflater inflater;
    private BaseActivity activity;
    private ArrayList<EventCard> communityServiceEvents;
    private ArrayList<EventCard> brotherHoodEvents;
    private ArrayList<EventCard> socialEvents;

    private AboutUsListener listener;

    public AboutUsAdapter(BaseActivity activity, AboutUsListener listener) {
        this.activity = activity;
        this.listener = listener;

        inflater = activity.getLayoutInflater();

        communityServiceEvents = new ArrayList<>();
        brotherHoodEvents = new ArrayList<>();
        socialEvents = new ArrayList<>();
    }

    // These handle the case where you want different types of view for different rows.
    // Return the view type of the item at position for the purposes of view recycling.
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_MAIN_HEADER;
        }
        position--;

        if (communityServiceEvents.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }

            position--;

            if (position < communityServiceEvents.size()) {
                // position is inside community service events
                return VIEW_TYPE_SERVICE_LIST;
            }

            position -= communityServiceEvents.size();
        }

        if (brotherHoodEvents.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }

            position--;

            if (position < brotherHoodEvents.size()) {
                // position is inside brotherhood events
                return VIEW_TYPE_BROTHERHOOD_LIST;
            }

            position -= brotherHoodEvents.size();
        }

        if (socialEvents.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }

            position--;

            if (position < socialEvents.size()) {
                // position is inside social events
                return VIEW_TYPE_SOCIAL_LIST;
            }

            position -= socialEvents.size();
        }

        throw new IllegalArgumentException("We are at the end of the end of the adapter and another view is being added. Check adapter. Position: " + position);
    }


    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to
    // represent an item.
    // the adapter needs to know what kind of viewHolder to return for each of the view type
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventView = inflater.inflate(R.layout.list_event_card, parent, false);
        View listHeader = inflater.inflate(R.layout.simple_header, parent, false);

        if (viewType == VIEW_TYPE_MAIN_HEADER) {
            return new AboutUsMainHeaderViewHolder(inflater, parent);
        }

        if (viewType == VIEW_TYPE_SERVICE_LIST) {
            final CommunityServiceViewHolder communityServiceViewHolder = new CommunityServiceViewHolder(eventView);
            communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) communityServiceViewHolder.itemView.getTag();
                    listener.OnEventCardClick(eventCard);
                }
            });
            return communityServiceViewHolder;
        }

        if (viewType == VIEW_TYPE_BROTHERHOOD_LIST) {
            final BrotherHoodViewHolder brotherHoodViewHolder = new BrotherHoodViewHolder(eventView);
            brotherHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) brotherHoodViewHolder.itemView.getTag();
                    listener.OnEventCardClick(eventCard);
                }
            });
            return brotherHoodViewHolder;
        }

        if (viewType == VIEW_TYPE_SOCIAL_LIST) {
            final SocialViewHolder socialViewHolder = new SocialViewHolder(eventView);
            socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) socialViewHolder.itemView.getTag();
                    listener.OnEventCardClick(eventCard);
                }
            });
            return socialViewHolder;
        }

        if (viewType == VIEW_TYPE_LIST_HEADER) {
            return new AboutUsListHeaderViewHolder(listHeader);
        }

        throw new IllegalArgumentException("ViewType: " + viewType + " is not supported in this adapter");
    }


    // Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AboutUsMainHeaderViewHolder) {
            AboutUsMainHeaderViewHolder aboutUsMainHeaderViewHolder = (AboutUsMainHeaderViewHolder) holder;
        }

        else if (holder instanceof CommunityServiceViewHolder) {
            position--;
            if (communityServiceEvents.size() > 0) {
                position--;
            }
            EventCard eventCard = communityServiceEvents.get(position);
            ((CommunityServiceViewHolder) holder).populate(activity, eventCard);
        }

        else if (holder instanceof BrotherHoodViewHolder) {
            position--;
            if (communityServiceEvents.size() > 0) {
                position--;
                position-=communityServiceEvents.size();
            }
            if (brotherHoodEvents.size() > 0) {
                position--;
            }
            EventCard eventCard = brotherHoodEvents.get(position);
            ((BrotherHoodViewHolder) holder).populate(activity, eventCard);
        }

        else if (holder instanceof SocialViewHolder) {
            position--;
            if (communityServiceEvents.size() > 0) {
                position--;
                position-=communityServiceEvents.size();
            }
            if (brotherHoodEvents.size() > 0) {
                position--;
                position-=brotherHoodEvents.size();
            }
            if (socialEvents.size() > 0) {
                position--;
            }
            EventCard eventCard = socialEvents.get(position);
            ((SocialViewHolder) holder).populate(activity, eventCard);
        }

        else if (holder instanceof AboutUsListHeaderViewHolder) {
            AboutUsListHeaderViewHolder aboutUsListHeaderViewHolder = (AboutUsListHeaderViewHolder) holder;

            int servicePosition = 1;
            int brotherhoodPosition = servicePosition + communityServiceEvents.size() + 1;
            int socialPosition = brotherhoodPosition + brotherHoodEvents.size() + 1;

            if (position == servicePosition) {
                aboutUsListHeaderViewHolder.populate(activity.getResources().getString(R.string.about_us_list_header_comm_service));
            } else if (position == brotherhoodPosition) {
                aboutUsListHeaderViewHolder.populate(activity.getResources().getString(R.string.about_us_list_header_fraternity));
            } else if (position == socialPosition) {
                aboutUsListHeaderViewHolder.populate(activity.getResources().getString(R.string.about_us_list_header_social));
            }
        }
    }


    @Override
    public int getItemCount() {
        // Main header
        int count = 1;

        // List header + community list
        if (communityServiceEvents.size() > 0) {
            count += (1 + communityServiceEvents.size());
        }
        // List header + brotherHood list
        if (brotherHoodEvents.size() > 0) {
            count += (1 + brotherHoodEvents.size());
        }
        // List header + Social list
        if (socialEvents.size() > 0) {
            count += (1 + socialEvents.size());
        }

        return count; // total count
    }






    public  interface AboutUsListener {
        void OnEventCardClick(EventCard eventCard);
    }

    public ArrayList<EventCard> getCommunityServiceEvents() {
        return communityServiceEvents;
    }

    public ArrayList<EventCard> getBrotherHoodEvents() {
        return brotherHoodEvents;
    }

    public ArrayList<EventCard> getSocialEvents() {
        return socialEvents;
    }
}

