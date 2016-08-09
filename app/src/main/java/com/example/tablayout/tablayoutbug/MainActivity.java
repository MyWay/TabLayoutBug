package com.example.tablayout.tablayoutbug;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.commonsware.cwac.pager.PageDescriptor;
import com.commonsware.cwac.pager.SimplePageDescriptor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<PageDescriptor> mPages;
    private MyPagerAdapter mAdapter;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTabs();
        mAdapter = new MyPagerAdapter(getFragmentManager(), mPages);

        mPager = (ViewPager) findViewById(R.id.pager);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.pager_header);
        if (mPager != null) {
            mPager.setAdapter(mAdapter);
            if (mTabLayout != null) {
                mTabLayout.setupWithViewPager(mPager);
            }
        }

        mPager.setCurrentItem(36);
    }

    public void removeCurrentFragment() {
        int position = mPager.getCurrentItem();

        mAdapter.remove(position);
    }

    public void addTabs() {
        mPages = new ArrayList<>();
        for (int i = 1; i <= 50; i++)
            mPages.add(new SimplePageDescriptor("test" + i, "test" + i));
    }

    public MyPagerAdapter getAdapter() {
        return mAdapter;
    }
}