package com.avinfo.stickermaker.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;
import com.sangcomz.fishbun.define.Define;
import com.avinfo.stickermaker.R;
//import com.unusualapps.whatsappstickers.TextSticker.TextActivity;
import com.avinfo.stickermaker.TextSticker.TextActivity;
import com.avinfo.stickermaker.backRemover.CutOut;
import com.avinfo.stickermaker.identities.StickerPacksContainer;
import com.avinfo.stickermaker.utils.StickerPacksManager;
import com.avinfo.stickermaker.whatsapp_api.AddStickerPackActivity;

import java.util.Objects;


public class HomeActivity extends AddStickerPackActivity implements NavigationView.OnNavigationItemSelectedListener {
    private MyStickersFragment myStickersFragment;
    private ExploreFragment exploreFragment;
    private CreateStickerFragment createFragment;

    private Toolbar toolbar1;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        drawer.setBackgroundColor(Color.parseColor("#F5D611"));

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(HomeActivity.this, drawer, toolbar1, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        Fresco.initialize(this);
        this.initBottomNavigation();
        this.setupFragments();
        setFragmento(myStickersFragment);
        StickerPacksManager.stickerPacksContainer = new StickerPacksContainer("", "", StickerPacksManager.getStickerPacks(this));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    setFragmento(myStickersFragment);
                    return true;
                /*case R.id.menu_explore:
                    setFragmento(exploreFragment);
                    return true;*/
                case R.id.menu_create:
                    setFragmento(createFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CutOut.CUTOUT_ACTIVITY_REQUEST_CODE || requestCode == Define.ALBUM_REQUEST_CODE) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_principal);
            Objects.requireNonNull(fragment).onActivityResult(requestCode, resultCode, data);
        }
    }

    private void initBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        myStickersFragment = new MyStickersFragment();
        exploreFragment = new ExploreFragment();
        createFragment = new CreateStickerFragment();
        fragmentTransaction.add(R.id.frame_principal, myStickersFragment);
        fragmentTransaction.add(R.id.frame_principal, exploreFragment);
        fragmentTransaction.add(R.id.frame_principal, createFragment);
        fragmentTransaction.hide(exploreFragment);
        fragmentTransaction.hide(createFragment);
        fragmentTransaction.commit();
    }

    private void setFragmento(Fragment fragmento) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (fragmento == myStickersFragment) {
            fragmentTransaction.hide(exploreFragment);
            fragmentTransaction.hide(createFragment);
        } else if (fragmento == exploreFragment) {
            fragmentTransaction.hide(myStickersFragment);
            fragmentTransaction.hide(createFragment);
        } else if (fragmento == createFragment) {
            fragmentTransaction.hide(myStickersFragment);
            fragmentTransaction.hide(exploreFragment);
        }
        fragmentTransaction.show(fragmento);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.dashboard:
//                Intent intent = new Intent(HomeActivity.this, Activity2.class);
//                startActivity(intent);
                drawer.closeDrawer(Gravity.START);
                break;

            case R.id.sticker:

                Intent intent1 = new Intent(HomeActivity.this, NewStickerPackActivity.class);
                startActivity(intent1);
                drawer.closeDrawer(Gravity.START);
                break;

            case R.id.image:
                FishBun.with(HomeActivity.this)
                        .setImageAdapter(new GlideAdapter())
                        .setMaxCount(1)
                        .exceptGif(true)
                        .setMinCount(1)
                        .setActionBarColor(Color.parseColor("#128c7e"), Color.parseColor("#128c7e"), false)
                        .setActionBarTitleColor(Color.parseColor("#ffffff"))
                        .startAlbum();
//                Intent intent2 = new Intent(HomeActivity.this, Activity2.class);
//                startActivity(intent2);
                drawer.closeDrawer(Gravity.START);
                break;

            case R.id.text:
                Intent intent3 = new Intent(HomeActivity.this, TextActivity.class);
                startActivity(intent3);
                drawer.closeDrawer(Gravity.START);
                break;

            case R.id.shareapp:

                Intent s = new Intent(Intent.ACTION_SEND);
                s.setType("text/plain");
                s.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getPackageName());
                startActivity(Intent.createChooser(s, "Share App"));
                drawer.closeDrawer(Gravity.START);

                break;

            case R.id.moreapp:

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:AV Tube")));
                } catch (ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/developer?id=AV Tube")));
                }
                drawer.closeDrawer(Gravity.START);

                break;

            case R.id.rateus:

                Uri uri = Uri.parse("market://details?id=" + HomeActivity.this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + HomeActivity.this.getPackageName())));
                }
                drawer.closeDrawer(Gravity.START);

                break;

            case R.id.aboutus:

                Intent intent4 = new Intent(HomeActivity.this, ActivityAbout.class);
                startActivity(intent4);
                drawer.closeDrawer(Gravity.START);


                break;

            case R.id.exit:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.exit);
                builder.setMessage(R.string.exitmessege);
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                builder.show();
                drawer.closeDrawer(Gravity.START);

                break;


        }

        return false;
    }
}
