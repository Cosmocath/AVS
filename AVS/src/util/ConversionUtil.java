package util;

import util.tools.Tools;

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
    public static Double convertDoubleCommaToDot(final String decimalAVirgule) {
        if (Tools.isEmpty(decimalAVirgule)) {
            return null;
        }
        return Double.valueOf(decimalAVirgule.replaceFirst(",", "."));
    }

}
