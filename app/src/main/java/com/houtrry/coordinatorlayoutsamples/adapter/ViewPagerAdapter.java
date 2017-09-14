package com.houtrry.coordinatorlayoutsamples.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.houtrry.coordinatorlayoutsamples.ui.fragment.PagerFragment;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/14 14:04
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] mTitleStrings;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, String[] titleStrings) {
        super(fm);
        mTitleStrings = titleStrings;
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(mTitleStrings!=null?mTitleStrings[position]:"");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleStrings!=null?mTitleStrings[position]:"";
    }

    @Override
    public int getCount() {
        return mTitleStrings != null?mTitleStrings.length:0;
    }
}
