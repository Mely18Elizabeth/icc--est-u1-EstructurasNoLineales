import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();

        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("Nombre: Melany Pintado\n");

        System.out.println("Peso del árbol: " + ab.getPeso());
        System.out.println("Altura: " + ab.getHeight() + "\n");

        System.out.println("Arbol InOrder");
        ab.imprimirInordenSoloValores();
        System.out.println();

        System.out.println("Arbol InOrder con alturas");
        ab.imprimirInordenConAltura();
        System.out.println();

        System.out.println("Arbol InOrder con factor de equilibrio");
        ab.imprimirInordenConFactorEquilibrio();
        System.out.println();

        System.out.println("Arbol esta equilibrado = " + ab.estaEquilibrado() + "\n");

        System.out.println("Agregamos valor = 15");
        ab.insert(15);
        System.out.println();

        System.out.println("Arbol InOrder con factor equilibrio ");
        ab.imprimirInordenConFactorEquilibrio();
        System.out.println();

        System.out.println("Nodos desequilibrados");
        ab.imprimirNodosDesequilibrados();

        /*System.out.println("--- BUSCAR ---");
        int valor = 77;
        ab.buscar(valor);*/
    }
}
