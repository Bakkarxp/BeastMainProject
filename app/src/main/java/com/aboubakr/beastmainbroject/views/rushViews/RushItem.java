package com.aboubakr.beastmainbroject.views.rushViews;

import com.aboubakr.beastmainbroject.entities.RushEvent;


import java.util.List;


public class RushItem {
    public int type;
    public String header;
    public RushEvent rushEvent;
    public List<RushItem> invisibleChildren;

    public RushItem(int type, String header) {
        this.type = type;
        this.header = header;
    }

    public RushItem(int type, RushEvent rushEvent) {
        this.type = type;
        this.rushEvent = rushEvent;
    }
}
