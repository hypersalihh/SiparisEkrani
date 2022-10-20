package com.example.sipariskullaniciadresi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] iller = {"KONYA", "KAYSERİ"};
    private String[] ilceler0 = {"AHIRLI", "AKÖREN", "AKŞEHİR", "ALTINTEKİR", "BEYŞEHİR", "BOZKIR", "CİHANBEYLİ", "ÇELTİK", "ÇUMRA", "DERBENT", "DEREBUCAK", "DOĞANHİSAR", "EMRİGAZİ", "EREĞLİ", "GÜNEYSINIR", "HADİM", "HALKAPINAR", "HÜYÜK" , "ILGIN", "KADINHANI", "KARAPINAR", "KULU", "SARAYÖNÜ", "SEYDİŞEHİR", "TAŞKENT", "TUZLUKÇU", "YALIHÜYÜK", "YUNAK"};
    private String[] ilceler1 = {"BÜNYAN", "AKKIŞLA", "DEVELİ", "İNCESU", "HACILAR", "KOCASİNAN", "MELİKGAZİ", "SARIOĞLAN", "PINARBAŞI", "SARIZ", "YAHYALI", "YEŞİLHİSAR", "TOMARZA", "TALAS", "FELAHİYE", "ÖZVATAN"};

    private Spinner spinnerIller;
    private Spinner spinnerIlceler;
    private ArrayAdapter<String> dataAdapterForIller;
    private ArrayAdapter<String> dataAdapterForIlceler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerIller = (Spinner) findViewById(R.id.spinnerid);
        spinnerIlceler = (Spinner) findViewById(R.id.spinnerid2);


        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ilceler0);


        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerIller.setAdapter(dataAdapterForIller);
        spinnerIlceler.setAdapter(dataAdapterForIlceler);


        spinnerIller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getSelectedItem().toString().equals(iller[0]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, ilceler0);
                else if (parent.getSelectedItem().toString().equals(iller[1]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, ilceler1);

                dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerIlceler.setAdapter(dataAdapterForIlceler);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        spinnerIlceler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(getBaseContext(), ""+spinnerIller.getSelectedItem().toString()+"/"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hoşgeldiniz", Toast.LENGTH_SHORT).show();
            }
        });

    }
}




