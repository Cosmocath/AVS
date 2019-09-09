package util;

/**
 * Outils de conversion
 * 
 * @author Rodolphe
 *
 */
public class ConversionUtil {

    /**
     * Transforme la virgule d'un décimal en point (pour gestion des doubles)
     * (typiquement les champ "prix", "montant" des formulaires)
     * exemple : 1,25 => 1.25
     * 
     * @param decimalAVirgule (typiquement les champ "prix", "montant" des formulaires)
     * @return un double avec un point
     */
    public static double convertDoubleCommaToDot(final String decimalAVirgule) {
        return Double.valueOf(decimalAVirgule.replaceFirst(",", "."));
    }

}
