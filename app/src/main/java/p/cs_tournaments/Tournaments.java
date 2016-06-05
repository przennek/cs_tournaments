package p.cs_tournaments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import p.cs_tournaments.model.Match;
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


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<Match>> matches = executor.submit(new Callable<List<Match>>() {
            @Override
            public List<Match> call() throws IOException {
                return call.getMatchCall(getApplicationContext(), 1L);
            }
        });


        while(!matches.isDone()) {
            // wait for response
        }

        try {
            Toast.makeText(this, matches.get().toString(), Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
