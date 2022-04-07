package hu.petrik.totpalistvan_restapi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.petrik.totpalistvan_restapi.databinding.ActivityListResultBinding;


public class ListResultActivity extends AppCompatActivity {
    ActivityListResultBinding dBinding;

    List<Varos> varosLista = new ArrayList<>();
    private String URL = "https://retoolapi.dev/PDXs0J/varosok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dBinding = ActivityListResultBinding.inflate(getLayoutInflater());
        setContentView(dBinding.getRoot());
        VarosTask varosTask = new VarosTask();
        varosTask.execute();

        dBinding.listVisszaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private class VarosTask extends AsyncTask<Void,Void,Response> {

        @Override
        protected Response doInBackground(Void... voids) {
           Response response = null;
           try {
                response = RequestHandler.get(URL);
           }catch (IOException e){
               e.printStackTrace();
           }
           return response;
        }


        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            Gson converter = new Gson();
            if (response == null || response.getResponseCode() >= 400){
                Toast.makeText(ListResultActivity.this, "Hiba történt a kérés feldolgozása során.", Toast.LENGTH_SHORT).show();
            }
            else {
                Varos[] locations = converter.fromJson(response.getContent(), Varos[].class);
                varosLista.clear();
                varosLista.addAll(Arrays.asList(locations));
                ArrayAdapter<Varos> arrayAdapter = new ArrayAdapter<>(ListResultActivity.this, R.layout.list_item, R.id.itemTextView, varosLista);
                dBinding.orszagokListView.setAdapter(arrayAdapter);
            }
        }
    }
}
