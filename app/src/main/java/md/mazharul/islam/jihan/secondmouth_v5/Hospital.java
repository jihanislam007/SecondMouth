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

public class Hospital extends AppCompatActivity {

    ImageButton home , medical , school , outside;
    ImageView ib0,ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib18,ib19,ib20;
    MediaPlayer mp;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        /////////////////////////////////////////////////////////////////


        home = (ImageButton) findViewById(R.id.homebuttonhome);
        medical = (ImageButton) findViewById(R.id.homebuttonmedical);
        school = (ImageButton) findViewById(R.id.homebuttonschoolhoi);
        outside = (ImageButton) findViewById(R.id.homebuttonoutside);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Hospital.this , MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Hospital.this , Hospital.class);
                startActivity(in);
                finish();
            }
        });



        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Hospital.this, Outside.class);
                startActivity(in);
                finish();
            }
        });

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent school = new Intent(Hospital.this , School.class);
                startActivity(school);
                finish();
            }
        });


        /////////////////////////////////////////////////////////////////////////////////

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
        ib13    = (ImageView) findViewById(R.id.imageButton13);
        ib14    = (ImageView) findViewById(R.id.imageButton14);
        ib15   = (ImageView) findViewById(R.id.imageButton15);


        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);


        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_doctor);
                mp.start();
                ib1.startAnimation(animation);

            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_precri);
                mp.start();
                ib2.startAnimation(animation);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.home_kotha);
                mp.start();
                ib3.startAnimation(animation);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_head);
                mp.start();
                ib4.startAnimation(animation);
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_beli);
                mp.start();
                ib5.startAnimation(animation);
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_sordi);
                mp.start();
                ib6.startAnimation(animation);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_backpain);
                mp.start();
                ib7.startAnimation(animation);
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_saririk);
                mp.start();
                ib8.startAnimation(animation);
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.home_thikase);
                mp.start();
                ib9.startAnimation(animation);
            }
        });
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_ousudhkinbo);
                mp.start();
                ib10.startAnimation(animation);
            }
        });
        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_ousudhkhao);
                mp.start();
                ib11.startAnimation(animation);
            }
        });
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.home_jina);
                mp.start();
                ib12.startAnimation(animation);
            }
        });
        ib13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_blood);
                mp.start();
                ib13.startAnimation(animation);
            }
        });
        ib14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.hospital_pressure);
                mp.start();
                ib14.startAnimation(animation);
            }
        });
        ib15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mp = MediaPlayer.create(Hospital.this, R.raw.home_khabar);
                mp.start();
                ib15.startAnimation(animation);
            }
        });



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
            Intent loc = new Intent(Hospital.this , MapsActivity.class);
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
