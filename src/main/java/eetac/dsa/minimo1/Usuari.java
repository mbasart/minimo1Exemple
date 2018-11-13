package eetac.dsa.minimo1;

import java.util.LinkedList;
import java.util.List;

public class Usuari {
    public String nameU;
    private List<Comandes> llistaComandes;

    public Usuari (String nameU){
        this.nameU = nameU;
        this.llistaComandes = new LinkedList<Comandes>();
    }

    public Usuari(){

    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public void addComanda(Comandes[] comandes){
        for(int i =0; i<= comandes.length; i++)
            this.llistaComandes.add(comandes[i]);
    }

    public List<Comandes> getLlistaComandes() {
        return llistaComandes;
    }

    public void setLlistaComandes(List<Comandes> llistaComandes) {
        this.llistaComandes = llistaComandes;
    }
}
