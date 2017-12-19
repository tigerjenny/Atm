package com.jenny.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPhone;
    private Spinner ages;
    private String TAG = Ch8Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edName = (EditText) findViewById(R.id.ed_name);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        String userName = getSharedPreferences("atm",MODE_PRIVATE).getString("PREF_USERNAME","");
        edName.setText(userName);
        String userPhone = getSharedPreferences("atm",MODE_PRIVATE).getString("PREF_USERPHONE","");
        edPhone.setText(userPhone);

        ages = (Spinner) findViewById(R.id.ages);
        /*ArrayList<String> data = new ArrayList<>();
        for ( int i = 15; i<=40 ; i++){
            data.add(i+" ");
        }*/
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.ages));
        ages.setAdapter(adapter);
    }

    public void userInfo(View view){
        Log.d(TAG , "OK :" + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        String userName = edName.getText().toString();
        String userPhone = edPhone.getText().toString();

        getIntent().putExtra("USER_NAME",userName);
        getIntent().putExtra("USER_PHONE",userPhone);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
