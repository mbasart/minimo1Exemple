package eetac.dsa.minimo1;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("service")
public class RESTservice {

    private ProductManager productManager;

    public RESTservice(){
        this.productManager = ProductManagerImpl.getInstance();
        this.productManager.addUsuari("Josep");
        this.productManager.addUsuari("Victor");
        this.productManager.addProduct("galetes",5,2);
        this.productManager.addProduct("xuxos",3,1);
        this.productManager.addProduct("madalena",6,4);
    }



    @GET
    @Path("/orderPrice")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAllProductsOrderedByPrice(){
        return productManager.findAllProductsOrderedByPrice();
    }

    @GET
    @Path("/orderSales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAllProductsOrderedBySales(){
        return productManager.findAllProductsOrderedBySales();
    }

    @POST
    @Path("/pedido/{nomUsuari}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response realizarPedido(@PathParam("nomUsuari")String nomUsr,Comandes[] comandes){
        int value = productManager.realizarPedido(nomUsr,comandes);
        if(value == 0){
            return Response.status(200).build();
        } else
            return Response.status(204).entity("Error! Aquest producte no es a la llista").build();
    }

    @GET
    @Path("/servirPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public Response servirPedido(){
        int value2 = productManager.servirPedido();
        if(value2 == 0)
            return Response.status(204).entity("No hi ha comandes a la cua").build();
        else if(value2 == -1)
            return Response.status(204).entity("Error! Aquest producte no existeix").build();
        else
            return Response.status(200).entity("Les vendes s'han actualitzat correctament").build();
    }

    @GET
    @Path("/pedidosRealizados/{nomUsuari2}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comandes> pedidosYaRealizados(@PathParam("nomUsuari2")String nomUsr2){
        return productManager.pedidosYaRealizados(nomUsr2);
    }


}
