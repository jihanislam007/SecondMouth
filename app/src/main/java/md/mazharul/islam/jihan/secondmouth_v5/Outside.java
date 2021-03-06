package md.mazharul.islam.jihan.secondmouth_v5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Outside extends AppCompatActivity {

    ImageButton home , medical , school , outside;
    ImageView ib0,ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib18,ib19,ib20;
    MediaPlayer mp;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside);


        /////////////////////////////////////////////////////////////////




        home = (ImageButton) findViewById(R.id.homebuttonhome);
        medical = (ImageButton) findViewById(R.id.homebuttonmedical);
        school = (ImageButton) findViewById(R.id.homebuttonschoolhoi);
        outside = (ImageButton) findViewById(R.id.homebuttonoutside);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Outside.this , MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Outside.this , Hospital.class);
                startActivity(in);
                finish();
            }
        });



        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Outside.this, Outside.class);
                startActivity(in);
                finish();
            }
        });

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent school = new Intent(Outside.this , School.class);
                startActivity(school);
                finish();
            }
        });


        ib1 = (ImageView) findViewById(R.id.imageButton);
        ib2   = (ImageView) findViewById(R.id.imageButton2);
        ib3 = (ImageView) findViewById(R.id.imageButton3);
        ib4  = (ImageView) findViewById(R.id.imageButton4);
        ib5  = (ImageView) findViewById(R.id.imageButton5);
        ib6  = (ImageView) findViewById(R.id.imageButton6);
        ib7 = (ImageView) findViewById(R.id.imageButton7);
        ib8    = (ImageView) findViewById(R.id.imageButton8);
        ib9    = (ImageView) findViewById(R.id.outimageButton9);
        ib10    = (ImageView) findViewById(R.id.outimageButton10);
        ib11   = (ImageView) findViewById(R.id.outimageButton11);
        ib12    = (ImageView) findViewById(R.id.outimageButton12);


        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_cng);
                mp.start();
                ib1.startAnimation(animation);

            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_cycle);
                mp.start();
                ib2.startAnimation(animation);
            }
        });
       ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_rickshaw);
                mp.start();
                ib3.startAnimation(animation);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_market);
                mp.start();
                ib4.startAnimation(animation);
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.home_kotha);
                mp.start();
                ib5.startAnimation(animation);
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.home_thikase);
                mp.start();
                ib6.startAnimation(animation);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_right);
                mp.start();
                ib7.startAnimation(animation);
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_left);
                mp.start();
                ib8.startAnimation(animation);
            }
        });
         ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.home_jina);
                mp.start();
                ib9.startAnimation(animation);
            }
        });
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.outside_public);
                mp.start();
                ib10.startAnimation(animation);
            }
        });
        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.hospital);
                mp.start();
                ib11.startAnimation(animation);
            }
        });
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Outside.this, R.raw.bank);
                mp.start();
                ib12.startAnimation(animation);
            }
        });


        /////////////////////////////////////////////////////////////////////////////////
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.location) {
            Intent loc = new Intent(Outside.this , MapsActivity.class);
            startActivity(loc);
            return true;
        }else if(id==R.id.trouble){
            startActivity(new Intent(this,Trouble.class));
        }else if(id==R.id.textspeech){
            startActivity(new Intent(this,TextToSpeach.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
