package com.example.nailo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Bottom_Nav_Activity extends AppCompatActivity {


    public ViewPager viewPager;
    Home_fagm home_fagm;
    Settings_fgm settings_fgm;
    Notification_fgm notification_fgm;
    ViewPagerAdapter adapter;
    MenuItem prevMenuItem;
    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);

                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);

                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__nav_);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
  bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
      bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
        setupViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        home_fagm=new Home_fagm();
     settings_fgm=new Settings_fgm();
       notification_fgm=new Notification_fgm();

        adapter.addFragment(home_fagm);
        adapter.addFragment(settings_fgm);
        adapter.addFragment(notification_fgm);
        viewPager.setAdapter(adapter);
    }

}
