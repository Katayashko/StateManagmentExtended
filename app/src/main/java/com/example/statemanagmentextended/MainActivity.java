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
    private StateViewModel StateViewModel;
    private TextView hiddenTextView;
    private TextView textViewCount;
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
        editTextInp = findViewById(R.id.editTextInp);
        StateViewModel = new ViewModelProvider(this).get(StateViewModel.class);


        updateCountText();
        updateState();
        updateMode();
        updateEditText();
        getEditText();


        buttontIncrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                StateViewModel.incrementCount();
                updateCountText();
            }
        });

        switcher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (switcher.isChecked()) {
                    StateViewModel.stateSOn();
                    updateMode();
                } else {
                    StateViewModel.stateSOff();
                    updateMode();
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    StateViewModel.stateCBOn();
                    updateState();
                } else {
                    StateViewModel.stateCBOff();
                    updateState();
                }
            }
        });
    }

    private void updateEditText(){
        StateViewModel.updateEditText(editTextInp.getText().toString());
    }

    private void getEditText(){
        StateViewModel.getEditText();
    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + StateViewModel.getcount());
    }
    private void updateState(){
        if (StateViewModel.getStateCB()) {
            hiddenTextView.setVisibility(View.VISIBLE);
        } else {
            hiddenTextView.setVisibility(View.INVISIBLE);
        }
    }
    private void updateMode(){
        if (StateViewModel.getStateS()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}