package com.example.list_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static ListView l1;ArrayAdapter<String> a;
   List<String> colorlist= Arrays.asList( "red","yellow","magenta","voilet","blue","indigo","transparent",
           "priya","chiya","ishi","john","sam","joe","hedric","pink","green","rat","mouse","cat","tiger",
           "rose","lily","jasmine","sun flower","lotus","zebra","yak","ox","blue","yoghurt","apple",
           "banana","orange","mango");

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView(); }
    public void ListView(){
        l1=(ListView )findViewById(R.id.ll);
        a=new  ArrayAdapter<String>(this,R.layout.names,colorlist);
        l1.setAdapter(a);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {@Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String s=(String)l1.getItemAtPosition(position);
               // Toast.makeText(MainActivity.this,"position :" +position+ " s :" +s,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
           // intent.putExtra("pos", position);
            intent.putExtra("name",s);
            startActivity(intent);
            }}); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.sort1){
            Collections.sort(colorlist);
            a.notifyDataSetChanged();
        }
        else if(id==R.id.sort2){
            Collections.sort(colorlist,Collections.<String>reverseOrder());
            a.notifyDataSetChanged();
        }
        return true;
    }
}