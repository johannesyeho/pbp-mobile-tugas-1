package com.johan.p05_tugaspbp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn_send;
    EditText ipt_nama,ipt_alamat,ipt_tanggal;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send = findViewById(R.id.btn_homy);
        ipt_nama = findViewById(R.id.nama);
        ipt_alamat = findViewById(R.id.alamat);
        ipt_tanggal = findViewById(R.id.tanggal);
        ArrayList<String> new_data_nama = getIntent().getStringArrayListExtra("new_datas1");
        ArrayList<String> new_data_tempat = getIntent().getStringArrayListExtra("new_datas2");
        ArrayList<String> new_data_tanggal = getIntent().getStringArrayListExtra("new_datas3");

        ArrayList<String> data_nama = new ArrayList<>();
        ArrayList<String> data_tempat = new ArrayList<>();
        ArrayList<String> data_tanggal = new ArrayList<>();
        if(new_data_nama!=null){
            for(int i=0;i<new_data_nama.size();i++){
                data_nama.add(new_data_nama.get(i));
                data_tempat.add(new_data_tempat.get(i));
                data_tanggal.add(new_data_tanggal.get(i));
            }
        }
        ipt_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                ipt_tanggal.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_nama.add(ipt_nama.getText().toString());
                data_tempat.add(ipt_alamat.getText().toString());
                data_tanggal.add(ipt_tanggal.getText().toString());
                Intent intent = new Intent(getApplicationContext(),pageActivity2.class);
                intent.putStringArrayListExtra("datas1", data_nama);
                intent.putStringArrayListExtra("datas2", data_tempat);
                intent.putStringArrayListExtra("datas3", data_tanggal);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(),"Aktifitas Home dipause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"Home dilanjutkan", Toast.LENGTH_SHORT).show();
        super.onResume();
    }
}