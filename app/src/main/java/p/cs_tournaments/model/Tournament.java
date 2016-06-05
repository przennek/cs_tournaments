package p.cs_tournaments.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class Tournament {
    private final long id;
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
