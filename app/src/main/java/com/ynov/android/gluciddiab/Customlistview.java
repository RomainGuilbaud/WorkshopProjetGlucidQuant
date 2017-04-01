package com.ynov.android.gluciddiab;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ynov.android.gluciddiab.R;
import com.ynov.android.gluciddiab.calculUtils.Panier;

public class Customlistview extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] textName;
    private final int[] textGR;
    private final int[] textGL;
    private final int[] textGRActuel;
    private final int[] textGLActuel;
    private ProgressBar mProgressBar1;
    private ProgressBar mProgressBar2;

    public Customlistview(Activity context,
                      String[] textName, int[] textGR,int[] textGL,ProgressBar mProgressBar1,ProgressBar mProgressBar2) {
        super(context, R.layout.row_list, textName);
        this.context = context;
        this.textName = textName;
        this.textGR = textGR;
        this.textGL = textGL;
        this.mProgressBar1=mProgressBar1;
        this.mProgressBar2=mProgressBar2;
        this.textGLActuel=textGL;
        this.textGRActuel=textGR;

    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.row_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textViewName);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.textViewGL);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.textViewGR);
        RadioGroup radio = (RadioGroup) rowView.findViewById(R.id.radioP);
       // mProgressBar1 = (ProgressBar) PanierActivity.this.findViewById(R.id.pGL);
       // mProgressBar2 = (ProgressBar) PanierActivity..findViewById(R.id.pGR);
        txtTitle.setText(textName[position]);
        txtTitle1.setText("glucide rapide: "+textGR[position]+"g");
        txtTitle2.setText("glucide lent: "+ textGL[position]+"g");

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioP_1:
                        mProgressBar1.setProgress((int)(mProgressBar1.getProgress()-textGLActuel[position]+textGL[position]*(0.25)));
                        mProgressBar2.setProgress((int)(mProgressBar2.getProgress()-textGRActuel[position]+textGR[position]*(0.25)));
                        textGLActuel[position]=(int)(textGL[position]*(0.25));
                        textGRActuel[position]=(int)(textGR[position]*(0.25));
                        break;
                    case R.id.radioP_2:
                        mProgressBar1.setProgress((int)(mProgressBar1.getProgress()-textGLActuel[position]+textGL[position]*(0.5)));
                        mProgressBar2.setProgress((int)(mProgressBar2.getProgress()-textGRActuel[position]+textGR[position]*(0.5)));
                        textGLActuel[position]=(int)(textGL[position]*(0.5));
                        textGRActuel[position]=(int)(textGR[position]*(0.5));
                        break;
                    case R.id.radioP_3:
                        mProgressBar1.setProgress((int)(mProgressBar1.getProgress()-textGLActuel[position]+textGL[position]*(0.75)));
                        mProgressBar2.setProgress((int)(mProgressBar2.getProgress()-textGRActuel[position]+textGR[position]*(0.75)));
                        textGLActuel[position]=(int)(textGL[position]*(0.75));
                        textGRActuel[position]=(int)(textGR[position]*(0.75));
                        break;
                    case R.id.radioP_4:
                        mProgressBar1.setProgress((int)(mProgressBar1.getProgress()-textGLActuel[position]+textGL[position]*(1)));
                        mProgressBar2.setProgress((int)(mProgressBar2.getProgress()-textGRActuel[position]+textGR[position]*(1)));
                        textGLActuel[position]=(int)(textGL[position]*(1));
                        textGRActuel[position]=(int)(textGR[position]*(1));
                        break;
                    default:
                        break;
                }
            }
        });

        return rowView;
    }
}