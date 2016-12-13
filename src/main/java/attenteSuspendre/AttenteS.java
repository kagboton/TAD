package attenteSuspendre;

import attente.Priorite;
import attente.Tache;

/**
 * Created by o2156238 on 13/12/16.
 */
public interface AttenteS {
    AttenteS supprimer(Tache t);
    AttenteS modifier(Tache t, Priorite p);
    AttenteS suivantes();
    AttenteS relancer(Tache t);
    boolean suspendue(Tache t);
    boolean vide();
    boolean enAttente(Tache t);
    Priorite priorite(Tache t);
    Tache premiere();
    Integer delai(Tache t);
    boolean equals(AttenteS a);

    String toString();
}
