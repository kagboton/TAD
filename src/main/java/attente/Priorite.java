package attente;

/**
 * Created by o2156238 on 07/12/16.
 */
public class Priorite implements Comparable<Priorite>{

    Integer priorite;

    public Priorite(Integer i){
        priorite = i;
    }

    @Override
    public int compareTo(Priorite arg0) {
        if (priorite > arg0.priorite)
            return 1;
        else
            return 0;
    }

    public Integer getPriorite() {
        return priorite;
    }

    public boolean equals(Priorite pr){
        return priorite.equals(pr);
    }
}
