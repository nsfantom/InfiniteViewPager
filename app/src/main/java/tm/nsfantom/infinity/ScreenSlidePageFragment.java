package tm.nsfantom.infinity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tm.nsfantom.infinity.databinding.FragmentScreenSlidePageBinding;

/**
 * Created by user on 1/18/18.
 */

public class ScreenSlidePageFragment extends Fragment {

    private static final String TEXT = "text";
    FragmentScreenSlidePageBinding layout;

    static ScreenSlidePageFragment newInstance(String text){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    private String getTextMessage(){
        return getArguments().getString(TEXT,"TEXT");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        layout = DataBindingUtil.inflate(
                inflater, R.layout.fragment_screen_slide_page, container, false);
        View view = layout.getRoot();
//        //here data must be an instance of the class
//        layout.set<class>(data);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout.textView.setText(getTextMessage());

    }
}
