package service.droit.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import persistance.droit.beanDo.DroitDo;
import persistance.droit.beanDo.ProfilDroitDo;
import persistance.droit.dao.IDroitDao;
import service.droit.IDroitService;
import util.factory.Factory;

/**
 * DroitService qui implémente l'interface IDroitService
 * 
 * @author Guy-Jöel et Mireille
 *
 */
public class DroitService implements IDroitService {

    private static Map<String, List<String>> map             = null;
    private final IDroitDao                  iDroitAccesUrl  = Factory.getInstance(IDroitDao.class);
    private static final IDroitService       I_DROIT_SERVICE = Factory.getInstance(IDroitService.class);


    /**
     * Constructeur privé
     */
    private DroitService() {
        // Empty method
    }

    //initialisation map
    static {
        if (map == null) {
            map = I_DROIT_SERVICE.findAllDroitsWithProfil();
        }
    }

    /**
     * mappe setprofilDroits ----> liste(liste de profil)
     * 
     * @param setprofilDroits
     * @return liste
     */
    private List<String> mapToListProfilDroit(final Set<ProfilDroitDo> setprofilDroits) {
        final List<String> liste = new ArrayList<>();
        for (final ProfilDroitDo profilDroitDo : setprofilDroits) {
            liste.add(profilDroitDo.getProfilDo().getNom());
        }
        return liste;
    }

    /**
     * mappe List<DroitDo> -----> Map<String, List<String>>
     * 
     * @param listeDroits
     * @return map
     */
    private Map<String, List<String>> mapToListDroits(final List<DroitDo> listeDroits) {
        final Map<String, List<String>> map = new HashMap<>();
        for (final DroitDo droitDo : listeDroits) {
            if (map.get(droitDo.getUrl()) == null) {
                map.put(droitDo.getUrl(), mapToListProfilDroit(droitDo.getSetProfilDroits()));
            }

        }
        return map;
    }

    @Override
    public Map<String, List<String>> findAllDroitsWithProfil() {
        final Map<String, List<String>> map = mapToListDroits(iDroitAccesUrl.findAllDroits());
        return map;
    }

    @Override
    public boolean isAcces(final String url, final String profil) throws IllegalArgumentException {
        //on recupère la liste des profils
        final List<String> listeProfils = map.get(url);
        // si l'url est inconnue on lance une exception
        if (listeProfils == null) {
            throw new IllegalArgumentException("Lien inconnue");
        }
        //je contrôle l'accès
        for (final String nomProfil : listeProfils) {
            if (profil.equals(nomProfil)) {
                return true;
            }

        }

        return false;
    }

}
