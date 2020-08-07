package emanuelkrowegoran.ternakode.Pesan;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import emanuelkrowegoran.ternakode.R;


public class Pemesanan extends AppCompatActivity {
    //view objects
    Spinner idasal;
    Spinner idtujuan;
    Spinner iddewasa;
    Spinner idbayi, idkapal;
    Button buttonAdd, tombol;
    private EditText total_harga;
    private EditText etNoHP;
    public String sAsal, sTujuan, sDewasa, sBayi, sTanggal, sKapal;
    int hargaDewasa, hargaAnak;
    int hargaTotalDewasa, hargaTotalAnak, hargaTotal;
    String total;


    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    TextView idtanggal, gg;



    //a list to store all the artist from firebase database


    //our database reference object
    DatabaseReference databaseBokings;
    //variabel yang merefers ke Firebase Database



    // variable fields EditText dan Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);






        //getting the reference of artists node
        databaseBokings = FirebaseDatabase.getInstance().getReference("Data boking tiket");

        final String[] idAsal = {"Nunukan, Indonesia", "Tawau, Malaysia"};
        final String[] idTujuan = {"Nunukan, Indonesia", "Tawau, Malaysia"};
        final String[] idDewasa = {"1 orang/Dewasa", "2 orang/Dewasa"};
        final String[] idBayi = {"Tidak Ada", "1 Bayi"};
        final String[] idKapal = {"MV Tawindo (Jam 07:00 AM)", "Labuan Express Lima (Jam 08:30)", "MV Mid Express (Jam 10:00 AM)", "MV Tawindo (Jam 07:00 AM)" , "Malindo Express (Jam 12:00 PM)" , "Tawau Express (Jam 02:30 PM)" , "Sin'On Express (Jam 03:00 PM)"};

        //getting views
        idasal = (Spinner) findViewById(R.id.idAsal);
        idtujuan = (Spinner) findViewById(R.id.idTujuan);
        iddewasa = (Spinner) findViewById(R.id.idDewasa);
        idbayi = (Spinner) findViewById(R.id.idBayi);
        idkapal = (Spinner) findViewById(R.id.idKapal);
        idtanggal = findViewById(R.id.tanggal_berangkat);
        gg = findViewById(R.id.total_harga);





        tombol = (Button) findViewById(R.id.cek);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);



        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.tanggal_berangkat);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalendar.getTime()));
            }
        };

        idtanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Pemesanan.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        ArrayAdapter<CharSequence> adapterAsal = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, idAsal);
        adapterAsal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idasal.setAdapter(adapterAsal);

        ArrayAdapter<CharSequence> adapterTujuan = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, idTujuan);
        adapterTujuan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idtujuan.setAdapter(adapterTujuan);

        ArrayAdapter<CharSequence> adapterDewasa = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, idDewasa);
        adapterDewasa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        iddewasa.setAdapter(adapterDewasa);

        ArrayAdapter<CharSequence> adapterBayi = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, idBayi);
        adapterBayi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idbayi.setAdapter(adapterBayi);

        ArrayAdapter<CharSequence> adapterKapal = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, idKapal);
        adapterKapal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idkapal.setAdapter(adapterKapal);

        idasal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sAsal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        idtujuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sTujuan = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        iddewasa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sDewasa = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        idbayi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sBayi = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        idkapal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sKapal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //adding an onclicklistener to button

        buttonAdd.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void onClick(View view) {
                                             //calling the method addArtist()
                                             //the method is defined below
                                             //this method is actually performing the write operation
                                             addBoking();

                                         }
                                     }



        );
        tombol.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View view) {
                                          //calling the method addArtist()
                                          //the method is defined below
                                          //this method is actually performing the write operation
                                          perhitunganHarga();

                                      }
                                  }



        );


    }



    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    public void perhitunganHarga() {

    if (sDewasa.equalsIgnoreCase("1 orang/Dewasa") && sBayi.equalsIgnoreCase("Tidak Ada")) {
        total = "   Rp 200.000";
       gg.setText(total);
    } else if (sDewasa.equalsIgnoreCase("1 orang/Dewasa") && sBayi.equalsIgnoreCase("1 Bayi")) {
        total = "   Rp 270.000";
        gg.setText(total);
    } else if (sDewasa.equalsIgnoreCase("2 orang/Dewasa") && sBayi.equalsIgnoreCase("Tidak Ada")) {
        total = "   Rp 400.000";
        gg.setText(total);
    } else if (sDewasa.equalsIgnoreCase("2 orang/Dewasa") && sBayi.equalsIgnoreCase("1 Bayi")) {
        total = "   Rp 470.000";
        gg.setText(total);
    }
}



    private void addBoking() {


        //getting the values to save
        String asal = idasal.getSelectedItem().toString();
        String tujuan = idtujuan.getSelectedItem().toString();
        String dewasa = iddewasa.getSelectedItem().toString();
        String bayi = idbayi.getSelectedItem().toString();
        String kapal = idkapal.getSelectedItem().toString();
        String tanggal = idtanggal.getText().toString().trim();
        String TotalHarga =  gg.getText().toString().trim();








       






        //checking if the value is provided
        if(idtanggal.getText().toString().length()==0){
            idtanggal.setError("Silahkan isi");
            Toast.makeText(Pemesanan.this, "Silahkan Pilih Tanggal dulu !", Toast.LENGTH_LONG).show();

        }else if (gg.getText().toString().length()==0){
            gg.setError("Cek Harga Dulu");
            Toast.makeText(Pemesanan.this, "Silahkan Cek Harga dulu !", Toast.LENGTH_LONG).show();


        }else if ((sAsal.equalsIgnoreCase("Nunukan, Indonesia") && sTujuan.equalsIgnoreCase("Nunukan, Indonesia"))
                || (sAsal.equalsIgnoreCase("Tawau, Malaysia") && sTujuan.equalsIgnoreCase("Tawau, Malaysia"))) {
            Toast.makeText(Pemesanan.this, "Asal dan Tujuan tidak boleh sama !", Toast.LENGTH_LONG).show();

        } else {


            //if the value is not given displaying a toast
            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseBokings.push().getKey();

            //creating an Artist Object
            Boking boking = new Boking(asal, tujuan, dewasa, bayi, tanggal, TotalHarga, kapal);

            //Saving the Artist
            databaseBokings.child(id).setValue(boking);


            //displaying a success toast
            Toast.makeText(this, "Silahkan Lanjutkan", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Pemesanan.this, FirebaseDBCreateActivity.class);
            startActivity(intent);




        }
    }


    private void updateBoking() {
        /**
         * Baris kode yang digunakan untuk mengupdate data barang
         * yang sudah dimasukkan di Firebase Realtime Database
         * databaseBokings = FirebaseDatabase.getInstance().getReference("Data boking tiket");
         */

    }




    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, Pemesanan.class);
    }

}
