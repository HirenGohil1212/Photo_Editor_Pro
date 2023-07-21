package com.example.photoeditorpro;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Inspiring_Fragment();
        } else if (position == 1) {
            return new GenerateAI_Fragment();
        } else if (position == 2) {
            return new EditByMaster_Fragment();
        } else if (position == 3) {
            return new PopularStickers_Fragment();
        } else {
            return new TrendingReplays_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
