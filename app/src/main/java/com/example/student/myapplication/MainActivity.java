package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> ls;
    ArrayAdapter<String> arrayls;
    EditText edt_NoiDung;
    ListView lvw_1;

    int viTriChon=-1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ls = new ArrayList<String>();
        String[] some_array = getResources().getStringArray(R.array.mangListView);
        ls.addAll(Arrays.asList(some_array));


        arrayls = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,ls);
        lvw_1.setAdapter(arrayls);
        arrayls.notifyDataSetChanged();
        lvw_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viTriChon = i;

                edt_NoiDung.setText(ls.get(i));
            }
        });

    }
    void AnhXa(){
        edt_NoiDung = findViewById(R.id.edt_NoiDung);
        lvw_1 = findViewById(R.id.lvw_1);
    }
    public void Sua(View view) {
        if (viTriChon >= 0 ){
            if (!edt_NoiDung.getText().toString().isEmpty()){
                String nameEdit = edt_NoiDung.getText().toString();
                ls.set(viTriChon,nameEdit);
                arrayls.notifyDataSetChanged();
            }else {
                Toast.makeText(MainActivity.this,"Khong duoc de trong noi dung",Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(MainActivity.this,"Moi ban chon ten muon sua",Toast.LENGTH_LONG).show();
        }
    }
}
