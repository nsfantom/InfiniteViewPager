package tm.nsfantom.infinity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tm.nsfantom.infinity.databinding.ViewPagerBinding;

/**
 * Created by nsfantom on 1/18/18.
 */

public class PagerFragment extends Fragment {
    private static final String PAGE_COUNT = "count";
    private int MAX_PAGE = 3;
    ViewPagerBinding layout;

    static PagerFragment newInstance(int count){
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE_COUNT,count);
        fragment.setArguments(args);
        return fragment;
    }

    public int getPageCount() {
        return getArguments().getInt(PAGE_COUNT,1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = DataBindingUtil.inflate(
                inflater, R.layout.view_pager, container, false);
        return layout.getRoot();
    }

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Instantiate a ViewPager and a PagerAdapter.
        MAX_PAGE = getPageCount()<3?getPageCount()*3:getPageCount();
        mPagerAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());

        layout.vpXpeH.setAdapter(mPagerAdapter);
        layout.vpXpeH.setCurrentItem(getPageCount());
        layout.scrollIndicator.setLoopViewPager(layout.vpXpeH);
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int index = position % getPageCount();
            return ScreenSlidePageFragment.newInstance("Page: ".concat(String.valueOf(index)));
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }
}
