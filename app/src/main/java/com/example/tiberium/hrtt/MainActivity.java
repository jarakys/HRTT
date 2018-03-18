package com.example.tiberium.hrtt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tiberium.hrtt.Fragments.ChangeLessonsFragment;
import com.example.tiberium.hrtt.Fragments.NewsFragment;
import com.example.tiberium.hrtt.Fragments.ScheduleFragment;
import com.example.tiberium.hrtt.Fragments.SettingsFragment;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private Fragment currentFragment;
    private android.support.v4.app.FragmentManager fTrans;
    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences;
        sharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("Name_Group", Context.MODE_PRIVATE);
        String topic = sharedPreferences.getString("Name_Group","");
        FirebaseMessaging.getInstance().subscribeToTopic(topic);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        currentFragment = new NewsFragment();

        setTitle("Новости");
        setFragment(currentFragment);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up custom_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == R.id.nav_news)
        {
            toolbar.setTitle("Новости");
            currentFragment = new NewsFragment();
        }
        if(id == R.id.nav_change)
        {
            toolbar.setTitle("Изменения");
            currentFragment = new ChangeLessonsFragment();

        }
        if(id == R.id.nav_settings)
        {
            toolbar.setTitle("Настройки");
            currentFragment = new SettingsFragment();

        }
        if(id == R.id.nav_schedule)
        {
            toolbar.setTitle("Расписание");
            currentFragment = new ScheduleFragment();
        }
        setFragment(currentFragment);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setFragment(Fragment fragment)
    {
        fTrans = getSupportFragmentManager();
        fTrans.beginTransaction().replace(R.id.frame,fragment).commit();
    }
}
