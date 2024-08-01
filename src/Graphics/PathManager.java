/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import animals.Animal;
import java.util.*;

/**
 * Manages the association between paths and the animals assigned to them.
 */
public class PathManager {
    // Map that associates a path with a list of animals assigned to that path
    private Map<String, List<Animal>> pathAnimalsMap = new HashMap<>();

    /**
     * Adds an animal to a specified path.
     * If the path does not exist, it will be created.
     *
     * @param path the path to which the animal is to be added
     * @param animal the animal to be added to the path
     */
    public void addAnimalToPath(String path, Animal animal) {
        // Compute or create a new list for the path, then add the animal
        pathAnimalsMap.computeIfAbsent(path, k -> new ArrayList<>()).add(animal);
    }

    /**
     * Retrieves the list of animals assigned to a specified path.
     * If the path does not exist, returns an empty list.
     *
     * @param path the path for which to retrieve the list of animals
     * @return a list of animals assigned to the specified path, or an empty list if no animals are assigned
     */
    public List<Animal> getAnimalsInPath(String path) {
        // Get the list of animals for the path, or return an empty list if the path does not exist
        return pathAnimalsMap.getOrDefault(path, Collections.emptyList());
    }
}
