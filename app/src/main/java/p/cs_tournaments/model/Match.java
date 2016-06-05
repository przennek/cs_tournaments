package p.cs_tournaments.model;

/**
 * Created by p on 05.06.16.
 */

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class Match {
    private final long id;
    private final long nextMatch;
    private final Long[] id_prev_match;
    private final String team1;
    private final String team2;
    private final List<Sparing> sparings;
}