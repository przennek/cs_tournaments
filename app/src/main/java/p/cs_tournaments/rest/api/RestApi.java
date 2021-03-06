package p.cs_tournaments.rest.api;

import p.cs_tournaments.model.ListOfMatches;
import p.cs_tournaments.model.ListOfTournaments;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface RestApi {
    @GET("/listall")
    Call<ListOfTournaments> listAllTournaments();

    @GET("/tournament/{id}/matches")
    Call<ListOfMatches> getMatch(@Path("id") long id);
}
