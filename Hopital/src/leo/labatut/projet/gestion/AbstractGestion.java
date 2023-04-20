package leo.labatut.projet.gestion;

import java.util.ArrayList;

public abstract class AbstractGestion<T> {
    private ArrayList<T> liste;
    public AbstractGestion(){
        this.liste=new ArrayList<>();
    }
    public void ajoutez(T obj){
        this.liste.add(obj);
    }
    public ArrayList<T>getListe(){
        return this.liste;
    }
}
