import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

    ArrayList<Objeto> listaObjetos = new ArrayList<>();

        listaObjetos.add(new Objeto("Notebook", 1, 10));
        listaObjetos.add(new Objeto("Relógio", 2, 15));
        listaObjetos.add(new Objeto("Livro", 3, 40));
//        listaObjetos.add(new Objeto("Smartphone", 1, 1500));
//        listaObjetos.add(new Objeto("Câmera", 2, 1200));
//        listaObjetos.add(new Objeto("Fones de Ouvido", 1, 800));
//        listaObjetos.add(new Objeto("Tablet", 2, 1000));

    Controlador controlador = new Controlador(6, listaObjetos);

    controlador.resolverProblemaMochila();

    }
}