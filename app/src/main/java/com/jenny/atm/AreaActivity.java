package com.jenny.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity {
    private String[] areas;
    private ListView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        area = (ListView) findViewById(R.id.area);
        int aa = getIntent().getIntExtra("CITY_CODE",0);
        areas = new String[]{"中正區","暖暖區","八堵區"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
        area.setAdapter(adapter);

    }
}
