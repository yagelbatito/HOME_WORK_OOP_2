
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

/**
 * The `IAnimal` interface represents an animal with the capability to eat and move.
 * It extends the `IMoveable` interface to include movement functionality.
 */
public interface IAnimal extends IMoveable {
    /**
     * Allows the animal to consume energy.
     * The method updates the animal's energy based on the amount provided.
     *
     * @param energy The amount of energy to be consumed by the animal.
     * @return `true` if the animal successfully consumes the energy, `false` otherwise.
     */
    public boolean eat(int energy);
}
