package eetac.dsa.minimo1;

import java.util.List;

public interface ProductManager {
    List<Product> findAllProductsOrderedByPrice();
    List<Product> findAllProductsOrderedBySales();
    int realizarPedido(String user, Comandes[] comandes);
    int servirPedido();
    List<Comandes> pedidosYaRealizados (String nameU);
    void addUsuari(String name);
    void addProduct(String nameP, double price, int ventas);
    void clear();
}
