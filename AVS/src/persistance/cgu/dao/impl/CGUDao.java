package persistance.cgu.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import persistance.cgu.dao.ICGUDao;

/**
 * implémentation de ICGUDao
 * 
 * @author Administrateur
 *
 */
public class CGUDao implements ICGUDao {

    private CGUDao() {
        // empty constructor
    }

    /**
     * url du fichier texte des CGU en constante
     */
    public static final String PATH_CGU = "C:\\CGU\\textCGU.html";

    @Override
    public String lireCGUDao() {
        try (final Scanner scanner = new Scanner(new File(PATH_CGU));) {
            String textCGU = "";
            while (scanner.hasNextLine()) {
                textCGU += scanner.nextLine() + "\n";
            }

            return textCGU;
        } catch (final FileNotFoundException e) {
            //System.err.println("Fichier non trouvé");
            e.printStackTrace();
        }
        return null;
    }

}
