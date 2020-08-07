package emanuelkrowegoran.ternakode.Bayar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import emanuelkrowegoran.ternakode.Menu.HomeDashboard;
import emanuelkrowegoran.ternakode.R;

public class activityBayar extends AppCompatActivity {
    LinearLayout bt_bca, bt_bri, bt_mandiri, kk_mastercard, kk_visa, ib_bca, s_indomaret, s_alfamart;
    String traveller,bank_nama,payment_code,product_schedule_id,coupon_code,pay_total,firstname,lastname,cust_id,product_id,product_price,product_name,product_model,product_qty,product_total,telephone,email,traveller_more,token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

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

        bt_bri.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(activityBayar.this, Request_payment.class);
                startActivity(intent);
            }
        });

    }}


