package edmt.dev.ratingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText min, max;
    Button set, btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        min = findViewById(R.id.min);
        max = findViewById(R.id.max);
        min.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9")});
        max.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9")});
        set = findViewById(R.id.set);
        btn = findViewById(R.id.btn);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = (min.getText().toString());
                String b = (max.getText().toString());
                btn.setText("Rating " + a + "-" + b);
                btn.setVisibility(View.VISIBLE);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,second.class);
                startActivity(i);
                String maxx = (max.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences("PA",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Max",maxx);
                editor.commit();

                String minn = (min.getText().toString());
                SharedPreferences sharedPreferences1 = getSharedPreferences("PI",0);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.putString("Min",minn);
                editor1.commit();
            }
        });
    }

}