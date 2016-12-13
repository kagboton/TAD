package attente;

/**
 * Created by o2156238 on 07/12/16.
 */
public class Creer implements Attente {


    public Creer(){
    }

    @Override
    public Attente supprimer(Tache t) {
        return null;
    }

    @Override
    public Attente modifier(Tache t, Priorite p) {
        return null;
    }

    @Override
    public Attente suivantes() {
        return null;
    }

    @Override
    public boolean vide() {
        return true;
    }

    @Override
    public boolean enAttente(Tache t) {
        return false;
    }

    @Override
    public Priorite priorite(Tache t) {
        return null;
    }

    @Override
    public Tache premiere() {
        return null;
    }

    @Override
    public Integer delai(Tache t) {
        return 0;
    }

    @Override
    public boolean equals(Attente a) {
        return vide() == a.vide();
    }
    public String toString(){
        return "";
    }
}
