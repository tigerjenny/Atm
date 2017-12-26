package com.jenny.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Area1Activity extends AppCompatActivity {
    private String[] areas;
    private ListView area1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area1);
        area1 = (ListView) findViewById(R.id.area);
        areas = new String[]{"永和區","板橋區","新莊區"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
        area1.setAdapter(adapter);
    }
}
