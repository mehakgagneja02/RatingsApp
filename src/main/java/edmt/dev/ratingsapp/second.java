package edmt.dev.ratingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class second extends AppCompatActivity{
    Button reset, history;
    NumberPicker np;
    TextView textView;
   DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        np = findViewById(R.id.numberPicker);
        SharedPreferences sharedPreferences = getSharedPreferences("PA", 0);
        String maxx = sharedPreferences.getString("Max", "4");
        Integer maxxx = Integer.parseInt(maxx);
        SharedPreferences sharedPreferences1 = getSharedPreferences("PI", 0);
        String minn = sharedPreferences1.getString("Min", "1");
        final Integer minnn = Integer.parseInt(minn);
        np.setMinValue(minnn);
        np.setMaxValue(maxxx);
        np.setOnValueChangedListener(onValueChangeListener);
        textView = (TextView) findViewById(R.id.textView);

        //Log.d("maxx",maxx);
        reset = findViewById(R.id.reset);
        history = findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(second.this, history.class);
                startActivity(i);
            }
        });
        dref= FirebaseDatabase.getInstance().getReference("artists");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
                textView.setText("Select Again");
                np.setValue(minnn);
            }
        });

    }
    NumberPicker.OnValueChangeListener onValueChangeListener =
            new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    textView.setText("Selected Value: " + i1);
                }
            };
    private void addArtist(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String current_time = simpleDateFormat.format(calendar.getTime());
        String text = textView.getText().toString();
        String id = dref.push().getKey();
        Artist artist=new Artist(id,text,current_time);
        dref.child(text).setValue(artist);
        dref.child(current_time).setValue(artist);
   }
}
