package p.cs_tournaments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.services.CallRestApi;

public class Tournaments extends AppCompatActivity {
    private final CallRestApi call = new CallRestApi();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournaments);
        intent = getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        call.getMatchCall(this, 1);
//        Toast.makeText(this, intent.getExtras().get("id").toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(this, call.getMatches().toString(),Toast.LENGTH_LONG).show();
    }
}
