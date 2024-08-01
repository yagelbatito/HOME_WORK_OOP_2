/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Olympics;

import java.util.Objects;

public class Medal {
    public enum MedalType {bronze, silver, gold}

    private int year;
    private String tournament;
    private MedalType type;

    /**
     * Constructs a Medal object with specified year, tournament, and medal type.
     *
     * @param year       The year the medal was won.
     * @param tournament The tournament where the medal was won.
     * @param medalType  The type of the medal (gold, silver, bronze).
     */
    public Medal(int year, String tournament, MedalType medalType) {
        this.year = year;
        this.tournament = tournament;
        this.type = medalType;
    }

    /**
     * Default constructor for creating a Medal object with default values.
     * Defaults to 2024, "Paris Olympics 2024", and bronze medal type.
     */
    public Medal() {
        this(2024, "Paris Olympics 2024", MedalType.bronze);
    }

    /**
     * Returns a string representation of the Medal object.
     *
     * @return A string representation of the Medal object.
     */
    @Override
    public String toString() {
        return year + " " + tournament + " " + type + "\n";
    }

    /**
     * Checks equality of this Medal object with another Medal object.
     *
     * @param medal The other Medal object to compare.
     * @return true if the medals are equal (have the same year, tournament, and type), false otherwise.
     */
    public boolean equals(Medal medal) {
        return this.year == medal.year && Objects.equals(this.tournament, medal.tournament) && this.type == medal.type;
    }
}
