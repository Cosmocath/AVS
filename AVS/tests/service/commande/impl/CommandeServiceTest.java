package service.commande.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistance.factory.HibernateFactory;
import presentation.commande.beanDto.CommandeDto;
import service.commande.ICommandeService;
import util.factory.Factory;

class CommandeServiceTest {
    public static SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    @BeforeEach
    void setUp() throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            try (final Scanner scanner = new Scanner(new FileReader("tests/dataSet/avs_DML.sql"))) {
                while (scanner.hasNext()) {
                    final String sql = scanner.nextLine();
                    if (!sql.isEmpty()) {
                        final NativeQuery<?> query = session.createNativeQuery(sql);
                        query.executeUpdate();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            transaction.commit();
        }
    }


    /**
     * Test method for {@link service.commande.impl.CommandeService#findById(java.lang.Integer)}.
     * 
     */
    @Test
    void testFindById() {
        final ICommandeService iCommandeService = Factory.getInstance(ICommandeService.class);
        final CommandeDto commandeDto = iCommandeService.findById(7);
        Assert.assertNotNull(commandeDto);
        Assert.assertEquals(2, commandeDto.getMapProduitVenduDto().size());
        
    }

}
