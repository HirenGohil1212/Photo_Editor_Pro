package com.example.photoeditorpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fab;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Inspiring");
                    } else if (position == 1) {
                        tab.setText("Generated With AI");
                    } else if (position == 2) {
                        tab.setText("Edit By Masters");
                    } else if (position == 3) {
                        tab.setText("Popular Stickers");
                    } else {
                        tab.setText("Trending Replays");
                    }
                }
        ).attach();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    showFragment(new Inspiring_Fragment());
                    tabLayout.setVisibility(View.VISIBLE);
                    break;
                case R.id.explore:
                    showFragment(new ExploreFragment());
                    tabLayout.setVisibility(View.GONE);
                    break;
                case R.id.discover:
                    showFragment(new TrophyFragment());
                    tabLayout.setVisibility(View.GONE);
                    break;
                case R.id.account:
                    showFragment(new AccountFragment());
                    tabLayout.setVisibility(View.GONE);
                    break;
            }
            return true;
        });

        fab.setOnClickListener(view -> showBottomDialog());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }






    private void showBottomDialog() {

//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.bottomstylesheet);
//
//        LinearLayout takephoto = dialog.findViewById(R.id.takephoto);
//        LinearLayout import_gal = dialog.findViewById(R.id.import_gal);
//
//        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);
//
//        takephoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//                Toast.makeText(MainActivity.this,"Take Photo is clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        import_gal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//                Toast.makeText(MainActivity.this,"Import Gallery is Clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.getWindow().setGravity(Gravity.BOTTOM);
//
//    }

        Intent intent = new Intent(MainActivity.this, Create_Panel.class);
        startActivity(intent);



    }
}

