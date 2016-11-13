package in.kempa.tourmanipal;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class PlaceDetailsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentManager fragmentManager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentManager = getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFragment(new InfoFragment(), "");
        viewPagerAdapter.addFragment(new FacilitiesFragment(), "");
        viewPagerAdapter.addFragment(new ReviewFragment(), "");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_info_white_48dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_card_giftcard_white_48dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_rate_review_white_48dp);
    }
}
