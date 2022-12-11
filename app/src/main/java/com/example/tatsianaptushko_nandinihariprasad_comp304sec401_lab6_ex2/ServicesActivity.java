package com.example.tatsianaptushko_nandinihariprasad_comp304sec401_lab6_ex2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ServicesActivity extends AppCompatActivity {
    private TextView textView, textViewInt,textViewDouble;
    //replace with your package name
    public static final String INFO_INTENT = "com.example.tatsianaptushko_nandinihariprasad_comp304sec401_lab6_ex2.INFO_UPDATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        textView = (TextView) findViewById(R.id.textView);
        textViewInt = (TextView) findViewById(R.id.textViewInt);
        textViewDouble = (TextView) findViewById(R.id.textViewDouble);
    }

    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        //@Override
        public void onReceive(Context context, Intent intent) {
            //textView.setText("Here");
            String action = intent.getAction();
            if (action.equals(SimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra(INFO_INTENT);
                textView.setText(info);

                int data = intent.getIntExtra("IntValue",0);
                textViewInt.setText("Integer from Simple Service: " + data);

                double dataDouble = intent.getDoubleExtra("DoubleValue",0);
                textViewDouble.setText("Double from Simple Service: " + dataDouble);
            }
        }
    };

    public void onResume()
    {
        super.onResume();
        //This needs to be in the activity that will end up receiving the broadcast
        registerReceiver(receiver, new IntentFilter(INFO_INTENT));

    }


    //
    public void startService(View view) {
        startService(new Intent(getBaseContext(), SimpleService.class));

    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                SimpleService.class));
    }

}
