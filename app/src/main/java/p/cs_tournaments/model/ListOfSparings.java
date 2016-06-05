package p.cs_tournaments.model;

import java.io.Serializable;
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
public class ListOfSparings implements Serializable{
    @Getter @Setter
    private List<Tournament> tournamentsList;
}
