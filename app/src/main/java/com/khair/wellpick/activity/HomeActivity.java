package com.khair.wellpick.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.khair.wellpick.R;
import com.khair.wellpick.fragment.DownloadFragment;
import com.khair.wellpick.fragment.FavoriteFragment;
import com.khair.wellpick.fragment.HomeFragment;
import com.khair.wellpick.fragment.PopularFragment;
import com.khair.wellpick.fragment.PrivacyPolicyFragment;
import com.khair.wellpick.fragment.SettingFragment;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    NavigationView navigationView;
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawerLayout=findViewById(R.id.drawerlayout);
        materialToolbar=findViewById(R.id.Toolbar);
        navigationView=findViewById(R.id.NavigationView);
        bottom_navigation=findViewById(R.id.bottomnavigation);

        TextView versionTextView = navigationView.getHeaderView(0).findViewById(R.id.tv_version);

        // Get the app version name
        String versionName = getVersionName();

        // Set version name to the TextView
        versionTextView.setText("Version " + versionName);


        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                HomeActivity.this,drawerLayout,materialToolbar,R.string.CloseDrawer,R.string.openDrawer);
        drawerLayout.addDrawerListener(toggle);


        LodeFragmentManager(new HomeFragment());

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                if (item.getItemId()==R.id.search){
                    startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                }


                return true;
            }
        });






        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.home){
                    LodeFragmentManager(new HomeFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId()==R.id.favorite) {
                    LodeFragmentManager(new FavoriteFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId()==R.id.popular) {
                    LodeFragmentManager(new PopularFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId()==R.id.download) {
                    LodeFragmentManager(new DownloadFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId()==R.id.Setting) {
                    LodeFragmentManager(new SettingFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId()==R.id.PrivacyPolicy) {
                    LodeFragmentManager(new PrivacyPolicyFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);

                }

                return true;
            }
        });


        bottom_navigation.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.home){
                    LodeFragmentManager(new HomeFragment());
                } else if (item.getItemId()==R.id.favorite) {
                    LodeFragmentManager(new FavoriteFragment());
                }else if (item.getItemId()==R.id.popular) {
                    LodeFragmentManager(new PopularFragment());
                }else if (item.getItemId()==R.id.download) {
                    LodeFragmentManager(new DownloadFragment());

                }


                return true;
            }
        });





    }
  ///*********************************************************
    public void LodeFragmentManager(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.FrameLayout,fragment);
        transaction.commit();
    }

    private String getVersionName() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "N/A";
        }
    }


 ///*************************************************************
}