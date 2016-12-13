package attente;

/**
 * Created by o2156238 on 07/12/16.
 */
public class Tache {

    private Integer numero;
    private  Integer delai;


    public Tache(Integer numero, Integer delai){
        this.numero = numero;
        this.delai = delai;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }
}
