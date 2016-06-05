package p.cs_tournaments.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 * Created by p on 05.06.16.
 */
@Value
@AllArgsConstructor(suppressConstructorProperties = true)
public class ListOfMatches {
    @Getter @Setter
    private List<Match> matchList;
}
