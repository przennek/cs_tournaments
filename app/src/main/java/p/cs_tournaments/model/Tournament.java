package p.cs_tournaments.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class Tournament {
    private final long id;
    private final String name;
    private final DateTime dateTime;
}
