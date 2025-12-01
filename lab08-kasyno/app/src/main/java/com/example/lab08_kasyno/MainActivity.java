package com.example.lab08_kasyno;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GestureDetector detector;
    GestureDetector.OnGestureListener sluchacz;


    int[] grafiki = {
            R.drawable.rys01,
            R.drawable.rys02,
            R.drawable.rys03,
            R.drawable.rys04,
            R.drawable.rys05,
            R.drawable.rys06
    };
    Random random = new Random();
    ImageView iv_01, iv_02, iv_03;
    TextView tv_kwota;
    Button btn_graj;
    int kwota = 100;
    int obrazek_1, obrazek_2, obrazek_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    uchwyty();
    btn_graj.setOnClickListener(v -> graj());

    sluchacz = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            graj();
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };
    detector = new GestureDetector(this, sluchacz);
    tv_kwota.setOnTouchListener((v, event) -> {
        detector.onTouchEvent(event);
        return true;
    });
    };

    private void uchwyty() {
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        tv_kwota = findViewById(R.id.tv_kwota);
        btn_graj = findViewById(R.id.btn_graj);
    }

    void graj() {
        obrazek_1 = random.nextInt(6);
        obrazek_2 = random.nextInt(6);
        obrazek_3 = random.nextInt(6);

        if (obrazek_1 == obrazek_2 && obrazek_2 == obrazek_3) {
            kwota += 50;
        } else if (obrazek_1 == obrazek_2 || obrazek_1 == obrazek_3 || obrazek_2 == obrazek_3) {
            kwota += 5;
        } else {
            kwota -= 15;
        }
        rysuj();

    }

    private void rysuj() {
        iv_01.setImageResource(grafiki[obrazek_1]);
        iv_02.setImageResource(grafiki[obrazek_2]);
        iv_03.setImageResource(grafiki[obrazek_3]);
        tv_kwota.setText("$ " + kwota);
        if (kwota <= 0) {
            btn_graj.setEnabled(false);
        }
    }
}