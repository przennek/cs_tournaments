package p.cs_tournaments.services;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import p.cs_tournaments.model.ListOfMatches;
import p.cs_tournaments.model.ListOfTournaments;
import p.cs_tournaments.model.Match;
import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.rest.api.RestApi;
import p.cs_tournaments.rest.api.RestApiEndpoint;
import retrofit.Call;

public class CallRestApi {

    public CallRestApi() {}

    public List<Tournament> listAllCall(Context context) throws IOException {
        RestApi api = RestApiEndpoint.getApiInstance(context);
        Call<ListOfTournaments> listOfTournamentsCall = api.listAllTournaments();
        return listOfTournamentsCall.execute().body().getTournamentsList();
    }

    public List<Match> getMatchCall(Context context, long id) throws IOException {
        RestApi api = RestApiEndpoint.getApiInstance(context);
        Call<ListOfMatches> listOfMatchesCall = api.getMatch(id);
        return listOfMatchesCall.execute().body().getMatchList();
    }
}
