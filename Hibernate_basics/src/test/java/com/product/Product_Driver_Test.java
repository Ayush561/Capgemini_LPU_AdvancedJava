package com.product;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;

import org.junit.jupiter.api.*;

import com.practice.hibernate.Product_Assignment;
import com.practice.hibernate.Product_Assignment_Driver;

public class Product_Driver_Test {

    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction et;

    @BeforeAll
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Test
    public void testInsertProduct() {
        Product_Assignment p = new Product_Assignment();
        p.setId(5);
        p.setName("Card Board");
        p.setQuantity(17);
        p.setPrice(220);

        Product_Assignment_Driver.insertData(em, et, p);

        Product_Assignment fetched = em.find(Product_Assignment.class, 5); 
        assertNotNull(fetched);
    }
    
    
    
    @Test
    public void insertProductTestNull() {
    	Product_Assignment_Driver pd = new Product_Assignment_Driver();
    	
    	String actualRes = pd.insertData(em, et, null);
    	assertEquals("Data doesn't inserted",actualRes);
    }

    
    public void testUpdateProduct() {
        Product_Assignment p = new Product_Assignment();
        p.setId(4);
        p.setName("Book");
        p.setQuantity(5);
        p.setPrice(100);

        Product_Assignment_Driver.insertData(em, et, p);

        Product_Assignment_Driver.updateData(em, et, 4, 50);

        Product_Assignment updated = em.find(Product_Assignment.class, 4);
        assertEquals(50, updated.getQuantity());
    }

    
    public void testDeleteProduct() {
        Product_Assignment p = new Product_Assignment();
        p.setId(5);
        p.setName("Bag");
        p.setQuantity(2);
        p.setPrice(500);

        Product_Assignment_Driver.insertData(em, et, p);

        Product_Assignment_Driver.deleteData(em, et, 5);

        Product_Assignment deleted = em.find(Product_Assignment.class, 5);
        assertNull(deleted);
    }
}
