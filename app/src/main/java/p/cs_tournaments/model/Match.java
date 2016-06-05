package p.cs_tournaments.model;

/**
 * Created by p on 05.06.16.
 */

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class Match {
    @Getter
    private final long id;
    @Getter
    private final long nextMatch;
    @Getter
    private final Long[] id_prev_match;
    @Getter
    private final String team1;
    @Getter
    private final String team2;
    @Getter
    private final List<Sparing> sparings;
}