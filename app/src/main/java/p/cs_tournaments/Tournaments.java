package p.cs_tournaments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import p.cs_tournaments.model.Tournament;

public class Tournaments extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournaments);

        intent = getIntent();
        Toast.makeText(this, intent.getExtras().get("id").toString(),Toast.LENGTH_LONG).show();
    }
}
