package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_plus, btn_minus;
    TextView tv_licznik;

    int licznik = 0;

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

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        tv_licznik = findViewById(R.id.tv_licznik);

        tv_licznik.setText(String.valueOf(licznik));
    }

    public void dodaj(View view) {
        licznik++;
        tv_licznik.setText(String.valueOf(licznik));

    }

    public void zmniejsz(View view) {
        licznik--;
        tv_licznik.setText(String.valueOf(licznik));
    }

    public void resetuj(View view) {
        licznik = 0;
        tv_licznik.setText(String.valueOf(licznik));
    }
}