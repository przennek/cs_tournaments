package p.cs_tournaments.services;

import android.content.Context;

import java.util.List;

import p.cs_tournaments.model.ListOfTournaments;
import p.cs_tournaments.model.Tournament;
import p.cs_tournaments.rest.api.restApi;
import p.cs_tournaments.rest.api.restApiEndpoint;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CallRestApi {
    private ListOfTournaments tournaments;
    public CallRestApi(){

    }

    public void listAllCall(Context context){
        restApi api = restApiEndpoint.getApiInstance(context);
        Call<ListOfTournaments> listOfTournamentsCall = api.listAllTournaments();
        listOfTournamentsCall.enqueue(new Callback<ListOfTournaments>() {
            @Override
            public void onResponse(Response<ListOfTournaments> response, Retrofit retrofit) {
                if(response.isSuccess()){
                    tournaments = response.body();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                //TODO read from local db
            }
        });
    }
}
