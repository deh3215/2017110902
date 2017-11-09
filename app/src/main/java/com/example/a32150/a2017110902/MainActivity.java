package com.example.a32150.a2017110902;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    int count;
    //ImageView iv;
    MyAdapter adapter;
    ListView lv;
    Zoo z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //iv=(ImageView)findViewById(R.id.imageView);
        lv = (ListView) findViewById(R.id.listView);

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        z = gson.fromJson(response, Zoo.class);
                        //count = z.result.count;
                        //Log.d("ZOO", z.result.results[0].E_Name);
                        adapter = new MyAdapter(MainActivity.this, z.result.results);
                        lv.setAdapter(adapter);
//                        for(int i=0; i<count; i++)  {
//                            //Picasso.with(MainActivity.this).load(z.result.results[0].E_Pic_URL).into(iv);
//                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("ZOO", "Error:" + error.toString());
            }
        });
        queue.add(request);
        queue.start();

        lv.setOnItemClickListener(listener);
    }
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Uri uri = Uri.parse(z.result.results[i].E_URL);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setData(uri);
            startActivity(intent);
        }
    };



}
