package attenteSuspendre;

import attente.Priorite;
import attente.Tache;

/**
 * Created by o2156238 on 13/12/16.
 */
public class Suspendre implements AttenteS {

    Tache tache;
    AttenteS att;

    public Suspendre(Tache t, AttenteS a){
        this.tache = t;
        this.att = a;
    }

    @Override
    public AttenteS supprimer(Tache t) {
       if(this.tache.equals(t))
           return this.att.supprimer(t);
        else
            return new Suspendre(this.tache, this.att.supprimer(t));
    }

    @Override
    public AttenteS modifier(Tache t, Priorite p) {
        return new EnregistrerS(this.supprimer(t), t, p);
    }

    @Override
    public AttenteS suivantes() {
        assert (!vide());
        return supprimer(premiere());
    }

    @Override
    public AttenteS relancer(Tache t) {
        assert (suspendue(t));
        return modifier(t, priorite(t));
    }

    @Override
    public boolean suspendue(Tache t) {
        if (this.tache.equals(t))
            return true;
        else
            return suspendue(t);
    }

    @Override
    public boolean vide() {
        return att.supprimer(this.tache).vide();
    }

    @Override
    public boolean enAttente(Tache t) {
        if(this.tache.equals(t))
            return  false;
        else
            return enAttente(t);
    }

    @Override
    public Priorite priorite(Tache t) {
        return priorite(t);
    }

    @Override
    public Tache premiere() {
        assert (!vide());
        return this.att.supprimer(this.tache).premiere();
    }

    @Override
    public Integer delai(Tache t) {
        assert (enAttente(t) && !suspendue(t));
        if (t.equals(this.att.premiere()))
            return t.getDelai();
        else
            return this.att.suivantes().delai(t) + delai(this.att.premiere()) ;
         // ou bien   return suivantes().delai(t) + this.att.premiere().getDelai();
    }

    @Override
    public boolean equals(AttenteS a) {
        return false;
    }
}
