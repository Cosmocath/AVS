package util.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory permettant de retourner une instance de classe, et gérant le pattern Singleton
 * 
 * @author Xavier
 *
 */
public class Factory {

    /**
     * Permet de stocker les implémentations
     */
    private static Map<String, Object> map = new HashMap<>();

    /**
     * Permet de retourner une instance de l'implémentation d'une interface <br/>
     * Cette implémentation doit implémenter : <br/>
     * <ul>
     * <li>l'interface en question</li>
     * <li>un constructeur en private</li>
     * </ul>
     * 
     * @param clazzInterface interface dont on veut une implémentation
     * @return l'implémentation choisie de l'interface
     */
    public static <T> T getInstance(final Class<T> clazzInterface) {

        // on vérifie si le paramètre est une interface
        if (!clazzInterface.isInterface()) {
            throw new IllegalArgumentException("Ceci : " + clazzInterface.getSimpleName() + " n'est pas une interface !");
        }

        // on récupère le nom de l'interface
        final String interfaceName = clazzInterface.getSimpleName();

        // on en déduit le nom de la classe d'implémentation
        final String className = clazzInterface.getPackage().getName() + ".impl." + interfaceName.substring(1);

        // on regarde si on a déjà l'instance
        Object implementation = map.get(className);
        if (implementation != null) {
            return clazzInterface.cast(implementation);
        }

        // on essaie de charger cette classe pour vérifier son existance
        Class<?> clazzToInstantiate = null;
        try {
            clazzToInstantiate = Class.forName(className);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Aucune implémentation trouvée pour cette interface : " + interfaceName);
        }

        // on va instantier l'implémentation 
        implementation = instantiate(clazzInterface, clazzToInstantiate);

        // on stocke l'implémentation
        map.put(className, implementation);

        // on retourne le résultat
        return clazzInterface.cast(implementation);
    }

    /**
     * Permet d'instancier l'implémentation
     * 
     * @param <T>
     * @param clazzInterface l'interface
     * @param clazzToInstantiate la classe à instancier
     * @return une instance de la classe implémentant l'interface
     */
    private static <T> Object instantiate(final Class<T> clazzInterface, final Class<?> clazzToInstantiate) {
        try {
            // on récupère le constructeur
            final Constructor<?> constructor = clazzToInstantiate.getDeclaredConstructor();
            // on vérifie qu'il est private
            if ((constructor.getModifiers() & Modifier.PRIVATE) == 0) {
                throw new RuntimeException("Le constructeur par défaut n'est pas privé : " + clazzToInstantiate.getSimpleName());
            }
            // tout ça s'est le pouvoir de la réflexivité...
            constructor.setAccessible(true);
            // on créé une instance
            final Object implementation = constructor.newInstance();
            // on remet comme avant...
            constructor.setAccessible(false);
            // on vérifie que l'instance implémente bien l'interface
            if (!clazzInterface.isAssignableFrom(clazzToInstantiate)) {
                throw new RuntimeException("La classe : " + clazzToInstantiate.getSimpleName() + " n'implémente pas l'interface : " + clazzInterface.getSimpleName());
            }
            return implementation;
        } catch (final IllegalArgumentException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème de constructeur de l'implémentation : " + clazzToInstantiate.getSimpleName());
        } catch (final SecurityException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème de sécurité");
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("La classe d'implémentation " + clazzToInstantiate.getSimpleName() + " ne possède pas de constructeur par défaut");
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Accès aux invocations interdit !");
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème d'invocation!");
        }
    }

}
