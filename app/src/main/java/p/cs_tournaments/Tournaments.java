package p.cs_tournaments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Tournaments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournaments);

        //Toast.makeText(this, savedInstanceState.get("tournament").toString(),Toast.LENGTH_LONG).show();
    }
}
