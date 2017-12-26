package com.jenny.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = CityActivity.class.getSimpleName() ;
    private String[] cities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        ListView city = (ListView) findViewById(R.id.city);
        cities = new String[] {"基隆市", "新北市","台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cities);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Log.d(TAG, "onItemClick:" + "/" + cities[position]);
        switch (position) {
            case 0:
                Intent intent = new Intent(this, AreaActivity.class);
                intent.putExtra("CITY_CODE",0);
                startActivityForResult(intent, 200);
                break;
            case 1:
                Intent intent1 = new Intent(this, Area1Activity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, Area2Activity.class);
                startActivity(intent2);
                break;
        }

    }
}
