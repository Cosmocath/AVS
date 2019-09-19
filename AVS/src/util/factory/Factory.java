package util.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory permettant de retourner une instance de classe, et g�rant le pattern Singleton
 * 
 * @author Xavier
 *
 */
public class Factory {

    /**
     * Permet de stocker les impl�mentations
     */
    private static Map<String, Object> map = new HashMap<>();

    /**
     * Permet de retourner une instance de l'impl�mentation d'une interface <br/>
     * Cette impl�mentation doit impl�menter : <br/>
     * <ul>
     * <li>l'interface en question</li>
     * <li>un constructeur en private</li>
     * </ul>
     * 
     * @param clazzInterface interface dont on veut une impl�mentation
     * @return l'impl�mentation choisie de l'interface
     */
    public static <T> T getInstance(final Class<T> clazzInterface) {

        // on v�rifie si le param�tre est une interface
        if (!clazzInterface.isInterface()) {
            throw new IllegalArgumentException("Ceci : " + clazzInterface.getSimpleName() + " n'est pas une interface !");
        }

        // on r�cup�re le nom de l'interface
        final String interfaceName = clazzInterface.getSimpleName();

        // on en d�duit le nom de la classe d'impl�mentation
        final String className = clazzInterface.getPackage().getName() + ".impl." + interfaceName.substring(1);

        // on regarde si on a d�j� l'instance
        Object implementation = map.get(className);
        if (implementation != null) {
            return clazzInterface.cast(implementation);
        }

        // on essaie de charger cette classe pour v�rifier son existance
        Class<?> clazzToInstantiate = null;
        try {
            clazzToInstantiate = Class.forName(className);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Aucune impl�mentation trouv�e pour cette interface : " + interfaceName);
        }

        // on va instantier l'impl�mentation 
        implementation = instantiate(clazzInterface, clazzToInstantiate);

        // on stocke l'impl�mentation
        map.put(className, implementation);

        // on retourne le r�sultat
        return clazzInterface.cast(implementation);
    }

    /**
     * Permet d'instancier l'impl�mentation
     * 
     * @param <T>
     * @param clazzInterface l'interface
     * @param clazzToInstantiate la classe � instancier
     * @return une instance de la classe impl�mentant l'interface
     */
    private static <T> Object instantiate(final Class<T> clazzInterface, final Class<?> clazzToInstantiate) {
        try {
            // on r�cup�re le constructeur
            final Constructor<?> constructor = clazzToInstantiate.getDeclaredConstructor();
            // on v�rifie qu'il est private
            if ((constructor.getModifiers() & Modifier.PRIVATE) == 0) {
                throw new RuntimeException("Le constructeur par d�faut n'est pas priv� : " + clazzToInstantiate.getSimpleName());
            }
            // tout �a s'est le pouvoir de la r�flexivit�...
            constructor.setAccessible(true);
            // on cr�� une instance
            final Object implementation = constructor.newInstance();
            // on remet comme avant...
            constructor.setAccessible(false);
            // on v�rifie que l'instance impl�mente bien l'interface
            if (!clazzInterface.isAssignableFrom(clazzToInstantiate)) {
                throw new RuntimeException("La classe : " + clazzToInstantiate.getSimpleName() + " n'impl�mente pas l'interface : " + clazzInterface.getSimpleName());
            }
            return implementation;
        } catch (final IllegalArgumentException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("Probl�me de constructeur de l'impl�mentation : " + clazzToInstantiate.getSimpleName());
        } catch (final SecurityException e) {
            e.printStackTrace();
            throw new RuntimeException("Probl�me de s�curit�");
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("La classe d'impl�mentation " + clazzToInstantiate.getSimpleName() + " ne poss�de pas de constructeur par d�faut");
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Acc�s aux invocations interdit !");
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Probl�me d'invocation!");
        }
    }

}
