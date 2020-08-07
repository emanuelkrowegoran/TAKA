package emanuelkrowegoran.ternakode.Menu;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import emanuelkrowegoran.ternakode.Bayar.activityBayar;
import emanuelkrowegoran.ternakode.Info.InfoActivity;
import emanuelkrowegoran.ternakode.Pesan.FirebaseDBReadActivity;
import emanuelkrowegoran.ternakode.Pesan.Pemesanan;
import emanuelkrowegoran.ternakode.R;

public class HomeDashboard extends AppCompatActivity {
    CardView mycard ;
    Intent i, ii, iii, iiii ;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);
        ll = (LinearLayout) findViewById(R.id.ll);

        mycard = (CardView) findViewById(R.id.infoId);
        i = new Intent(this, InfoActivity.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        mycard = (CardView) findViewById(R.id.pesanId);
        ii = new Intent(this, Pemesanan.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ii);
            }
        });

        mycard = (CardView) findViewById(R.id.RiwayatId);
        iii = new Intent(this, FirebaseDBReadActivity.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iii);
            }
        });


        mycard = (CardView) findViewById(R.id.tiketId);
        iiii = new Intent(this, activityBayar.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iiii);
            }
        });




    }
}