package p.cs_tournaments.services;

import android.content.Context;
import android.view.ViewDebug;

import com.google.common.base.Throwables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import p.cs_tournaments.Application;
import p.cs_tournaments.model.ListOfMatches;
import p.cs_tournaments.model.ListOfTournaments;
import p.cs_tournaments.model.Match;
import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.rest.api.RestApi;
import p.cs_tournaments.rest.api.RestApiEndpoint;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CallRestApi {
    @Getter
    volatile private List<Tournament> tournaments = new ArrayList<>();

    @Getter
    private List<Match> matches = new ArrayList<>();

    public CallRestApi(){

    }

    public List<Tournament> listAllCall(Context context) throws IOException {
        RestApi api = RestApiEndpoint.getApiInstance(context);
        Call<ListOfTournaments> listOfTournamentsCall = api.listAllTournaments();

        return listOfTournamentsCall.execute().body().getTournamentsList();
    }

    public void getMatchCall(Context context, long id){
        RestApi api = RestApiEndpoint.getApiInstance(context);
        Call<ListOfMatches> listOfMatchesCall = api.getMatch(id);

        listOfMatchesCall.enqueue(new Callback<ListOfMatches>() {
            @Override
            public void onResponse(Response<ListOfMatches> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    matches.addAll(response.body().getMatchList());
                } else {
                    throw new RuntimeException("Request failed!");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Throwables.propagate(t);
                //TODO read from local db
            }
        });
    }
}
