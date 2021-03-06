package p.cs_tournaments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.services.CallRestApi;

public class Application extends AppCompatActivity {
    private final CallRestApi call = new CallRestApi();
    private ArrayAdapter<Tournament> tAdapter;
    private volatile Future <List<Tournament>> tournaments;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tournament tournament = tAdapter.getItem(position);
                Intent intent = new Intent(Application.this, Tournaments.class);
                intent.putExtra("id", tournament.getId());
                startActivity(intent);
            }
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        tournaments = executor.submit(new Callable<List<Tournament>>() {
            @Override
            public List<Tournament> call() throws IOException {
                return call.listAllCall(getApplicationContext());
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if(progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
        while(!tournaments.isDone());

        try {
            tAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tournaments.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        listView.setAdapter(tAdapter);

        if(progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}