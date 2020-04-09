package edmt.dev.ratingsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArtistList extends ArrayAdapter<Artist> {
    private Activity context;
    private List<Artist> artistlist;

    public ArtistList(Activity context,List<Artist> artistlist){
        super(context,R.layout.activity_history,artistlist);
        this.context=context;
        this.artistlist=artistlist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.activity_history,null);
        TextView t=listviewitem.findViewById(R.id.textView2);
        TextView t1=listviewitem.findViewById(R.id.t1);
        Artist artist=artistlist.get(position);
        t.setText(artist.getArtisttext());
        t1.setText(artist.getartistcurrent_time());
        return listviewitem;
    }
}
