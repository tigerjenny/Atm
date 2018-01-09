package com.jenny.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static int RESULT_LOGIN = 1;
    private final static int RESULT_USERINFO = 2;
    boolean logon = false;
    private EditText edUserid;

    @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_LOGIN:
                if(resultCode == RESULT_OK){
                    String userid = data.getStringExtra("LOGIN_USERID");
                    String passwd = data.getStringExtra("LOGIN_PASSWD");
                    Toast.makeText(this, "Login Userid : " + userid ,Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm",MODE_PRIVATE)
                            .edit()
                            .putString("PREF_USERID",userid)
                            .apply();
                }else{
                    finish();
                }
                break;
            case RESULT_USERINFO :
                if (resultCode == RESULT_OK) {
                    String username = data.getStringExtra("USER_NAME");
                    String userphone = data.getStringExtra("USER_PHONE");
                    Toast.makeText(this, "UserName : " + username +
                            "\nUserPhone : " + userphone, Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm",MODE_PRIVATE)
                            .edit()
                            .putString("PREF_USERNAME",username)
                            .putString("PREF_USERPHONE",userphone)
                            .apply();
                }
                break;
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(this,Ch8Activity.class));

        if(!logon){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent ,RESULT_LOGIN);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UserInfoActivity.class);
                startActivityForResult(intent,RESULT_USERINFO);

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
