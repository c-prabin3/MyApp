package com.example.myapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioGroupActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox checkBox;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);

        radioGroup= findViewById(R.id.rdo_gender);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            radioButton=group.findViewById(checkedId);
            Toast.makeText(RadioGroupActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
        });

        CheckBox pizza = findViewById(R.id.checkBox);
        CheckBox coffe = findViewById(R.id.checkBox2);
        CheckBox burger = findViewById(R.id.checkBox3);
        Button buttonOrder = findViewById(R.id.button);
        TextView tvResult = findViewById(R.id.tvResult);
        buttonOrder.setOnClickListener(v -> {
            int totalamount = 0;
            StringBuffer result = new StringBuffer();
            result.append("Selected Items:");
            if (pizza.isChecked()) {
                result.append("\nPizza 100Rs");
                totalamount += 100;
            }
            if (coffe.isChecked()) {
                result.append("\nCoffe 50Rs");
                totalamount += 50;
            }
            if (burger.isChecked()) {
                result.append("\n Burger 120Rs");
                totalamount += 120;
            }
            result.append("\nTotal: " + totalamount + "Rs");
            //Displaying the message on the toast
            Log.i("SEL",result.toString());
            tvResult.setText(result.toString());
        });
    }
}