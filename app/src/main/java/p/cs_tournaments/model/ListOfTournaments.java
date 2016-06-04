package p.cs_tournaments.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(suppressConstructorProperties = true)
public class ListOfTournaments {
    private final List<Tournament> tournaments;
}
