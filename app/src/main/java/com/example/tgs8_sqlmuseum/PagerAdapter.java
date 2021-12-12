package com.example.tgs8_sqlmuseum;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter  extends FragmentPagerAdapter {
    int tabcount;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ObjectFragment();
            case 1:
                return new ExhibitionFragment();
            case 2:
                return new ClassificationFragment();
            case 3:
                return new CultureFragment();
            case 4:
                return new PublicationFragment();
            case 5:
                return new PlaceFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return tabcount;
    }
}
