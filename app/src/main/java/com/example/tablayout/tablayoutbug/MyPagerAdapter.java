package com.example.tablayout.tablayoutbug;

import android.app.Fragment;
import android.app.FragmentManager;

import com.commonsware.cwac.pager.ArrayPagerAdapter;
import com.commonsware.cwac.pager.PageDescriptor;

import java.util.ArrayList;

/**
 * Created by anyway on 09/08/16.
 */
class MyPagerAdapter extends ArrayPagerAdapter {
    MyPagerAdapter(FragmentManager mgr, ArrayList<PageDescriptor> descriptors) {
        super(mgr, descriptors);
    }

    @Override
    protected Fragment createFragment(PageDescriptor pageDescriptor) {
        String sTitle = pageDescriptor.getTitle();

        return MyFragment.newInstance(sTitle);
    }
}