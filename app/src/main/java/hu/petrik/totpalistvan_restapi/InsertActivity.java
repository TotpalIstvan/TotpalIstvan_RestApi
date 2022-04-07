package hu.petrik.totpalistvan_restapi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hu.petrik.totpalistvan_restapi.databinding.ActivityInsertBinding;

public class InsertActivity extends AppCompatActivity {
    ActivityInsertBinding dBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dBinding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(dBinding.getRoot());

        dBinding.insertVisszaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
