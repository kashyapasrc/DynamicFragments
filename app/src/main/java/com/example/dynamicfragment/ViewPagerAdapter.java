package com.example.dynamicfragment;
/*
 * Created by Kashyap on 28/7/19 ,Sunday
 *
 */

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tabTitles = new ArrayList<>();

    ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

    }

    private void addFragment(String title, Fragment fragment) {
        this.tabTitles.add(title);
        this.fragmentList.add(fragment);
        notifyDataSetChanged();
    }

    private void removeFragment(String title, Fragment fragment) {
        this.tabTitles.remove(title);
        this.fragmentList.remove(fragment);
        notifyDataSetChanged();
    }

    private String getTabTitle(int position) {
        return "TAB " + position;
    }

    void addFragment() {
        int counter = getCount() + 1;
        TabFragment fragment = TabFragment.getInstance(counter);
        addFragment(getTabTitle(counter), fragment);
    }

    void removeFragment() {
        int counter = getCount() - 1;
        if(counter>=0)
        removeFragment(getTabTitle(counter), fragmentList.get(counter));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
