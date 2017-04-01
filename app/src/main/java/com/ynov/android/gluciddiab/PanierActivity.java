package com.ynov.android.gluciddiab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by romain on 31/03/2017.
 */

public class PanierActivity extends AppCompatActivity {
    ListView mListView;
    private ProgressBar mProgressBar1;
    private ProgressBar mProgressBar2;
    private RadioButton mRadio;
    String[] prenoms = new String[]{
            "Big Mac Maxi", "frite Maxi", "coca-cola", "sunday"
    };
    int[] gr = new int[]{
            2, 3, 4, 3
    };
    int[] gl = new int[]{
            6,7,5,6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);
        mProgressBar1 = (ProgressBar) findViewById(R.id.pGL);
        mProgressBar1.setMax(15);
        mProgressBar2 = (ProgressBar) findViewById(R.id.pGR);
        mProgressBar2.setMax(10);
        Customlistview adapter = new
                Customlistview(PanierActivity.this,prenoms,gr,gl,mProgressBar1,mProgressBar2);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);

        mProgressBar1 = (ProgressBar) findViewById(R.id.pGL);
        mProgressBar1.setMax(15);
        mProgressBar2 = (ProgressBar) findViewById(R.id.pGR);
        mProgressBar2.setMax(10);

        mRadio = (RadioButton) findViewById(R.id.radio_1);
        mRadio.setChecked(true);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(PanierActivity.this, "You Clicked at " +prenoms[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_1:
                if (checked)
                    mProgressBar1.setMax((int)(15*1));
                    mProgressBar2.setMax((int)(10*1));
                break;
            case R.id.radio_2:
                if (checked)
                    mProgressBar1.setMax((int)(15*1.5));
                    mProgressBar2.setMax((int)(10*1.5));
                break;
            case R.id.radio_3:
                if (checked)
                    mProgressBar1.setMax((int)(15*2));
                    mProgressBar2.setMax((int)(10*2));
                break;
            case R.id.radio_4:
                if (checked)
                    mProgressBar1.setMax((int)(15*3));
                    mProgressBar2.setMax((int)(10*3));
                break;
        }
    }
}
