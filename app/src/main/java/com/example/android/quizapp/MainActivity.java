package com.example.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        ImageView image = (ImageView) findViewById(R.id.russia_icon);
        image.setMaxHeight(height / 2);
    }

    void submit(View view) {
        int total = question_1() + question_2() + question_3() +question_4() + question_5();
        String message = getString(R.string.score, total);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    int question_1() {
        CheckBox moscowCheckBox = (CheckBox) findViewById(R.id.moscow_1);
        CheckBox peterCheckBox = (CheckBox) findViewById(R.id.peter_1);
        CheckBox sochiCheckBox = (CheckBox) findViewById(R.id.sochi_1);
        CheckBox samaraCheckBox = (CheckBox) findViewById(R.id.samara_1);
        CheckBox kazanCheckBox = (CheckBox) findViewById(R.id.kazan_1);

        if (moscowCheckBox.isChecked() && sochiCheckBox.isChecked() && !peterCheckBox.isChecked()
                && !samaraCheckBox.isChecked() && !kazanCheckBox.isChecked())
            return 1;
        else
            return 0;
    }

    int question_2() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_12);
        return radioButton.isChecked() ? 1 : 0;
    }

    int question_3() {
        EditText editText = (EditText) findViewById(R.id.capital_edit);
        return editText.getText().toString().compareToIgnoreCase(getString(R.string.moscow)) == 0 ? 1 : 0;
    }

    int question_4() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_11z);
        return radioButton.isChecked() ? 1 : 0;
    }

    int question_5() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_peter);
        return radioButton.isChecked() ? 1 : 0;
    }


}
