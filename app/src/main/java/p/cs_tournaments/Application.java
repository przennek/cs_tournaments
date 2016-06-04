package p.cs_tournaments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.services.CallRestApi;

public class Application extends AppCompatActivity {

    private ArrayAdapter<Tournament> tAdapter;
    private List<Tournament> tournamentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        ListView listView = (ListView) findViewById(R.id.listView);
        tAdapter = new ArrayAdapter<>(this, R.layout.activity_application);

        CallRestApi call = new CallRestApi();
        call.listAllCall(getApplicationContext());
                
        tournamentList = call.getTournaments();
        tAdapter.addAll(tournamentList);

        listView.setAdapter(tAdapter);
    }

}
