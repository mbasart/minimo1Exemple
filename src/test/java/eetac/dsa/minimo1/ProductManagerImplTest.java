package eetac.dsa.minimo1;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProductManagerImplTest {
    Product product;
    Usuari usuari;
    Comandes comandes;
    ProductManager productManager;

    //aixo es pel warning amb log4j
    final Logger log = Logger.getLogger(ProductManagerImpl.class);


    @org.junit.Before
    public void setUp(){
        this.productManager=ProductManagerImpl.getInstance();
        this.productManager.addUsuari("Josep");
        this.productManager.addUsuari("Victor");
        this.productManager.addProduct("galetes",5,2);
        this.productManager.addProduct("xuxos",3,1);
        this.productManager.addProduct("madalena",6,4);
    }

    @Test
    public void findAllProductsOrderedByPrice(){
        List<Product> productList1 = this.productManager.findAllProductsOrderedByPrice();
        assertEquals(productList1.get(0).price, 3,0);
        assertEquals(productList1.get(1).price,5,0);
        assertEquals(productList1.get(2).price,6,0);
    }

    @Test
    public void findAllProductsOrderedBySales(){
        List<Product> productList2 = this.productManager.findAllProductsOrderedBySales();
        assertEquals(productList2.get(0).ventas, 4);
        assertEquals(productList2.get(1).ventas,2);
        assertEquals(productList2.get(2).ventas,1);
    }

    @org.junit.After
    public void tearDown(){
        productManager.clear();
    }
}