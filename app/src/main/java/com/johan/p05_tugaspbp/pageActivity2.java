package com.johan.p05_tugaspbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class pageActivity2 extends AppCompatActivity {
    private TableLayout table;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        table = findViewById(R.id.myTableLayout);
        btn_add = findViewById(R.id.btn_add);
        //dapatkan input
        ArrayList<String> data_nama = getIntent().getStringArrayListExtra("datas1");
        ArrayList<String> data_tempat = getIntent().getStringArrayListExtra("datas2");
        ArrayList<String> data_tanggal = getIntent().getStringArrayListExtra("datas3");
        for(int i=0;i<data_nama.size();i++)
        {
            TableRow row=new TableRow(this);
            String namez = data_nama.get(i);
            String placez = data_tempat.get(i);
            String datez = data_tanggal.get(i);
            TextView tv1= new TextView(this);
            if(!namez.isEmpty()){
                tv1.setText(namez);
                row.addView(tv1);
            tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
            TextView tv2=new TextView(this);
            if(!placez.isEmpty()){
                tv2.setText(placez);
                row.addView(tv2);
            tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
            TextView tv3=new TextView(this);
            if(!datez.isEmpty()){
                tv3.setText(datez);
                row.addView(tv3);
                tv3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
            table.addView(row);
        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putStringArrayListExtra("new_datas1", data_nama);
                intent.putStringArrayListExtra("new_datas2", data_tempat);
                intent.putStringArrayListExtra("new_datas3", data_tanggal);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(),"Data View dipause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"Data View dilanjutkan", Toast.LENGTH_SHORT).show();
        super.onResume();
    }
}