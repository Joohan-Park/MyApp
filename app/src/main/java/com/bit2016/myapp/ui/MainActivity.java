package com.bit2016.myapp.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.bit2016.myapp.R;


public class MainActivity extends AppCompatActivity {
    private MainTabsAdapter mainTabAdapter;
    private int indexDefaultTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexDefaultTab = MainTabsConfig.TABINDEX.FIRST;
        mainTabAdapter
                = new MainTabsAdapter(
                        MainActivity.this,
                        (TabHost)findViewById( android.R.id.tabhost ),
                        (ViewPager)findViewById( R.id.pager ) );

        if( indexDefaultTab != MainTabsConfig.TABINDEX.FIRST ) {
            mainTabAdapter.selectTab(indexDefaultTab);
        }
    }
}
