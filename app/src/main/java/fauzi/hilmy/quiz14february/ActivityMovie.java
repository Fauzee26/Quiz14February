package fauzi.hilmy.quiz14february;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityMovie extends AppCompatActivity {

    RecyclerView view;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        view = findViewById(R.id.recycler);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        view.setAdapter(adapter);
    }
    String [] nama = {"Thor Ragnarok", "Pirates of Caribean", "Guardians of the Galaxy Vol 2", "The Book of Henry", "A Aku Benci Cinta", "Ghost in the shell", "Hacksaw Ridge", "King Arthur", "My Pet Dinosaurus",
    "Alien Covenant", "Harry Potter", "The Game Changer", "Dear Nathan", "iRobot"};

    int [] gambar = {R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone,
            R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone, R.drawable.smartphone};


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter, null);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.judul.setText(nama[position]);
            holder.img.setImageResource(gambar[position]);

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
}
