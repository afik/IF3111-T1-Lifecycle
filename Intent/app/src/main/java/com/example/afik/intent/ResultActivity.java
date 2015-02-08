package com.example.afik.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class ResultActivity extends Activity {

   @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
           return;
        }
        String value1 = extras.getString("valueSend");
        if (value1 != null) {
           TextView text = (TextView) findViewById(R.id.displayintentextra);
        }
   }

   @Override
    public void finish() {
       Intent intent = new Intent();
       EditText editText = (EditText) findViewById(R.id.returnValue);
       String string = editText.getText().toString();
       intent.putExtra("return", string);
       setResult(RESULT_OK, intent);
       super.finish();
   }
}
