package tm.nsfantom.infinity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import tm.nsfantom.infinity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SpinnerAdapter spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.spinnerArray));
        layout.spinner.setAdapter(spinnerAdapter);
        layout.spinner.setSelection(0);
        layout.btnStart.setOnClickListener(this::startViewPager);
    }


    private void startViewPager(View view) {
        layout.btnStart.setVisibility(View.GONE);
        layout.spinner.setVisibility(View.GONE);
        layout.framePager.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction()
                .replace(layout.framePager.getId(), PagerFragment.newInstance(layout.spinner.getSelectedItemPosition()+1))
                .commit();
    }
}
