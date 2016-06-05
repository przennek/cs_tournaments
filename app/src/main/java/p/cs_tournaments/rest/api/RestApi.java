package p.cs_tournaments.rest.api;

import p.cs_tournaments.model.ListOfMatches;
import p.cs_tournaments.model.ListOfTournaments;
import retrofit.Call;
import retrofit.http.GET;

public interface RestApi {
    @GET("/listall")
    Call<ListOfTournaments> listAllTournaments();

    @GET("/tournament/1/matches")
//    Call<ListOfMatches> getMatch(Long id);
    Call<ListOfMatches> getMatch();
}
