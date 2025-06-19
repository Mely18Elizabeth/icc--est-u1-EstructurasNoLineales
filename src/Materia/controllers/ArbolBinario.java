package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {

    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value){
        if (padre == null) {
            return new Node(value);
        }
        if(value < padre.getValue()){
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public boolean buscar(int value) {
        boolean encontrado = buscarRec(root, value);
        if (encontrado) {
            System.out.println("Elemento " + value + " encontrado en el árbol.");
        } else {
            System.out.println("Elemento " + value + " NO se encontró en el árbol.");
        }
        return encontrado;
    }

    private boolean buscarRec(Node node, int value) {
        if (node == null) return false;
        if (value == node.getValue()) return true;
        return value < node.getValue()
            ? buscarRec(node.getLeft(), value)
            : buscarRec(node.getRight(), value);
    }

    public int getPeso() {
        return contarNodos(root);
    }

    private int contarNodos(Node node) {
        if (node == null) return 0;
        return 1 + contarNodos(node.getLeft()) + contarNodos(node.getRight());
    }

    public void imprimirInordenSoloValores() {
        imprimirSoloValores(root);
        System.out.println();
    }

    private void imprimirSoloValores(Node node) {
        if (node != null) {
            imprimirSoloValores(node.getLeft());
            System.out.print(node.getValue() + " ");
            imprimirSoloValores(node.getRight());
        }
    }

    public void imprimirInordenConAltura(){
        imprimirInordenConAltura(root);
        System.out.println();
    }

    private void imprimirInordenConAltura(Node node){
        if (node != null) {
            imprimirInordenConAltura(node.getLeft());
            int altura = getHeightRec(node);
            System.out.print(node.getValue() + "(h=" + altura + "), ");
            imprimirInordenConAltura(node.getRight());
        }
    }

    public void imprimirInordenConFactorEquilibrio() {
        imprimirInordenFE(root);
        System.out.println();
    }

    private void imprimirInordenFE(Node node){
        if (node != null) {
            imprimirInordenFE(node.getLeft());
            int fe = getFactorEquilibrio(node);
            System.out.print(node.getValue() + "(bf=" + fe + "), ");
            imprimirInordenFE(node.getRight());
        }
    }

    private int getFactorEquilibrio(Node node) {
        if (node == null) return 0;
        int hi = getHeightRec(node.getLeft());
        int hd = getHeightRec(node.getRight());
        return hi - hd;
    }

    public int getHeight(){
        return getHeightRec(root);
    }

    private int getHeightRec(Node node){
        if (node == null) return 0;
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean estaEquilibrado() {
        return estaEquilibradoRec(root);
    }

    private boolean estaEquilibradoRec(Node node) {
        if (node == null) return true;
        int fe = getFactorEquilibrio(node);
        if (fe < -1 || fe > 1) return false;
        return estaEquilibradoRec(node.getLeft()) && estaEquilibradoRec(node.getRight());
    }

    public void imprimirNodosDesequilibrados() {
        imprimirNodosDesequilibradosRec(root);
        System.out.println();
    }

    private void imprimirNodosDesequilibradosRec(Node node) {
        if (node != null) {
            imprimirNodosDesequilibradosRec(node.getLeft());

            int fe = getFactorEquilibrio(node);
            if (fe < -1 || fe > 1) {
                System.out.print(node.getValue() + "(fE=" + fe + "), ");
            }

            imprimirNodosDesequilibradosRec(node.getRight());
        }
    }
}
