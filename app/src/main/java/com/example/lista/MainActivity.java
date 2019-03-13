package com.example.lista;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp[] = new MediaPlayer[2];
    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vectormp[0] = MediaPlayer.create(this, R.raw.be);
        vectormp[1] = MediaPlayer.create(this, R.raw.star);


        listView=(ListView) findViewById(R.id.lista);

        names= new ArrayList<String>();
        names.add("Erubiel");
        names.add("Faraon");
        names.add("Juan");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                vectormp[position].start();
                Toast.makeText(MainActivity.this, "Clicked: "+names.get(position), Toast.LENGTH_LONG).show();

                if(vectormp[position].isPlaying()){
                   vectormp[position].stop();

                }

            }
        });
    }


    }
