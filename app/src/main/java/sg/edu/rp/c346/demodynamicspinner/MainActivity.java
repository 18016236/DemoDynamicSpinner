package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String>alNumbers;
    ArrayAdapter<String>aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdater);

        //Initialise the ArrayList
        alNumbers = new ArrayList<>();
  //Commenting...      alNumbers.add("2");
  //Commenting...      alNumbers.add("4");
  //Commenting...      alNumbers.add("6");


        //Get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        //Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alNumbers);
        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:

                        alNumbers.clear();

                        String[] evenNumbers = getResources().getStringArray(R.array.even_numbers);

                        alNumbers.addAll(Arrays.asList(evenNumbers));

                        spn2.setAdapter(aaNumbers);

                        spn2.setSelection(2);


                        break;

                    case 1:

                        alNumbers.clear();

                        String[] oddNumbers = getResources().getStringArray(R.array.odd_numbers);

                        alNumbers.addAll(Arrays.asList(oddNumbers));

                        spn2.setAdapter(aaNumbers);

                        spn2.setSelection(1);


                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
