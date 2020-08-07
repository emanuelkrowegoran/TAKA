package emanuelkrowegoran.ternakode.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import emanuelkrowegoran.ternakode.IntroSlider.WelcomeActivity;
import emanuelkrowegoran.ternakode.Menu.HomeDashboard;
import emanuelkrowegoran.ternakode.R;


public class IntroAwal extends AppCompatActivity {

    Button menu;
    Button intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);
        menu = findViewById(R.id.menu);
        intro = findViewById(R.id.intro);

        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(IntroAwal.this, HomeDashboard.class);
                startActivity(intent);
            }
        });
        intro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(IntroAwal.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });

    }

}

