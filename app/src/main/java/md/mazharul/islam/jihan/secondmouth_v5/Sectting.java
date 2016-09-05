package md.mazharul.islam.jihan.secondmouth_v5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sectting extends AppCompatActivity {

    EditText name , address , message , phone;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String nameKey = "nameKey";
    public static final String addresskey = "addresskey";
    public static final String messagekey = "messagekey";
    public static final String phonekey = "phonekey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sectting);

         name = (EditText) findViewById(R.id.editTextusername);
         address = (EditText) findViewById(R.id.editTextuseraddress);
         message = (EditText) findViewById(R.id.editTextusermessage);
         phone = (EditText) findViewById(R.id.editTextphonenum);

        Button done = (Button) findViewById(R.id.buttonsettingdone);




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = name.getText().toString();
                String useraddress  = address.getText().toString();
                String usermessage  = message.getText().toString();
                String emer_phone  = phone.getText().toString();

                if(phone.toString().equals("")){
                    Toast.makeText(Sectting.this,"Please fillup Emergency phone number", Toast.LENGTH_LONG).show();
                }else {
                    Intent in = new Intent(Sectting.this , MainActivity.class);

                    sharedpreferences = getSharedPreferences("file1" , MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(nameKey, username);
                    editor.putString(addresskey, useraddress);
                    editor.putString(messagekey, usermessage);
                    editor.putString(phonekey, emer_phone);
                    editor.commit();
                    Toast.makeText(Sectting.this, "Thanks", Toast.LENGTH_LONG).show();

                    startActivity(in);
                    finish();
                }
            }
        });

    }
}
