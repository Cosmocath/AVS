package persistance.commande.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
import persistance.produitVendu.beanDo.ProduitVenduDo;
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
     * Test methof for {@link persistance.commande.dao.impl.CommandeDao#findById(java.lang.Integer)}.
     */
    @Test
    void testFindById() {
        
        // TODO voir en base de donnee la commande est faite reste commande produit et produitvendu
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        final CommandeDo commandeDo = iCommandeDao.findById(1);
        Assert.assertNotNull(commandeDo);
        Assert.assertEquals(2, commandeDo.getCommandeProduitSet().size());
        
        // test pour recuperer des commandeProduits et verifier la quantite
        Set<CommandeProduitDo> setComm = commandeDo.getCommandeProduitSet();
        List<CommandeProduitDo> list = new ArrayList<CommandeProduitDo>(setComm);
        final CommandeProduitDo commandeProduitDo = list.get(0);
        Assert.assertEquals(Integer.valueOf(2), commandeProduitDo.getQuantite());
        
        final CommandeProduitDo commandeProduitDo1 = list.get(1);
        Assert.assertEquals(Integer.valueOf(5), commandeProduitDo1.getQuantite());
        
     // test pour recuperer un produitVendu et verifier la reference
        final ProduitVenduDo produitVenduDo = commandeProduitDo.getProduitVenduDo();
        Assert.assertEquals("AB3456", produitVenduDo.getReference());

    }
}
