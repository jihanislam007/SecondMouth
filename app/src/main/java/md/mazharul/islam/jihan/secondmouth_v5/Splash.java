package md.mazharul.islam.jihan.secondmouth_v5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    private static String prefString;
    private static SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    sleep(1000);

                    /////////////////////////////////////////////////

                    pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor  editor = pref.edit();


                    prefString = pref.getString("KEY_DIS","");

                    if (prefString.equals("")) {

                        editor.putString("KEY_DIS", "abc");
                        editor.commit();
                        startActivity(new Intent(getApplicationContext(),
                                Sectting.class));
                    }else{
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                    }

                    /////////////////////////////////////////////


                    finish();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        };
        thread.start();


    }
}
