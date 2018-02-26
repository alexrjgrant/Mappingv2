package com.example.a2grana91.mapping;

    import android.app.Activity;
    import android.os.Bundle;
    import android.content.Intent;
    import android.widget.Button;
    import android.view.View;

public class choose_map_activity extends Activity implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_map_activity);

        Button regular = (Button)findViewById(R.id.btnRegular),
        hikebikemap = (Button)findViewById(R.id.btnHikeBikeMap);

        hikebikemap.setOnClickListener(this);
        regular.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        boolean hikebikemap = false;
        boolean blnregular  = false;

        if (v.getId()==R.id.btnHikeBikeMap)
        {
            hikebikemap=true;
        }
        else if (v.getId()== R.id.btnRegular)
        {
            blnregular = true;
        }

        bundle.putBoolean("hikebikemap",hikebikemap);
        bundle.putBoolean("regmap",blnregular);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}