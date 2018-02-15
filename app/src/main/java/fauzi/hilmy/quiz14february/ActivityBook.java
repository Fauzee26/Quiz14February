package fauzi.hilmy.quiz14february;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityBook extends AppCompatActivity {
    String[] menuItem = {
            "Web Design Questionnaire", "Java Notes For Professionals", "iOS Notes For Professionals", "PROGRAMMING_KOTLIN", "Modul mySQL", "Repository Object", "Android_Notes_For_Professionals"
    };

    Integer[] menuImage = {
            R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        BookAdapter adapter = new BookAdapter(this, menuItem, menuImage);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Clicked " + menuItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
