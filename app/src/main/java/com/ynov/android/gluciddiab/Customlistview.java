package com.ynov.android.gluciddiab;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ynov.android.gluciddiab.R;

public class Customlistview extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] textName;
    private final String[] textGR;
    private final String[] textGL;
    public Customlistview(Activity context,
                      String[] textName, String[] textGR,String[] textGL) {
        super(context, R.layout.row_list, textName);
        this.context = context;
        this.textName = textName;
        this.textGR = textGR;
        this.textGL = textGL;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.row_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textViewName);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.textViewGL);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.textViewGR);

        txtTitle.setText(textName[position]);
        txtTitle1.setText("glucide rapide: "+textGR[position]);
        txtTitle2.setText("glucide lent: "+textGL[position]);

        return rowView;
    }
}