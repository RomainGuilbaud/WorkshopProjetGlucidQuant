package com.ynov.android.gluciddiab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by romain on 31/03/2017.
 */

public class PanierActivity extends AppCompatActivity {
    ListView mListView;
    String[] prenoms = new String[]{
            "Big Mac Maxi", "frite Maxi", "coca-cola", "sunday"
    };
    String[] gr = new String[]{
            "2g", "3g", "4g", "3g"
    };
    String[] gl = new String[]{
            "6g", "7g", "5g", "6g"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);
        Customlistview adapter = new
                Customlistview(PanierActivity.this,prenoms,gr,gl);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);
    }
}
