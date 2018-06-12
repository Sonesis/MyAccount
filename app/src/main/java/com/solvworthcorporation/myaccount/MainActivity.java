package com.solvworthcorporation.myaccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display;
    EditText ed;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.textView);
        ed = (EditText) findViewById(R.id.editText);
        b1 = findViewById(R.id.deposit);
        b2 = findViewById(R.id.withdraw);

        final PrefManager prefManager = new PrefManager(this);
        display.setText("N"+prefManager.getAmount());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ed.getText().toString().isEmpty()) {
                    prefManager.setAmount(prefManager.getAmount() + Integer.parseInt(ed.getText().toString()));
                    display.setText("N" + prefManager.getAmount());
                    ed.setText("");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ed.getText().toString().isEmpty()) {
                    prefManager.setAmount(prefManager.getAmount() - Integer.parseInt(ed.getText().toString()));
                    display.setText("N" + prefManager.getAmount());
                    ed.setText("");
                }
            }
        });
    }
}
