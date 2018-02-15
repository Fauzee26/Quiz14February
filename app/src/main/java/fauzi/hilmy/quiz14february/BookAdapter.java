package fauzi.hilmy.quiz14february;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] menuItem;
    private final Integer[] menuGambar;

    public BookAdapter(Activity context, String[] menuItem, Integer[] menuGambar) {
        super(context, R.layout.list_item, menuItem);

        this.context = context;
        this.menuItem = menuItem;
        this.menuGambar = menuGambar;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView textMenu = (TextView)rowView.findViewById(R.id.menuItem);
        ImageView imgMenu = (ImageView)rowView.findViewById(R.id.imageView);

        textMenu.setText(menuItem[position]);
        imgMenu.setImageResource(menuGambar[position]);

        return rowView;
    }
}
