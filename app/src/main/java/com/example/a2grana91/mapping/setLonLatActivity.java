package com.example.a2grana91.mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

import org.osmdroid.util.GeoPoint;


public class setLonLatActivity extends AppCompatActivity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setcoordinates);

        Button btnsubmit = (Button)findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        EditText edittxtlat = (EditText)findViewById(R.id.lattxt);
        double LAT = Double.parseDouble(edittxtlat.getText().toString());

        EditText edittxtlon = (EditText)findViewById(R.id.lontxt);
        double LON = Double.parseDouble(edittxtlon.getText().toString());


        bundle.putDouble("com.example.2grana91.mapping.latitude",LAT);
        bundle.putDouble("com.example.2grana91.mapping.longitude",LON);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }

}
