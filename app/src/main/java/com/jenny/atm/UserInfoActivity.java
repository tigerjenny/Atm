package com.jenny.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edName = (EditText) findViewById(R.id.ed_name);
        edPhone = (EditText) findViewById(R.id.ed_phone);
    }

    public void userInfo(View view){
        String userName = edName.getText().toString();
        String userPhone = edPhone.getText().toString();

        getIntent().putExtra("USER_NAME",userName);
        getIntent().putExtra("USER_PHONE",userPhone);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
