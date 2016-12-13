package attenteSuspendre;

import attente.Priorite;
import attente.Tache;

/**
 * Created by o2156238 on 13/12/16.
 */
public class CreerS implements AttenteS {

    @Override
    public AttenteS supprimer(Tache t) {
        return null;
    }

    @Override
    public AttenteS modifier(Tache t, Priorite p) {
        return null;
    }

    @Override
    public AttenteS suivantes() {
        return null;
    }

    @Override
    public AttenteS relancer(Tache t) {
        return new CreerS();
    }

    @Override
    public boolean suspendue(Tache t) {
        return false;
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
    public boolean equals(AttenteS a) {
        return false;
    }
}
