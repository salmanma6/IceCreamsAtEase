package com.example.salmanma.icecreamsatease;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//shop zone activity
public class shopzone extends AppCompatActivity {
  boolean notenterd=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_shopzone);
        Button a=(Button)findViewById(R.id.nxtshopzone);
        Button b=(Button)findViewById(R.id.skipshopzone);
        final EditText c=(EditText) findViewById(R.id.scn);
        final EditText d=(EditText) findViewById(R.id.scs);
        final EditText e=(EditText) findViewById(R.id.scc);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getTextSize()==0 && d.getTextSize()==0 && e.getTextSize()==0)
                    notenterd=true;
                if(notenterd)
                {
                    Toast.makeText(getApplicationContext(),"Make sure you enter in each field",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent re=new Intent();
                    setResult(Activity.RESULT_OK,re);
                    finish();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re=new Intent();
                setResult(Activity.RESULT_CANCELED,re);
                finish();
            }
        });
    }
}
