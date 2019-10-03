package persistance.commande.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistance.commande.beanDo.CommandeDo;
import persistance.commande.beanDo.CommandeProduitDo;
import persistance.commande.dao.ICommandeDao;

import persistance.factory.HibernateFactory;
import persistance.produitVendu.dao.IProduitVenduDao;
import util.factory.Factory;

/**
 * @author Administrateur
 *
 */
class CommandeDaoTest {

    /**
     * 
     */
    @BeforeEach
    public void initData() {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            try (final Scanner scanner = new Scanner(new FileReader("tests/dataSet/avs_DML.sql"))) {
                while (scanner.hasNext()) {
                    final String sql = scanner.nextLine();
                    if (!sql.isEmpty()) {

                        final NativeQuery<?> query = session.createNativeQuery(sql);
                        query.executeUpdate();
                    }
                }
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            transaction.commit();
        }
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#findAllCommandeDo(int)}.
     */
    @Test
    void testFindAllCommandeDo() {
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        final List<CommandeDo> listeCommandeDo = iCommandeDao.findAllCommandeDo(8);
        Assert.assertNotNull(listeCommandeDo);
        Assert.assertEquals(1, listeCommandeDo.size());
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#createCommandeDo(CommandeDo commandeDo)}.
     */
    @Test
    void testCreateCommandeDo() {
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        final IProduitVenduDao iProduitVenduDao = Factory.getInstance(IProduitVenduDao.class);

        final CommandeDo commandeDo = new CommandeDo();
        commandeDo.setAdresseFacturation("15 av la republique");
        commandeDo.setNom("cmde_01");
        commandeDo.setAdresseLivraison("15 av la republique");
        commandeDo.setNumeroCommande("cmd_154");
        commandeDo.setDateCommande(new Date());
        commandeDo.setIdUtilisateur(8);
        commandeDo.setMontantSansRemise(120);

        final CommandeProduitDo commandeProduit = new CommandeProduitDo();
        commandeProduit.setProduitVenduDo(iProduitVenduDao.findProduitVenduByIdProduitHistoriseAndVersion(14, 3));
        commandeProduit.setQuantite(5);
        commandeProduit.setCommandeDo(commandeDo);

        commandeDo.getCommandeProduitSet().add(commandeProduit);
        final CommandeDo commande = iCommandeDao.createCommandeDo(commandeDo);

        Assert.assertNotNull(commande);
        Assert.assertEquals("cmd_154", commande.getNumeroCommande());
    }

}
