package com.example.afik.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickResult(View view) {
        EditText text = (EditText) findViewById(R.id.inputforintent);
        String value = text.getText().toString();
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("valueSend", value);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void onClickBrowser(View view) {
        Intent i = new Intent(this, BrowserActivity.class);
        startActivity(i);
    }

    public void onClickImagePick(View view) {
        Intent i = new Intent(this, ImageActivity.class);
        startActivity(i);
    }

    public void onClickImplicit(View view) {
        Intent i = new Intent(this, ImageActivity.class);
        startActivity(i);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode ==REQUEST_CODE) {
            if (data.hasExtra("returnkey")) {
                String result = data.getExtras().getString("returnkey");
                if (result != null && result.length() > 0) {
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
