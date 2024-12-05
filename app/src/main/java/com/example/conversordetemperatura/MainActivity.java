package com.example.conversordetemperatura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etCelsius;
    private TextView tvCelsius;
    private Button btnFarenheit;
    private Button btnKelvin;
    private TextView tvResposta;



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

        etCelsius = findViewById(R.id.etCelsius);
        etCelsius.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvCelsius = findViewById(R.id.tvCelsius);
        tvCelsius.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnFarenheit = findViewById(R.id.btnFarenheit);
        btnFarenheit.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnKelvin = findViewById(R.id.btnKelvin);
        btnKelvin.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnFarenheit.setOnClickListener(op -> converteFarenheit());
        btnKelvin.setOnClickListener(op -> converteKelvin());

    }

    private void converteKelvin() {
        double celsius = Double.parseDouble(etCelsius.getText().toString());
        double kelvin = celsius + 273.15;
        String resposta = getString(R.string.tvResposta) + " " + getString(R.string.tvKelvin)+ " " + String.format("%.2f", kelvin) + "K";
        tvResposta.setText(resposta);

    }

    private void converteFarenheit() {
        double celsius = Double.parseDouble(etCelsius.getText().toString());
        double farenheit = (celsius * 1.8) + 32;
        String resposta = getString(R.string.tvResposta)+ " " +getString(R.string.tvFarenheit)+ " " +String.format("%.2f", farenheit) + "ºF";
        tvResposta.setText(resposta);
    }
}