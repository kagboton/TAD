package attente;

/**
 * Created by o2156238 on 07/12/16.
 */
public class Enregistrer implements Attente {

    Tache tache;
    Priorite priorite;
    Attente attente;

    public Enregistrer(Attente a, Tache t, Priorite p){
        this.attente = a;
        this.priorite = p;
        this.tache = t;
    }


    public Attente supprimer(Tache t) {
        assert enAttente(t);
        if (tache.equals(t))
            return attente;
        else
            return new Enregistrer(attente.supprimer(t), tache, priorite);
    }

    public Attente modifier(Tache t, Priorite p) {
        assert enAttente(t);
        return new Enregistrer(this.supprimer(t), t, p);
    }

    public Attente suivantes() {
        assert !vide();
        return supprimer(this.premiere());
    }

    public boolean vide() {
        return false;
    }

    public boolean enAttente(Tache t) {
       if (this.tache.equals(t))
           return true;
        else return attente.enAttente(t);
    }

    public Priorite priorite(Tache t) {
        assert enAttente(t);
        if (tache.equals(t))
            return priorite;
        else return attente.priorite(t);
    }

    public Tache premiere() {
        assert  !vide();
        if (attente.vide())
            return  tache;
        else if ((priorite.compareTo(attente.priorite(attente.premiere()))) == 1)
            return tache                  ;
        else return attente.premiere();
    }

    public Integer delai(Tache t) {
        assert enAttente(t);
        if (t.equals(premiere()))
            return t.getDelai();
        else
            return suivantes().delai(t) + premiere().getDelai();
    }

    //A completer
    public boolean equals(Attente a) {
        return false;
    }
}
