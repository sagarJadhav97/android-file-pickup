package com.sj56.demofilepickup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button pickupd;
TextView pathtext;
Intent myfilepick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickupd = (Button)findViewById(R.id.btnclick);
        pathtext = (TextView) findViewById(R.id.textView2);

      pickupd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              myfilepick = new Intent(Intent.ACTION_GET_CONTENT);
              myfilepick.setType("*/*");
              startActivityForResult(myfilepick,10);
          }
      });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    pathtext.setText(path);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }
}