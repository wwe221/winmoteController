package com.something.wimotetab;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();
    public PageAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new Fragment1());
        items.add(new Fragment2());

        itext.add("Home");
        itext.add("Page1");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @Override
    public Fragment getItem(int position) {

        return items.get(position);
    }
    @Override
    public int getCount() {
        return items.size();
    }
}
