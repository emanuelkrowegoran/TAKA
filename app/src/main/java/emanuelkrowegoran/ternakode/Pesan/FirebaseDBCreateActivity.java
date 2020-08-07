package emanuelkrowegoran.ternakode.Pesan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import emanuelkrowegoran.ternakode.R;

/**
 * Created by Herdi_WORK on 08.08.17.
 */

public class FirebaseDBCreateActivity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSubmit;
    private EditText etNama;
    private EditText etNama2;
    private EditText etBayi;
    private EditText etNoHP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);

        // inisialisasi fields EditText dan Button
        etNama = (EditText) findViewById(R.id.et_namapenumpang);
        etBayi = (EditText) findViewById(R.id.et_bayi);
        etNoHP = (EditText) findViewById(R.id.et_nohp);
        etNama2 = (EditText) findViewById(R.id.et_nama2);
        btSubmit = (Button) findViewById(R.id.bt_submit);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        final Boking barang = (Boking) getIntent().getSerializableExtra("data");

        if (barang != null) {
            etNama.setText(barang.getNama());
            etBayi.setText(barang.getBayi());
            etNoHP.setText(barang.getNohp());
            etNama2.setText(barang.getnama2());
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    barang.setNama(etNama.getText().toString());
                    barang.setBayi(etBayi.getText().toString());
                    barang.setnama2(etNama2.getText().toString());
                    barang.setNohp(etNoHP.getText().toString());

                    updateBarang(barang);
                }
            });
        } else {
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isEmpty(etNama.getText().toString()) && !isEmpty(etNoHP.getText().toString()))
                        submitBarang(new Boking(etNama.getText().toString(), etBayi.getText().toString(), etNoHP.getText().toString(), etNama2.getText().toString()));
                    else
                        Snackbar.make(findViewById(R.id.bt_submit), "Data tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                    InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            etNama.getWindowToken(), 0);

                }
            });
        }
    }

    private boolean isEmpty(String s){
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updateBarang(Boking barang) {
        /**
         * Baris kode yang digunakan untuk mengupdate data barang
         * yang sudah dimasukkan di Firebase Realtime Database
         */
        database.child("Data Penumpang") //akses parent index, ibaratnya seperti nama tabel
                .child(barang.getKey()) //select barang berdasarkan key
                .setValue(barang) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update barang sukses
                         */
                        Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        }).show();
                    }
                });
    }

    private void submitBarang(Boking barang) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */


        database.child("Data Penumpang").push().setValue(barang).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNama.setText("");
                etBayi.setText("");
                etNoHP.setText("");
                etNama2.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Data Berhasil diBoking", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(FirebaseDBCreateActivity.this, FirebaseDBReadActivity.class);
                startActivity(intent);
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FirebaseDBCreateActivity.class);
    }
}
