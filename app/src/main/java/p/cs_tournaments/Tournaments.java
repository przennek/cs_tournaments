package p.cs_tournaments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.Throwables;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import p.cs_tournaments.model.Match;
import p.cs_tournaments.model.Sparing;
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


        while(!matches.isDone()); // wait for response

        TextView winner = (TextView) findViewById(R.id.Winner);
        TextView final1 = (TextView) findViewById(R.id.Final1);
        TextView final2 = (TextView) findViewById(R.id.Final2);
        TextView comp1 = (TextView) findViewById(R.id.Comp1);
        TextView comp2 = (TextView) findViewById(R.id.Comp2);
        TextView comp3 = (TextView) findViewById(R.id.Comp3);
        TextView comp4 = (TextView) findViewById(R.id.Comp4);

        final List<Match> matchesList;
        try {
            matchesList = matches.get();

            String winnerName;
            List<Sparing> finalSparings = matchesList.get(0).getSparings();
            List<String> sparingWinners = new ArrayList<>(3);

            String win = null;
            for(Sparing s : finalSparings) {
                 if (win == null) {
                     win = s.getWinner();
                 } else {
                     win = win.equals(s.getWinner()) ? win : finalSparings.get(2).getWinner();
                     break;
                 }
            }

            winner.setText(win);

            final1.setText(matchesList.get(0).getTeam1());
            final2.setText(matchesList.get(0).getTeam2());

            comp1.setText(matchesList.get(1).getTeam1());
            comp2.setText(matchesList.get(1).getTeam2());
            comp3.setText(matchesList.get(2).getTeam1());
            comp4.setText(matchesList.get(2).getTeam2());

            comp1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicker(1, matchesList);
                }
            });

            comp2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicker(1, matchesList);
                }
            });

            comp3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicker(2, matchesList);
                }
            });

            comp4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicker(2, matchesList);
                }
            });

            final1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicker(0, matchesList);
                }
            });

            final2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicker(0, matchesList);
                }
            });

        } catch (Exception e) {
            Throwables.propagate(e);
        }
    }

    private void clicker(long id, List<Match> matchesList){
        Intent intent = new Intent(getApplicationContext(), MatchInfo.class);
        intent.putExtra("matchId", String.valueOf(id));
        intent.putExtra("matchList", (Serializable) matchesList);
        startActivity(intent);
    }
}
