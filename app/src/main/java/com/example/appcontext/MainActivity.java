package com.example.appcontext;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner colors = findViewById(R.id.spinnerColors);
        // set the listener for the item selection of the spinner
        // the AdapterView.OnItemSelectedListener is an Interface with two methods
        colors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // called when an item is selected
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // get the text of the selected item
                String text = parent.getItemAtPosition(position).toString();
                // create a toast to show the selected color
                Toast toast = Toast.makeText(parent.getContext(), "Color "+text+" selected!", Toast.LENGTH_LONG);
                // change the background of the toast based on the selected color
                toast.getView().setBackgroundColor(Color.parseColor(text));
                // show the toast message
                toast.show();
            }

            @Override
            // called when on item is selected
            public void onNothingSelected(AdapterView<?> parent) {
                // sometimes you need nothing here
            }
        });

    }

    public void show(View view) {
        // show a Toast message with the application context
        Toast.makeText(getApplicationContext(), "Application Context", Toast.LENGTH_LONG).show();

        // show a Toast message with the activity context
        Toast.makeText(this, "Activity Context", Toast.LENGTH_LONG).show();

        // show a Toast message with a string resource
        Toast.makeText(view.getContext(), R.string.app_name, Toast.LENGTH_SHORT).show();
    }
}