package eetac.dsa.minimo1;

public class Product {
    public String nameP;
    public double price;
    public int ventas;

    public Product(String nameP, double price, int ventas){
        this.nameP = nameP;
        this.price = price;
        this.ventas = ventas;
    }

    public Product(){

    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public void updateVentas(int quantiat){
        ventas = ventas + quantiat;
    }
}
