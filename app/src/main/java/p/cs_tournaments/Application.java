package p.cs_tournaments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.List;

import p.cs_tournaments.model.Tournament;

public class Application extends AppCompatActivity {

    private ArrayAdapter<Tournament> mUsersAdapter;
    private List<Tournament> mPotentialFriendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
    }

}
