package attenteSuspendre;

import attente.Priorite;
import attente.Tache;

/**
 * Created by o2156238 on 13/12/16.
 */
public class EnregistrerS implements AttenteS {

    attente.Tache tache;
    attente.Priorite priorite;
    AttenteS attente;

    public EnregistrerS(AttenteS a, attente.Tache t, attente.Priorite p){
        this.attente = a;
        this.priorite = p;
        this.tache = t;
    }

    @Override
    public AttenteS supprimer(Tache t) {
        assert enAttente(t);
        if (tache.equals(t))
            return attente;
        else
            return new EnregistrerS(attente.supprimer(t), tache, priorite);
    }

    @Override
    public AttenteS modifier(Tache t, Priorite p) {
        assert enAttente(t);
        return new EnregistrerS(this.supprimer(t), t, p);
    }

    @Override
    public AttenteS suivantes() {
        assert !vide();
        return supprimer(this.premiere());
    }

    @Override
    public AttenteS relancer(Tache t) {
        assert (suspendue(t));
        return modifier(t, priorite(t));
    }

    @Override
    public boolean suspendue(Tache t) {
        if(this.tache.equals(t))
            return false;
        else
            return attente.suspendue(t);
    }

    @Override
    public boolean vide() {
        return false;
    }

    @Override
    public boolean enAttente(Tache t) {
        if (this.tache.equals(t))
            return true;
        else return attente.enAttente(t);
    }

    @Override
    public Priorite priorite(Tache t) {
        assert enAttente(t);
        if (tache.equals(t))
            return priorite;
        else return attente.priorite(t);
    }

    @Override
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
    public boolean equals(AttenteS a) {
        return false;
    }
}
