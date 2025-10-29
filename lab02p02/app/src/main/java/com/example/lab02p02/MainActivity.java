package com.example.lab02p02;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int a, b, wynik;
    Random random = new Random();
    TextView tv_dzialanie, tv_odpowiedz;
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
        tv_dzialanie = findViewById(R.id.tv_dzialanie);
        tv_odpowiedz = findViewById(R.id.tv_odpowiedz);
        dzialanie();
    }

    void dzialanie(){
        a = random.nextInt(100);
        b = random.nextInt(100);
        int los = random.nextInt(2);
        if(los == 0)
            wynik = a * b;
        else
            wynik = random.nextInt(10000);
        String s = a + " * " + b + " = " + wynik;
        tv_dzialanie.setText(s);
    }

    public void resetuj(View view) {
        dzialanie();
        tv_odpowiedz.setText("");
    }

    public void tak(View view) {
        if(wynik == a*b)
            tv_odpowiedz.setText("Odpowiedziałeś dobrze");
        else
            tv_odpowiedz.setText("Odpowiedziałeś źle");

    }

    public void nie(View view) {
        if(wynik != a*b)
            tv_odpowiedz.setText("Odpowiedziałeś dobrze");
        else
            tv_odpowiedz.setText("Odpowiedziałeś źle");
    }
}