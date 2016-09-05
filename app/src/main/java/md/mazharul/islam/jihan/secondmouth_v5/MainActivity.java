package md.mazharul.islam.jihan.secondmouth_v5;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ImageButton home , medical , school , outside;
    ImageView ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12;
    MediaPlayer mp;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


     //  checkPermission();


        /////////////////////////////////////////////////////////////////


        home = (ImageButton) findViewById(R.id.mainhomebuttonhome);
        medical = (ImageButton) findViewById(R.id.mainhomebuttonmedical);
        school = (ImageButton) findViewById(R.id.mainhomebuttonschool);
        outside = (ImageButton) findViewById(R.id.mainhomebuttonoutside);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this , MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent school = new Intent(MainActivity.this , School.class);
                startActivity(school);
                finish();
            }
        });

        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this , Hospital.class);
                startActivity(in);
                finish();
            }
        });



        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Outside.class);
                startActivity(in);
                finish();
            }
        });



        /////////////////////////////////////////////////////////////////////////////////
        ib1 = (ImageView) findViewById(R.id.imageButton);
        ib2   = (ImageView) findViewById(R.id.imageButton2);
        ib3 = (ImageView) findViewById(R.id.imageButton3);
        ib4  = (ImageView) findViewById(R.id.imageButton4);
        ib5  = (ImageView) findViewById(R.id.imageButton5);
        ib6  = (ImageView) findViewById(R.id.imageButton6);
        ib7 = (ImageView) findViewById(R.id.imageButton7);
        ib8    = (ImageView) findViewById(R.id.imageButton8);
        ib9    = (ImageView) findViewById(R.id.imageButton9);
        ib10    = (ImageView) findViewById(R.id.imageButton10);
        ib11   = (ImageView) findViewById(R.id.imageButton11);
        ib12    = (ImageView) findViewById(R.id.imageButton12);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_kotha);
                mp.start();


                // set animation listener
                ib1.startAnimation(animation);

            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_valo);
                mp.start();
                ib2.startAnimation(animation);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_somoy);
                mp.start();
                ib3.startAnimation(animation);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_khabar);
                mp.start();
                ib4.startAnimation(animation);
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_pani);
                mp.start();
                ib5.startAnimation(animation);
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_cha);
                mp.start();
                ib6.startAnimation(animation);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_light);
                mp.start();
                ib7.startAnimation(animation);
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_fan);
                mp.start();
                ib8.startAnimation(animation);
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_thikase);
                mp.start();
                ib9.startAnimation(animation);
            }
        });
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_gosol);
                mp.start();
                ib10.startAnimation(animation);
            }
        });
        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_washroom);
                mp.start();
                ib11.startAnimation(animation);
            }
        });
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.home_jina);
                mp.start();
                ib12.startAnimation(animation);
            }
        });


        /////////////////////////////////////////////////////////////////


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity").setMessage("Are you sure")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                     }).setNegativeButton("No" , null).show();


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
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.location) {
            Intent loc = new Intent(MainActivity.this , MapsActivity.class);
            startActivity(loc);
            return true;
        }else if(id==R.id.trouble){
            startActivity(new Intent(this,Trouble.class));
        }else if(id==R.id.textspeech){
            startActivity(new Intent(this,TextToSpeach.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            startActivity(new Intent(this,Profile2.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this,TextToSpeach.class));
        } else if (id == R.id.nav_slideshow) {

            startActivity(new Intent(this,MapsActivity.class));
        } else if (id == R.id.nav_manage) {

            startActivity(new Intent(this,Trouble.class));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this,Sectting.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }


/*
        @TargetApi(Build.VERSION_CODES.M)
        public void checkPermission(){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS}, 111);
        }
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            if (requestCode == 111) {
            }*/
        }
    }
