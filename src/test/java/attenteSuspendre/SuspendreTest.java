package attenteSuspendre;

import attente.Priorite;
import attente.Tache;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by o2156238 on 13/12/16.
 */
public class SuspendreTest {

    Tache tache, t;
    Priorite pr, prio;
    AttenteS myAttente;

    @Test
    public void relancer() throws Exception {

        tache = new Tache(2, 3);
        pr = new Priorite(17);
        myAttente = new EnregistrerS(new CreerS(), tache, pr);
        assertFalse(myAttente.vide());
        assertTrue(myAttente.premiere().getNumero() == 2);
        myAttente = new Suspendre(tache, myAttente);

        t = new Tache(6, 3);
        prio = new Priorite(10);
        myAttente = new EnregistrerS(myAttente, t, prio);
        assertTrue(myAttente.premiere().getNumero() == 6);
        assertTrue(myAttente.priorite(tache).getPriorite() == 17);
        myAttente = myAttente.relancer(tache);
        assertFalse(myAttente.vide());
        assertTrue(myAttente.premiere().equals(tache));


    }

    @Test
    public void suspendue() throws Exception {

        tache = new Tache(2, 3);
        pr = new Priorite(7);
        myAttente = new EnregistrerS(new CreerS(), tache, pr);
        t = new Tache(6, 9);
        pr = new Priorite(5);

        myAttente = new Suspendre(tache, myAttente);
        assertTrue(myAttente.vide());
        myAttente = new EnregistrerS(myAttente, t, pr);
        assertFalse(myAttente.vide());

    }

    @Test
    public void modifier() throws Exception{
        tache = new Tache(2, 3);
        pr = new Priorite(7);
        myAttente = new EnregistrerS(new CreerS(), tache, pr);
        assertTrue(myAttente.priorite(tache).getPriorite() == 7);

        t = new Tache(6, 9);
        pr = new Priorite(5);
        myAttente = new EnregistrerS(myAttente, t, pr);
        myAttente = myAttente.modifier(tache, new Priorite(10));
        assertTrue(myAttente.priorite(tache).getPriorite() == 10);

    }



}