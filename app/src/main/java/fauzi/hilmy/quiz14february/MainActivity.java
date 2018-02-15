package fauzi.hilmy.quiz14february;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView view;
    CustomAdapter adapter;
    BottomNavigationView viewaa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.viewer);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        view.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewaa = findViewById(R.id.navigation);
        viewaa.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        break;
                    case R.id.mMovie:
                        startActivity(new Intent(MainActivity.this, ActivityMovie.class));
                        break;
                    case R.id.mBook:
                        startActivity(new Intent(MainActivity.this, ActivityBook.class));
                        break;
                }
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    String [] nama = {"Thor Ragnarok", "Pirates of Caribean", "Guardians of the Galaxy Vol 2", "The Book of Henry", "A Aku Benci Cinta", "Ghost in the shell", "Hacksaw Ridge", "King Arthur", "My Pet Dinosaurus",
            "Alien Covenant", "Harry Potter", "The Game Changer", "Dear Nathan", "iRobot",
            "Web Design Questionnaire", "Java Notes For Professionals", "iOS Notes For Professionals", "PROGRAMMING_KOTLIN", "Modul mySQL", "Repository Object", "Android_Notes_For_Professionals"};
    int [] menuImage = {
            R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images,
            R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone,
            R.drawable.smartphone, R.drawable.smartphone, R.drawable.images, R.drawable.images,
            R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone
    };


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter, null);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.judul.setText(nama[position]);
            holder.img.setImageResource(menuImage[position]);

        }

        @Override
        public int getItemCount() {
            return nama.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView judul;
            ImageView img;
            public MyViewHolder(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_movie) {
            Intent yyt = new Intent(getApplicationContext(), ActivityMovie.class);
            startActivity(yyt);
        } else if (id == R.id.action_book) {
            Intent vcx = new Intent(getApplicationContext(), ActivityBook.class);
            startActivity(vcx);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent a1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(a1);
        } else if (id == R.id.nav_movie) {
            Intent ytrewq = new Intent(getApplicationContext(), ActivityMovie.class);
            startActivity(ytrewq);
        } else if (id == R.id.nav_book) {
            Intent qq = new Intent(getApplicationContext(), ActivityBook.class);
            startActivity(qq);
        } else if (id == R.id.nav_exit) {
            Context context = this;
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Warning!!");
            alertDialog.setMessage("Apakah anda yakin akan keluar dari aplikasi ini?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //kondisi ketika kita pencet yes
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = alertDialog.create();
            alert.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
