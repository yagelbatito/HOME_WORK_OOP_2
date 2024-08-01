
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import java.lang.Cloneable;

/**
 * The `IClonable` interface extends the `Cloneable` interface to mark classes that
 * support cloning. This interface does not add any additional methods, but serves
 * as a marker to indicate that implementing classes are intended to be clonable.
 *
 * Note: The `Cloneable` interface is a marker interface in Java that allows for
 * the use of the `Object.clone()` method.
 */
public interface IClonable extends Cloneable {
    // No additional methods required
}
