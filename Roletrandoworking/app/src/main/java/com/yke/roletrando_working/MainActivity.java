package com.yke.roletrando_working;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.EditText;
import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

  public ArrayList<String> restList;
  RecyclerView mRecyclerView;
  RecyclerView.LayoutManager mLayoutManager;
  RecyclerView.Adapter mAdapter;
  private EditText GetValue;
  Calendar cal = Calendar.getInstance();
  private int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);


  public int getDayOfWeek() {
    return dayOfWeek;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mRecyclerView = findViewById(R.id.recycler_view);

    restList = new ArrayList<>();
    restList.add("Aulus");
    restList.add("Bardana");
    restList.add("BK");
    restList.add("Casa da moqueca");

    mLayoutManager = new LinearLayoutManager(this);
    mAdapter = new MainAdapter(restList);
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setAdapter(mAdapter);

  FloatingActionButton fab = findViewById(R.id.fab);
    FloatingActionButton fab2 = findViewById(R.id.fab2);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Enter restaurant name:");

        final EditText et = new EditText(MainActivity.this);
        ab.setView(et);

        ab.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            restList.add(et.getText().toString());
          }
        });

        ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
          }
        });

        AlertDialog a=ab.create();
        a.show();
      }
    });

    fab2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        if (getDayOfWeek() == 6)
        {
          restList.clear();
          restList.add("BK");
        }

        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.VERTICAL, true);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new CenterScrollListener());
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
      }
    });
  }



    @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
