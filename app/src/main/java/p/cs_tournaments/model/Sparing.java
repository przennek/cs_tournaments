package p.cs_tournaments.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by p on 05.06.16.
 */

@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class Sparing implements Serializable{
    private final String mapName;
    private final String winner;
}
