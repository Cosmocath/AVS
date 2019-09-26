package persistance.commande.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        // TODO changer dml erreur dans commandeProduit 2 fois le meme id
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        final CommandeDo commandeDo = iCommandeDao.findById(7);
        Assert.assertNotNull(commandeDo);
        Assert.assertEquals(2, commandeDo.getCommandeProduitSet().size());

        // test pour recuperer des commandeProduits et verifier la quantite
        Set<CommandeProduitDo> setComm = commandeDo.getCommandeProduitSet();
        Map<CommandeProduitDo, Integer> mapComm = new HashMap<>();
        
        for(CommandeProduitDo comm : setComm) {
            mapComm.put(comm, comm.getQuantite());
        }               
        Assert.assertEquals(2, mapComm.size());

    }
}
