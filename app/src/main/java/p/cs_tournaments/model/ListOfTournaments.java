package p.cs_tournaments.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@AllArgsConstructor(suppressConstructorProperties = true)
public class ListOfTournaments {
    @Getter
    private final List<Tournament> tournamentsList;
}
