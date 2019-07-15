package com.patel.aditya.menqr;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment= new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    fragment = new Options();
                    break;
                case R.id.navigation_notifications:
                    fragment = new favourite();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadFragment(new HomeFragment());
        //loadFragment(new HomeFragment());
        BottomNavigationView navView = findViewById(R.id.nav_view);

        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private boolean loadFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment1, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    static public class HomeFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

            return inflater.inflate(R.layout.scanner_laytout, null);
        }
    }
    static public class Options extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

            return inflater.inflate(R.layout.options_layout, null);
        }
    }
    static public class favourite extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

            return inflater.inflate(R.layout.scanner_laytout, null);
        }
    }
}
