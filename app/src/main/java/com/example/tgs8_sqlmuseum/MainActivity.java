package com.example.tgs8_sqlmuseum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mobject,mexhibition,mclassification,mculture,mpublication,mplace;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    String api_key = "6ec82d44-6b6e-4c58-bec3-1aca7e80316c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mobject=findViewById(R.id.object);
        mexhibition=findViewById(R.id.exhibition);
        mclassification=findViewById(R.id.classification);
        mculture=findViewById(R.id.culture);
        mpublication=findViewById(R.id.publication);
        mplace=findViewById(R.id.place);
        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||
                        tab.getPosition()==2||tab.getPosition()==3 ||
                        tab.getPosition()==4||tab.getPosition()==5 ||
                        tab.getPosition()==6)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}