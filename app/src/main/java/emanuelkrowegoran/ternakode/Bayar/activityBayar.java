package emanuelkrowegoran.ternakode.Bayar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import emanuelkrowegoran.ternakode.Menu.HomeDashboard;
import emanuelkrowegoran.ternakode.R;

public class activityBayar extends AppCompatActivity {
    LinearLayout bt_bca, bt_bri, bt_mandiri, kk_mastercard, kk_visa, ib_bca, s_indomaret, s_alfamart;
    String traveller, bank_nama, payment_code, product_schedule_id, coupon_code, pay_total, firstname, lastname, cust_id, product_id, product_price, product_name, product_model, product_qty, product_total, telephone, email, traveller_more, token;

    private TextView Waktu;
    private TimerClass timerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);
        Waktu = findViewById(R.id.timer);
        //Set Waktu selama 30 menit = 60000 * 3 millis dengan interval 1 detik = 1000 millis
        timerClass = new TimerClass(60000 * 30, 1000);
        timerClass.start();


        ImageButton btnback = (ImageButton) findViewById(R.id.trans_btn_back_pay);

        btnback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(activityBayar.this, HomeDashboard.class);
                startActivity(intent);
            }
        });

        final LinearLayout lay_expand_transfer = (LinearLayout) findViewById(R.id.lay_collapse_bank_transfer);
        final LinearLayout lay_expand_kk = (LinearLayout) findViewById(R.id.lay_collapse_kk);

        final ImageView btn_expand_transfer = (ImageView) findViewById(R.id.collapse_bank_transfer);
        final ImageView btn_expand_transfer_on = (ImageView) findViewById(R.id.collapse_bank_transfer_on);

        final ImageView btn_expand_kk = (ImageView) findViewById(R.id.collapse_kk);
        final ImageView btn_expand_kk_on = (ImageView) findViewById(R.id.collapse_kk_on);

        final LinearLayout expand_transfer = (LinearLayout) findViewById(R.id.expand_transfer);
        final LinearLayout expand_kk = (LinearLayout) findViewById(R.id.expand_kk);

        bt_bca = (LinearLayout) findViewById(R.id.payment_transfer_bca);
        bt_bri = (LinearLayout) findViewById(R.id.payment_transfer_bri);
        bt_mandiri = (LinearLayout) findViewById(R.id.payment_transfer_mandiri);
        kk_mastercard = (LinearLayout) findViewById(R.id.payment_kk_mastercard);
        kk_visa = (LinearLayout) findViewById(R.id.payment_kk_visa);


        lay_expand_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer_on.setVisibility(View.VISIBLE);
                bt_bri.setVisibility(View.VISIBLE);
                bt_bca.setVisibility(View.VISIBLE);
                bt_mandiri.setVisibility(View.VISIBLE);

                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);

            }
        });

        btn_expand_transfer_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);
            }
        });

        lay_expand_kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk.setVisibility(View.GONE);
                btn_expand_kk_on.setVisibility(View.VISIBLE);
                kk_mastercard.setVisibility(View.VISIBLE);
                kk_visa.setVisibility(View.VISIBLE);

                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);
            }
        });

        btn_expand_kk_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);
            }
        });

        bt_bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(activityBayar.this, bni.class);
                startActivity(intent);
            }
        });
        bt_bri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(activityBayar.this, bri.class);
                startActivity(intent);
            }
        });
        bt_mandiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(activityBayar.this, mandiri.class);
                startActivity(intent);
            }
        });
    }
        //Membuat InnerClass untuk konfigurasi Countdown Time
        public class TimerClass extends CountDownTimer {

            TimerClass(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            //Method ini berjalan saat waktu/timer berubah
            @Override
            public void onTick(long millisUntilFinished) {
                //Kenfigurasi Format Waktu yang digunakan
                String waktu = String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                //Menampilkannya pada TexView
                Waktu.setText(waktu);
            }

            @Override
            public void onFinish() {
                ///Berjalan saat waktu telah selesai atau berhenti
                Toast.makeText(activityBayar.this, "Waktu Pembayaran Telah Berakhir Harap Konfirmasi Ulang", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

