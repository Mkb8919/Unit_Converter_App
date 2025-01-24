package com.example.unitconverterapp;

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

    EditText editText;
   Button btn;
   TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textview);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Getting the uder input(kilos)
                    String inputText = editText.getText().toString();

                    // Converting a string into double
                    double kilos = Double.parseDouble(inputText);

                    // Converting kilo into pounds;
                    double pounds = makeConversion(kilos);

                    // Displaying the conversion result
                    textView.setText("" + pounds);
                }
            });

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            });
        }
        public double makeConversion(double kilos){
//        1 kilo = 2.2042 pounds
            return kilos * 2.20462 ;
        }

}