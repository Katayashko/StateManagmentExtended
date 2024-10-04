package com.example.statemanagmentextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private CountViewModel countViewModel;

    private TextView hiddenTextView;
    private TextView textViewCount;
    private int count = 0;
    private EditText editTextInp;
    private Switch switcher;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hiddenTextView = findViewById(R.id.hiddenTextView);
        textViewCount = findViewById(R.id.textViewCount);
        switcher = findViewById(R.id.switcher);
        checkBox = findViewById(R.id.checkBox);
        Button buttontIncrement = findViewById(R.id.buttonIncrement);
        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);

        updateCountText();
        updateState();

        buttontIncrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                countViewModel.incrementCount();
                updateCountText();
            }
        });

        switcher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (switcher.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    countViewModel.stateOn();
                    updateState();
                } else {
                    countViewModel.stateOff();
                    updateState();
                }
            }
        });

    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + countViewModel.getcount());
    }
    private void updateState(){
        if (countViewModel.getState()) {
            hiddenTextView.setVisibility(View.VISIBLE);
        } else {
            hiddenTextView.setVisibility(View.INVISIBLE);
        }
    }
}