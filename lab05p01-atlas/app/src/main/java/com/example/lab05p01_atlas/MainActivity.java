package com.example.lab05p01_atlas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int[] rysunki = {R.drawable.prawdziwek,
    R.drawable.podgrzybek,
    R.drawable.muchomor,
    R.drawable.kania};

    String[] nazwy;
    String[] opisy;
    int pozycja =0;

    TextView tv_nazwa, tv_opis;
    ImageView ramka;
    Button btn_p, btn_n;

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
        nazwy = getResources().getStringArray(R.array.nazwy);
        opisy = getResources().getStringArray(R.array.opisy);
        znajdzUchwyty();

        tv_nazwa.setText(nazwy[pozycja]);
        tv_opis.setText(opisy[pozycja]);
        ramka.setImageResource(rysunki[pozycja]);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = v.getId();
                if (Id == R.id.button01) {
                    pozycja++;
                    if (pozycja >= rysunki.length)
                        pozycja = 0;
                } else if (Id == R.id.button02) {
                        pozycja--;
                        if (pozycja < 0)
                            pozycja = rysunki.length - 1;
                }
                tv_nazwa.setText(nazwy[pozycja]);
                tv_opis.setText(opisy[pozycja]);
                ramka.setImageResource(rysunki[pozycja]);
            }
        };
        btn_n.setOnClickListener(sluchacz);
        btn_p.setOnClickListener(sluchacz);
    }

    private void znajdzUchwyty() {
        tv_nazwa = findViewById(R.id.textView02);
        tv_opis = findViewById(R.id.textView03);
        ramka = findViewById(R.id.imageView01);
        btn_p = findViewById(R.id.button01);
        btn_n = findViewById(R.id.button02);
    }
}