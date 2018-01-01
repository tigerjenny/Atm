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
import android.widget.Toast;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = CityActivity.class.getSimpleName() ;
    private String[] cities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        ListView city = (ListView) findViewById(R.id.city);
        cities = new String[]{"基隆市", "新北市", "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        //Log.d(TAG, "onItemClick:" + "/" + cities[position]);

        Intent intent = new Intent(this,AreaActivity.class);
        intent.putExtra("CITY_CODE",position);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String area = data.getStringExtra("AREA_CODE");
            Toast.makeText(this,area,Toast.LENGTH_LONG).show();
        }
    }
}
