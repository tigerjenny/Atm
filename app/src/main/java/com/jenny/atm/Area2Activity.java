package com.jenny.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Area2Activity extends AppCompatActivity {
    private String[] areas;
    private ListView area2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area2);
        area2 = (ListView) findViewById(R.id.area);
        areas = new String[]{"信義區","大安區","士林區"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
        area2.setAdapter(adapter);
    }
}
