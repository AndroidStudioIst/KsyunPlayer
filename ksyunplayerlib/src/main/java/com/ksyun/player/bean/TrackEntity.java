package com.ksyun.player.bean;

import java.io.Serializable;

public class TrackEntity implements Serializable {
    private String title;
    private int index;
    private boolean selected;
    private String extral;
    public TrackEntity(String title, int index, boolean selected) {
        this.title = title;
        this.index = index;
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getExtral() {
        return extral;
    }

    public void setExtral(String extral) {
        this.extral = extral;
    }
}
