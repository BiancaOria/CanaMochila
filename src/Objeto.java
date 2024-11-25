public class Objeto implements Comparable<Objeto> {

    private String nome;
    private int peso;
    private int preco;

    public Objeto(String nome, int peso, int preco) {
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public int getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Objeto o) {

        if(this.preco > o.getPreco()){

            return +1;
        } else if (this.preco < o.getPreco()) {

            return -1;
        }
        return 0;
    }
}
