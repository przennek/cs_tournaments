package p.cs_tournaments.services;

import android.content.Context;
import android.view.ViewDebug;

import com.google.common.base.Throwables;

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
    private List<Tournament> tournaments = new ArrayList<>();

    @Getter
    private List<Match> matches = new ArrayList<>();

    public CallRestApi(){

    }

    public void listAllCall(Context context){
        RestApi api = RestApiEndpoint.getApiInstance(context);
        Call<ListOfTournaments> listOfTournamentsCall = api.listAllTournaments();

        listOfTournamentsCall.enqueue(new Callback<ListOfTournaments>() {
            @Override
            public void onResponse(Response<ListOfTournaments> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    tournaments.addAll(response.body().getTournamentsList());
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

    public void getMatchCall(Context context, Long id){
        RestApi api = RestApiEndpoint.getApiInstance(context);
//        Call<ListOfMatches> listOfMatchesCall = api.getMatch(id);
        Call<ListOfMatches> listOfMatchesCall = api.getMatch();

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
