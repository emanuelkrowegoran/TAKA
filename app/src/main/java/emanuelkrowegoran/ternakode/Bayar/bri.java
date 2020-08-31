package emanuelkrowegoran.ternakode.Bayar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import emanuelkrowegoran.ternakode.R;

public class bri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bri);

        ImageButton btnback = (ImageButton) findViewById(R.id.kembalibri);

        btnback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(bri.this, activityBayar.class);
                startActivity(intent);
            }
        });
    }
}