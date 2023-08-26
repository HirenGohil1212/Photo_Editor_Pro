package com.example.photoeditorpro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout = rootView.findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = rootView.findViewById(R.id.viewPager);
        String[] titles = {"Inspiring","Generated With AI","Edit By Masters","Popular Stickers","Trending Replays"};

        FragmentStateAdapter MyPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(MyPagerAdapter);

        new TabLayoutMediator(tabLayout,viewPager2,(((tab, position) -> tab.setText(titles[position])))).attach();

        return rootView;
    }
}