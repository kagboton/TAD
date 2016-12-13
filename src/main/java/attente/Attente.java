package attente;

/**
 * Created by o2156238 on 07/12/16.
 */
public interface Attente {

    Attente supprimer(Tache t);
    Attente modifier(Tache t, Priorite p);
    Attente suivantes();
    boolean vide();
    boolean enAttente(Tache t);
    Priorite priorite(Tache t);
    Tache premiere();
    Integer delai(Tache t);
    boolean equals(Attente a);
    String toString();

}
