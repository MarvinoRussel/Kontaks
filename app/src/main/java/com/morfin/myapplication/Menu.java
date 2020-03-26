package com.morfin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    Button btnSimpan, btnShow;
    EditText nama, nomor;
    String sNama;
    Integer sNomor;
    Realm realm;
    RealmHelper realmHelper;
    ContactModel contactModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnSimpan = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        nama = findViewById(R.id.edNama);
        nomor = findViewById(R.id.edNomor);

        Realm.init(Menu.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnShow.setOnClickListener(this);
        btnSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNama = nama.getText().toString();
            sNomor = Integer.parseInt(nomor.getText().toString());

            if (!sNomor.equals("") && !sNama.isEmpty()){
                contactModel = new ContactModel();
                contactModel.setNomor(sNomor);
                contactModel.setNama(sNama);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(contactModel);

                Toast.makeText(Menu.this, "Kontak Tersimpan", Toast.LENGTH_SHORT).show();

                nama.setText("");
                nomor.setText("");
            }else {
                Toast.makeText(Menu.this, "Harap Isi Semua Bidang", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnShow){

        }
    }
}
