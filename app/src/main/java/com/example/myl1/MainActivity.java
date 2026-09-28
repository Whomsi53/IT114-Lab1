package com.example.myl1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processPress(View view)
            throws java.io.IOException {

        EditText infile = findViewById(R.id.edit_infile);
        TextView output = findViewById(R.id.text_main);

        String filename = infile.getText().toString();

        Scanner file = new Scanner(getAssets().open(filename));

        ArrayList<Double> values = new ArrayList<>();

        while (file.hasNext()) {
            values.add(file.nextDouble());
        }

        file.close();

        double[] a = new double[values.size()];

        for (int i = 0; i < values.size(); i++) {
            a[i] = values.get(i);
        }

        int num_vals = a.length;

        floor_it(a, num_vals);

        String result = "";

        for (int i = 0; i < num_vals; i++) {
            result += String.format("%.2f", a[i]) + "\n";
        }

        output.setText(result);
    }

    public void floor_it(double[] a, int num_vals) {

        for (int i = 0; i < num_vals; i++) {
            a[i] = Math.floor(a[i]);
        }
    }
}