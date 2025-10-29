package com.example.lab03p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et_a, et_b, et_c;
    TextView tv_wynik;
    Button btn_oblicz, btn_wyczysc;



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
        znajdzWidoki();
        btn_oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                float a = Float.parseFloat(et_a.getText().toString());
//                float b = Float.parseFloat(et_b.getText().toString());
//                float c = Float.parseFloat(et_c.getText().toString());

                String a_str = et_a.getText().toString();
                String b_str = et_b.getText().toString();
                String c_str = et_c.getText().toString();
                if(a_str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole a jest obowiązkowe", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(b_str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole b jest obowiązkowe", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(c_str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole c jest obowiązkowe", Toast.LENGTH_SHORT).show();
                    return;
                }
                float a = Float.parseFloat(a_str);
                float b = Float.parseFloat(b_str);
                float c = Float.parseFloat(c_str);

                tv_wynik.setText(oblicz(a,b,c));
            }
        });
    }

    private void znajdzWidoki() {
        et_a = findViewById(R.id.et_a);
        et_b = findViewById(R.id.et_b);
        et_c = findViewById(R.id.et_c);
        tv_wynik = findViewById(R.id.tv_wynik);
        btn_oblicz = findViewById(R.id.btn_oblicz);
        btn_wyczysc = findViewById(R.id.btn_reset);
    }

    private String oblicz(float a, float b, float c) {
        String odp="";
        float delta = b*b - 4*a*c;
        if(a==0)
        {
            odp = "To nie jest równanie kwadratowe";
            return odp;
        }
        if(delta<0)
        {
            odp = "Brak rozwiązań";
            return odp;
        }
        if(delta==0)
        {
            odp = "Jedno rozwiązanie: " + (-b/(2*a));
            return odp;
        }
        double x1 = (-b+Math.sqrt(delta))/(2*a);
        x1 = Math.round(x1*10000)/10000.0;
        double x2 = (-b-Math.sqrt(delta))/(2*a);
        x2 = Math.round(x2*10000)/10000.0;
        odp = "Dwa rozwiązania: \n" + x1 + "\noraz\n" + x2;
        return odp;
    }
}