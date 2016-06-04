package p.cs_tournaments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import p.cs_tournaments.model.ListOfTournaments;
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        tAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                call.getTournaments());
        listView.setAdapter(tAdapter);
    }
}