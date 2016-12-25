package com.example.xyzreader.ui;

import android.support.design.widget.AppBarLayout;

/**
 * Created by Angad on 25-12-2016.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    private int EXPANDED=0;
    private int COLLAPSED=1;
    private int IDLE=2;

    private int mCurrentState = IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (mCurrentState != EXPANDED) {
                onStateChanged(appBarLayout, EXPANDED);
            }
            mCurrentState = EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != COLLAPSED) {
                onStateChanged(appBarLayout, COLLAPSED);
            }
            mCurrentState = COLLAPSED;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, int state);
}