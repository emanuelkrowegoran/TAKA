package emanuelkrowegoran.ternakode.Pesan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import emanuelkrowegoran.ternakode.R;

/**
 * Created by Hafizh Herdi on 10/15/2017.
 */

public class FirebaseDBReadSingleActivity extends AppCompatActivity {

    private Button btSubmit;
    private EditText etNama;
    private EditText etBayi;
    private EditText etNoHP;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);
        etNama = (EditText) findViewById(R.id.et_namapenumpang);
        etBayi = (EditText) findViewById(R.id.et_bayi);
        etNoHP = (EditText) findViewById(R.id.et_nohp);


        btSubmit = (Button) findViewById(R.id.bt_submit);

        etNama.setEnabled(false);
        etBayi.setEnabled(false);
        etNoHP.setEnabled(false);
        btSubmit.setVisibility(View.GONE);

        Boking barang = (Boking) getIntent().getSerializableExtra("data");
        if(barang!=null){
            etNama.setText(barang.getNama());
            etBayi.setText(barang.getBayi());
            etNoHP.setText(barang.getNohp());

        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadSingleActivity.class);
    }
}
