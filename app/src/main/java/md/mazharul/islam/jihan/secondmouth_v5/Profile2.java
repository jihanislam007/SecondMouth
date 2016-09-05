package md.mazharul.islam.jihan.secondmouth_v5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile2 extends AppCompatActivity {

    TextView name , address , message , phone;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        name = (TextView) findViewById(R.id.textViewshowname);
        address = (TextView) findViewById(R.id.textViewshowaddress);
        message = (TextView) findViewById(R.id.textViewshowmessage);
        phone = (TextView) findViewById(R.id.textViewshowphone);


        sharedpreferences = getSharedPreferences("file1" , MODE_PRIVATE);
        String nameu = sharedpreferences.getString("nameKey","No Data");
        String addressu = sharedpreferences.getString("addresskey","No Data");
        String messageu = sharedpreferences.getString("messagekey","No Data");
        String phoneu = sharedpreferences.getString("phonekey","No Data");

        name.setText(nameu);
        address.setText(addressu);
        message.setText(messageu);
        phone.setText(phoneu);


        Button bt = (Button) findViewById(R.id.buttonback);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent school = new Intent(Profile2.this , MainActivity.class);
                startActivity(school);
                finish();
            }
        });

    }
}
