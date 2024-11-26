import java.util.ArrayList;
import java.util.Collections;

class Controlador {

    private Mochila mochila;

    private ArrayList<Objeto> listaObjetos ;

    private Integer[][] calculados;

    private Objeto[][] selecionados;

    public Controlador(int capacidade, ArrayList<Objeto> listaObjetos) {
        mochila = new Mochila(capacidade);
        this.listaObjetos = listaObjetos;
        calculados = new Integer[listaObjetos.size()+1][capacidade+1];
        selecionados = new Objeto[listaObjetos.size()+1][capacidade+1];

    }

    public void resolverProblemaMochila() {
        for(int i =1; i <= listaObjetos.size();i++)
        {
            for(int w =0; w<=mochila.getCapacidade();w++)
            {
                calculados[i][w] = calcular(i,w);
                //System.out.println(calculados[i][w]);
            }
        }
        mochilaAdd();
        imprimir();

    }
    public int calcular(int indice,int capacidade)
    {

        if(capacidade==0 || indice ==0)
        {
            return 0;
        }
        if(calculados[indice][capacidade] != null)
        {
            return calculados[indice][capacidade];
        }

        Objeto objetoAtual = listaObjetos.get(indice - 1);
        int peso = objetoAtual.getPeso();
        int preco = objetoAtual.getPreco();

        if(peso>capacidade)
        {
            return calcular(indice-1,capacidade);

        }
        if(preco+ calcular(indice-1,capacidade-peso) > calcular(indice-1,capacidade))
        {
            selecionados[indice][capacidade] =  objetoAtual;
            return preco+ calcular(indice-1,capacidade-peso);
        }
        return calcular(indice-1,capacidade);


    }
    public void mochilaAdd() {

        int capacidade = mochila.getCapacidade();

        for (int i = listaObjetos.size(); i > 0; i--) {
            Objeto item = selecionados[i][capacidade];
            if (item != null)
            {
                mochila.getLista().add(item);
                capacidade -= item.getPeso();
            }
        }
    }
    public void imprimir() {
        System.out.println("Itens escolhidos para a mochila:\n");
        int capacidadeOcupada =0;
        int valorTotal=0;

        for (Objeto item: mochila.getLista())
        {
            valorTotal +=item.getPreco();
            capacidadeOcupada += item.getPeso();
            System.out.println("-" + item.getNome() + "\nPeso: " + item.getPeso() + "\nValor: "+item.getPreco()+"\n");
        }
        System.out.println("\nValor Total: " + valorTotal);
        System.out.println("Capacidade ocupada: " + capacidadeOcupada+"Kg");

    }
}

