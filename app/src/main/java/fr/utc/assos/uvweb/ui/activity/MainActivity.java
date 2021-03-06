package fr.utc.assos.uvweb.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

import fr.utc.assos.uvweb.R;
import fr.utc.assos.uvweb.ui.fragment.NewsfeedFragment;
import fr.utc.assos.uvweb.ui.fragment.UvListFragment;

public class MainActivity extends ToolbarActivity {
    private static final int FRAGMENT_COUNT = 2;
    private static final int FRAGMENT_POSITION_NEWSFEED = 0;
    private static final int FRAGMENT_POSITION_UVLIST = 1;

    private static final String PREF_LAST_TAB = "pref_last_tab";
    private static final int PREF_LAST_TAB_DEFAULT = 0;

    private SharedPreferences preferences;
    private ViewPager pager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        pager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // no-op
            }

            @Override
            public void onPageSelected(int position) {
                saveLastTabIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // no-op
            }
        });

        loadLastTabIndex();
    }

    private void loadLastTabIndex() {
        pager.setCurrentItem(preferences.getInt(PREF_LAST_TAB, PREF_LAST_TAB_DEFAULT));
    }

    private void saveLastTabIndex(int position) {
        preferences.edit().putInt(PREF_LAST_TAB, position).apply();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.action_licenses:
                startActivity(new Intent(this, LicensesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {
        public HomeFragmentPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case FRAGMENT_POSITION_NEWSFEED:
                    return new NewsfeedFragment();
                case FRAGMENT_POSITION_UVLIST:
                    return new UvListFragment();
                default:
                    throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public int getCount() {
            return FRAGMENT_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale locale = Locale.getDefault();
            switch (position) {
                case FRAGMENT_POSITION_NEWSFEED:
                    return getString(R.string.title_newsfeed).toUpperCase(locale);
                case FRAGMENT_POSITION_UVLIST:
                    return getString(R.string.title_uv_list).toUpperCase(locale);
                default:
                    throw new IndexOutOfBoundsException();
            }
        }
    }
}
