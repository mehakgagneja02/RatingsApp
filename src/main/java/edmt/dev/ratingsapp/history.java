package edmt.dev.ratingsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class history extends AppCompatActivity {
ListView listviewartists;
    DatabaseReference dref;
    List<Artist> artistList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historyfull);

        listviewartists=findViewById(R.id.listviewartists);
        artistList=new ArrayList<>();

    }
    @Override
    protected void onStart(){
        super.onStart();
        dref= FirebaseDatabase.getInstance().getReference("artists");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot a : dataSnapshot.getChildren()){
                Artist artist= a.getValue(Artist.class);
                artistList.add(artist);
                }
                ArtistList adapter = new ArtistList(history.this,artistList);
                listviewartists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
