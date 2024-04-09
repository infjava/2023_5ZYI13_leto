/**
 * @param <T> zviera
 */
public abstract class Zviera<T extends Zviera<T>> {
    public abstract void zozer(Jedlo<T> jedlo);
}
