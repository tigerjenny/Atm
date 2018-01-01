package com.jenny.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] areas;
    private ListView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        area = (ListView) findViewById(R.id.area);
        int aa = getIntent().getIntExtra("CITY_CODE",0);

        switch (aa){
            case 0:
                areas = new String[]{"中正區","暖暖區","八堵區"};
                break;
            case 1:
                areas = new String[]{"永和區","板橋區","新莊區"};
                break;
            case 2:
                areas = new String[]{"信義區","大安區","士林區"};
                break;
        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
        area.setAdapter(adapter);
        area.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        getIntent().putExtra("AREA_CODE",areas[i]);
        setResult(RESULT_OK,getIntent());
        finish();

    }
}
