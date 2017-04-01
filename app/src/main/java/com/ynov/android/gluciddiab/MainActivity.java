package com.ynov.android.gluciddiab;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private Button mButton;
    private RadioButton radioButton;
    private TextView textTGR;
    private TextView textTGL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère les composants de notre layout
        mProgressBar = (ProgressBar) findViewById(R.id.pBAsync);
        mProgressBar.setMax(15);
        mButton = (Button) findViewById(R.id.btnLaunch);
        textTGR= (TextView)findViewById(R.id.textTGR);
        textTGL= (TextView)findViewById(R.id.textTGL);

        // On met un Listener sur le bouton
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                /*ProgressBarCalcul calcul = new ProgressBarCalcul();
                calcul.execute();*/
                if(mProgressBar.getProgress()==15){
                    mProgressBar.setProgress(0);
                }
                mProgressBar.setProgress(mProgressBar.getProgress()+1);
                if(mProgressBar.getProgress()>mProgressBar.getMax()){
                    Toast.makeText(getApplicationContext(), "Taux maximum de glucide dépassé", Toast.LENGTH_LONG).show();
                }
                textTGR.setText("Taux de glucide rapide:"+mProgressBar.getProgress());
                textTGL.setText("Taux de glucide lent:"+mProgressBar.getProgress());

            }
        });
    }

    public class ProgressBarCalcul extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Début du traitement asynchrone", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // Mise à jour de la ProgressBar
            mProgressBar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            int progress;
            for (progress = 0; progress <= 100; progress++) {
                for (int i = 0; i < 1000000; i++) {
                }
                //la méthode publishProgress met à jour l'interface en invoquant la méthode onProgressUpdate
                publishProgress(progress);
                progress++;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(getApplicationContext(), "Le traitement asynchrone est terminé", Toast.LENGTH_LONG).show();
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_1:
                if (checked)
                    mProgressBar.setMax((int)(15*1));
                    break;
            case R.id.radio_2:
                if (checked)
                    mProgressBar.setMax((int)(15*1.5));
                    break;
            case R.id.radio_3:
                if (checked)
                    mProgressBar.setMax((int)(15*2));
                    break;
            case R.id.radio_4:
                if (checked)
                    mProgressBar.setMax((int)(15*3));
                    break;
        }
    }
}