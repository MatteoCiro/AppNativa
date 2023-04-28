package com.example.testdedaltonismo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    int[] colors = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.BLACK,
            Color.WHITE,
            Color.GRAY,
            Color.CYAN
    };

    String[] colorNames = {
            "Rojo",
            "Verde",
            "Azul",
            "Amarillo",
            "Negro",
            "Blanco",
            "Gris",
            "Cian"
    };

    int currentIndex = 0;

    TextView txtColor;
    TextView txtNumber;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        txtColor = findViewById(R.id.txt_color);
        txtNumber = findViewById(R.id.txt_number);
        btnNext = findViewById(R.id.btn_next);

        showNextColor();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex < colors.length) {
                    showNextColor();
                } else {
                    finishTest();
                }
            }
        });
    }

    private void showNextColor() {
        txtColor.setBackgroundColor(colors[currentIndex]);
        txtNumber.setText(String.valueOf(currentIndex + 1));
    }

    private void finishTest() {
        Intent intent = new Intent(TestActivity.this, ResultActivity.class);
        startActivity(intent);
        finish();
    }
}

