package com.example.photoeditorpro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private String[] titles = {"Inspiring","Generated With AI","Edit By Masters","Popular Stickers","Trending Replays"};
    public ViewPagerAdapter(@NonNull HomeFragment fragmentActivity) {
        super(fragmentActivity);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0:
                return new Inspiring_Fragment();
            case 1:
                return new GenerateAI_Fragment();
            case 2:
                return new EditByMaster_Fragment();
            case 3:
                return new PopularStickers_Fragment();
            case 4:
                return new TrendingReplays_Fragment();
        }
        return new Inspiring_Fragment();

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}