package com.example.a2grana91.mapping;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.app.ListActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    MapView mv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));


        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(17);
        mv.getController().setCenter(new GeoPoint(50.9085,-1.4002));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choose_map)
        {
            // react to the menu item being selected...
            Intent intent = new Intent(this,choose_map_activity.class);
            startActivityForResult(intent,0);
            return true;
        }
        if(item.getItemId() == R.id.setC)
        {
            // react to the menu item being selected...
            Intent intent = new Intent(this,setLonLatActivity.class);
            startActivityForResult(intent,1);
            return true;
        }
        return false;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0) // if the choose map activity is sending an Intent back
        {
            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebikemap = extras.getBoolean("hikebikemap");
                boolean blnregular = extras.getBoolean("regmap");
                if(hikebikemap==true)
                {
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
        if(requestCode==1) // if the choose map activity is sending an Intent back
        {
            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                double LAT = extras.getDouble("com.example.2grana91.mapping.latitude");
                double LON = extras.getDouble("com.example.2grana91.mapping.longitude");
                mv.getController().setCenter(new GeoPoint(LAT,LON));
            }
        }

    }

    public void onClick(View view)
    {
        EditText edittxtlat = (EditText)findViewById(R.id.lattxt);
        double LAT = Double.parseDouble(edittxtlat.getText().toString());

        EditText edittxtlon = (EditText)findViewById(R.id.lontxt);
        double LON = Double.parseDouble(edittxtlon.getText().toString());

        mv.getController().setCenter(new GeoPoint(LAT,LON));
    }
}






