package hu.petrik.totpalistvan_restapi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import hu.petrik.totpalistvan_restapi.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

ActivityMainBinding dBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(dBinding.getRoot());


        dBinding.listazasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListResultActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dBinding.ujFelvetelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}