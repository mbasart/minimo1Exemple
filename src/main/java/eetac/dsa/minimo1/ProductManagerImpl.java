package eetac.dsa.minimo1;

import java.util.*;
import org.apache.log4j.Logger;

public class ProductManagerImpl implements ProductManager{
    //definim el que ens faci falta
    private List<Product> productList;
    private Queue<Comandes[]> cuaComandes;
    private Map<String, Usuari> userMap;

    //mostra informacio amb log4j
    final Logger log = Logger.getLogger(ProductManagerImpl.class);

    private static ProductManagerImpl instance;//atributos

    public ProductManagerImpl(){ //constructor inicialitza

        this.productList = new LinkedList<Product>(); //inicialitzem llista productes
        this.cuaComandes = new LinkedList<>(); //inicialitzem cua comandes
        this.userMap = new HashMap<String, Usuari>();
    }

    public static ProductManagerImpl getInstance(){
        if (instance==null)
            instance=new ProductManagerImpl();
        return instance;
    }

    //Per afegir coses
    public void addProduct(String nameP, double price, int ventas){
        Product p = new Product(nameP,price,ventas);
        productList.add(p);
    }

    public void addUsuari (String nameU){
        Usuari user = new Usuari(nameU);
        userMap.put(user.getNameU(), user);
    }
    //fi zona afegir coses

    //ho farem servir pel test
    public void clear(){
        instance = new ProductManagerImpl();
    }

    //busca un producte a la llista de productes
    private Product getProducte(String nameProduct){
        int i =0;
        boolean enct =  false;
        while(!enct && i < productList.size()){
            if(productList.get(i).getNameP().equals(nameProduct)){
                enct = true;
            } else
                i++;
        }
        if(enct)
            return productList.get(i);
        else
            return null;
    }

    //retorna una llista de productes ordenades per preu ascendentment
    public List<Product> findAllProductsOrderedByPrice(){
        log.info("Productes ordenats ascendentment per preu: ");
        List<Product> productOrderedByPrice = new LinkedList<Product>();
        for (Product product:productList){
            productOrderedByPrice.add(product);
        }
        Collections.sort(productOrderedByPrice, (o1, o2) -> (int)(o1.getPrice()-o2.getPrice()));
        return productOrderedByPrice;
    }

    //retorna una llista de productes ordenada per numero de ventes descendentment
    public List<Product> findAllProductsOrderedBySales(){
        log.info("Productes ordenats ascendentment per vendes: ");
        List<Product> productOrderedBySales = new LinkedList<Product>();
        for (Product product:productList){
            productOrderedBySales.add(product);
        }
        Collections.sort(productOrderedBySales, (o1, o2) -> o2.getVentas()-o1.getVentas());
        return productOrderedBySales;
    }

    //un usuari realitza un pedido
    public int realizarPedido (String userName, Comandes[] comandes){
        log.info("Realitzar comanda per part del usuari " + userName);
        Usuari user = this.userMap.get(userName);
        if (user == null){
            log.warn("Error! Aquest usuari no existeix a la llista");
            return -1;
        }else {
            cuaComandes.add(comandes);
            userMap.get(userName).addComanda(comandes); //afegeix la comanda de l'usuari
            log.info("Comanda realitzada amb exit");
            return 0;
        }
    }

    //retorna la llista de pedidos que ha realitzat un usuari
    public List<Comandes> pedidosYaRealizados (String nameU){
        log.info("Comandes realitzades per l'usuari " +nameU);
        Usuari user = this.userMap.get(nameU);
        if(user == null){
            log.warn("Error! Aquest usuari no existeix a la llista");
            return null;
        } else {
            List<Comandes> pedidosRealizados = userMap.get(user).getLlistaComandes();
            log.info("Llista comanda:" + pedidosRealizados.toString());
            return pedidosRealizados;
        }
    }

    public int servirPedido(){
        log.info("Servim les comandes");
        int pedi = 1;
        Comandes[] comandes = cuaComandes.remove();
        if(comandes != null){
            for (Comandes c: comandes) {
                String nameProducte =c.getNameProduct();
                Product p =this.getProducte(nameProducte);
                if(p == null){
                    log.warn("Error! Aquest producte no existeix");
                    return -1;
                } else{
                    p.updateVentas(c.getQuantitat());
                    return pedi; //si les vendes s'han actualitzat correctament torna un 1
                }
            }
            //user.addComanda()
        }
        return 2; //si tot finalitza correctament torna un 2
    }


}
