import java.util.ArrayList;

public class Mochila {

    private int capacidade;

    private ArrayList<Objeto> lista;

    public Mochila(int capacidade) {
        this.capacidade = capacidade;
        lista = new ArrayList<Objeto>();
    }


    public ArrayList<Objeto> getLista() {
        return lista;
    }

    public int getCapacidade() {
        return capacidade;
    }


}
