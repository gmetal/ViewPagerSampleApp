package com.github.gmetal.tabbedapp;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("HTTP 100"));
        tabLayout.addTab(tabLayout.newTab().setText("HTTP 200"));
        tabLayout.addTab(tabLayout.newTab().setText("HTTP 500"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.pager);

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(this, getCatImageList());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(final TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(final TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(final TabLayout.Tab tab) {

    }

    private List<CatImage> getCatImageList() {

        List<CatImage> catImageList = new ArrayList<>();
        catImageList.add(new CatImage("https://http.cat/100", "HTTP 100"));
        catImageList.add(new CatImage("https://http.cat/200", "HTTP 200"));
        catImageList.add(new CatImage("https://http.cat/500", "HTTP 500"));
        return catImageList;
    }
}