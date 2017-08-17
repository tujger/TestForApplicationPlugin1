package com.edeqa.testforapplicationplugin1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.edeqa.waytous.PluginService.ACTION_POST_EVENT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((EditText)findViewById(R.id.et_text)).getText().toString();
                ((TextView)findViewById(R.id.tv_text)).setText(text);

                Intent intent = new Intent(ACTION_POST_EVENT);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra("eventName", "change_number");
                intent.putExtra("eventObject", text);
                sendBroadcast(intent);

            }
        });
    }
}
