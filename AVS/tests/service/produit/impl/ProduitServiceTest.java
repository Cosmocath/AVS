package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import persistance.factory.HibernateFactory;
import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import util.enumeration.OrderBy;
import util.factory.Factory;

/**
 * @author Rodolphe
 *
 */
class ProduitServiceTest {
    public static SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    @BeforeEach
    public void initData() {
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
     * Test method for {@link service.produit.impl.ProduitService#findAllProduitOrderBy(util.OrderBy)}.
     */
    @Disabled
    void testFindAllProduitOrderBy() {
        // TODO fail("Not yet implemented");
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#create(presentation.produit.beanDto.ProduitDto)}.
     */
    @Test
    void testCreate() {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        assertNotNull(iProduitService);
        // référence déjà présente en base
        final ProduitDto produitDtoNew = new ProduitDto();
        produitDtoNew.setDesignation("designationProduit123456");
        produitDtoNew.setDescription("description produit 123456");
        produitDtoNew.setImage("chemin image 123456");
        produitDtoNew.setPrix("11.6");
        produitDtoNew.setReference("DE6789");
        produitDtoNew.setActif(true);
        produitDtoNew.setNoVersion(1);
        assertNull(iProduitService.create(produitDtoNew));
        assertEquals(3, iProduitService.findAllProduitOrderBy(OrderBy.ASC).size());

        // cas passant
        final ProduitDto produitDtoNew2 = new ProduitDto();
        produitDtoNew2.setDesignation("designationProduit123456");
        produitDtoNew2.setDescription("description produit 123456");
        produitDtoNew2.setImage("chemin image 123456");
        produitDtoNew2.setPrix("11.6");
        produitDtoNew2.setReference("3001");
        produitDtoNew2.setActif(true);
        produitDtoNew2.setNoVersion(1);
        final ProduitDto produitDtoInserted = iProduitService.create(produitDtoNew2);
        assertNotNull(produitDtoInserted);
        assertEquals(4, iProduitService.findAllProduitOrderBy(OrderBy.ASC).size());
        assertNotNull(produitDtoInserted.getId());
        assertEquals("designationProduit123456", produitDtoInserted.getDesignation());
    }

}
