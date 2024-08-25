package com.example.krishportfolio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position == 0)
        {
            return  new mainFragment();
        }
        else if(position == 1)
        {
            return new skillsFragment();
        }
        else if(position  == 2)
        {
            return new projectFragment();
        }
        else if(position == 3)
        {
            return new educationFragment();
        }
        else
        {
            return new contactFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0)
        {
            return "Me";
        }
        else if(position == 1)
        {
            return "Skills";
        }
        else if(position  == 2)
        {
            return "Projects";
        }
        else if(position == 3)
        {
            return "Education";
        }
        else
        {
            return "Contact";
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
