package p.cs_tournaments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.services.CallRestApi;

public class Application extends AppCompatActivity {
    private final CallRestApi call = new CallRestApi();
    private ArrayAdapter<Tournament> tAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        listView = (ListView) findViewById(R.id.listView);
        call.listAllCall(getApplicationContext());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tournament tournament = tAdapter.getItem(position);
                Intent intent = new Intent(Application.this, Tournaments.class);
                intent.putExtra("id", tournament.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        tAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                call.getTournaments());
        listView.setAdapter(tAdapter);
    }
}