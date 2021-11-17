package dk.tec.colordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private View vColorSample;
    private Spinner spnRed, spnGreen, spnBlue, spnBeverages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colorArr = {"00", "10", "20", "30", "40", "50", "60", "70", "80", "90", "A0", "B0", "C0", "D0", "E0", "F0", "FF"};

        String[] beverages = {"Vælg", "Kaffe", "The", "Juice", "Vand"};

        ArrayAdapter<String> beveragesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, beverages);

        vColorSample = findViewById(R.id.vColorSample);
        spnRed = findViewById(R.id.spnRed);
        spnGreen = findViewById(R.id.spnGreen);
        spnBlue = findViewById(R.id.spnBlue);
        spnBeverages = findViewById(R.id.spnBeverages);

        spnBeverages.setAdapter(beveragesAdapter);

        spnBeverages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    return;
                }
                Toast.makeText(MainActivity.this, beverages[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, colorArr);

        spnRed.setAdapter(adapter);
        spnGreen.setAdapter(adapter);
        spnBlue.setAdapter(adapter);

        spnRed.setOnItemSelectedListener(this);
        spnGreen.setOnItemSelectedListener(this);
        spnBlue.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String colorStr = spnRed.getSelectedItem().toString();
        colorStr += spnGreen.getSelectedItem().toString();
        colorStr += spnBlue.getSelectedItem().toString();

        int colorInt = Integer.parseInt(colorStr, 16);
        colorInt += 0xFF000000;

        //System.out.println(colorInt);

        vColorSample.setBackgroundColor(colorInt);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}