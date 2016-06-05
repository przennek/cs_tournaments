package p.cs_tournaments;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import p.cs_tournaments.model.Match;
import p.cs_tournaments.model.Sparing;
import p.cs_tournaments.model.Tournament;

public class MatchInfo extends AppCompatActivity {

    private ArrayAdapter<String> tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_info);

        Intent intent = getIntent();
        long matchId = Long.parseLong(intent.getStringExtra("matchId"));
        List<Match> matchList = (List<Match>) intent.getSerializableExtra("matchList");

        //Toast.makeText(getApplicationContext(), matchList.get(0).getTeam1(), Toast.LENGTH_LONG).show();

        TextView textView = (TextView) findViewById(R.id.textView3);
        String teamz = String.format("Team 1: %s\t Team 2: %s", matchList.get((int)matchId).getTeam1(), matchList.get((int)matchId).getTeam2());
        textView.setText(teamz);

        ListView listView = (ListView) findViewById(R.id.listView2);

        List<String> teams = new ArrayList<>();
        String team1 = matchList.get((int)matchId).getTeam1();
        String team2 = matchList.get((int)matchId).getTeam2();

        for(int i = 0; i < 3; i++) {
            teams.add(
                    String.format("%s: %s",
                            matchList.get((int)matchId).getSparings().get(i).getMapName(),
                            matchList.get((int)matchId).getSparings().get(i).getWinner())
            );
        }

        String win = null;
        List<Sparing> sparings = matchList.get((int)matchId).getSparings();
        for(Sparing s : sparings) {
            if (win == null) {
                win = s.getWinner();
            } else {
                win = win.equals(s.getWinner()) ? win : sparings.get(2).getWinner();
                break;
            }
        }

        teams.add("Sparing winner: " + win);

        tAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teams);

        listView.setAdapter(tAdapter);
    }
}
