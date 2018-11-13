package eetac.dsa.minimo1;

public class Comandes {
    String nameProduct;
    int quantitat;

    public Comandes(String nameProduct, int quantitat){
        this.nameProduct = nameProduct;
        this.quantitat = quantitat;
    }

    public Comandes(){

    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
}
