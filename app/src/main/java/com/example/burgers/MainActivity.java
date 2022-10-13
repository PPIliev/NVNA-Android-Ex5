package com.example.burgers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2, imageView3;

    //Keeping track of added items to favourite and to cart
    List<String> fave = new ArrayList<>();
    List<String> cart = new ArrayList<>();

    //Name of the item
    String orderName;

    //for counting number of cart items
    int mack = 0;
    int fish = 0;
    int mcchicken = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        //On click listeners
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderName = "Биг Мак";
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderName = "Макчикън";
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderName = "Филе-О-Фиш";
            }
        });

        //Adding to context menu
        registerForContextMenu(imageView);
        registerForContextMenu(imageView2);
        registerForContextMenu(imageView3);

    }

    //Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
                openFaveActivity();
        } else if (item.getItemId() == R.id.item2) {
            openGoogleMaps();
        } else if (item.getItemId() == R.id.item3) {
                openCartActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:
                if (fave.contains(orderName)) {
                    Toast.makeText(this, orderName + " вече е добавен в любими.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, orderName + " е добавен в любими.", Toast.LENGTH_SHORT).show();
                    fave.add(orderName);
                }
                return true;
            case R.id.option2:
                Toast.makeText(this, orderName + " е добавен в количка.", Toast.LENGTH_SHORT).show();
                cart.add(orderName);
                if (orderName.equals("Биг Мак")) {
                    mack++;
                } else if (orderName.equals("Филе-О-Фиш")) {
                    fish++;
                } else if (orderName.equals("Макчикън")) {
                    mcchicken++;
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //Intent functions
    public void openFaveActivity() {
        Intent i = new Intent(getApplicationContext(), Fave.class);
        if (fave.size() > 0) {
            i.putExtra("faveone", fave.get(0));
        }
        if (fave.size() > 1) {
            i.putExtra("favetwo", fave.get(1));
        }
        if (fave.size() > 2) {
            i.putExtra("favethree", fave.get(2));
        }
        startActivity(i);
    }

    public void openCartActivity() {
        Intent i = new Intent(getApplicationContext(), Cart.class);
        i.putExtra("mack",mack);
        i.putExtra("fish", fish);
        i.putExtra("mcchicken", mcchicken);
        startActivity(i);
    }

    public void openGoogleMaps() {
        Uri uri = Uri.parse("geo:0,0?q= Макдоналдс Макдрайв,Варна");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }


}