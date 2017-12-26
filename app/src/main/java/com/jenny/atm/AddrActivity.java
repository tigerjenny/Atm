package com.jenny.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddrActivity extends AppCompatActivity {

    private Spinner city;
    private Spinner country;
    private String TAG = AddrActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);

        city = (Spinner) findViewById(R.id.city);
        country =(Spinner) findViewById(R.id.country);
        final String[] data = {"基隆市" , "新北市" , "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        city.setAdapter(adapter);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
         @Override
         public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
             String[] data1 = null;
             if(position == 0){
                 data1 = new String[]{"中正區","暖暖區","八堵區"};
             }else if (position == 1){
                 data1 = new String[]{"永和區","板橋區","新莊區"};
             }else {
                 data1 = new String[]{"信義區","大安區","士林區"};
             }
             ArrayAdapter adapter1 = new ArrayAdapter(AddrActivity.this,android.R.layout.simple_list_item_1,data1);
             country.setAdapter(adapter1);

           }
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
             }
             }
        );


    }
}
