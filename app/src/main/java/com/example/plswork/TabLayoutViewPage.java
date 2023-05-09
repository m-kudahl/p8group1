package com.example.plswork;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutViewPage extends FragmentStateAdapter{

    public TabLayoutViewPage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new EssentialsTab();

            case 1:
                return new EverydayTab();
            default: return new  EssentialsTab();
        }

    }


    @Override
    public int getItemCount() {
        return 2;
    }

}
