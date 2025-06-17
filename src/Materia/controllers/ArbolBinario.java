package Materia.controllers;
import Materia.models.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario(){
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value){
        if(padre == null){
            return new Node(value);
        }
        if(value < padre.getValue()){
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()){
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol(){
        imprimir(root);
    }

    public void imprimirArbolDos(){
        imprimirDos(root);
    }

    public void imprimir(Node node){
    if (node != null){
        imprimir(node.getLeft());
        System.out.println(node.getValue());
        imprimir(node.getRight());
    }
    }

    public void imprimirDos(Node node){
    if (node != null){
        System.out.println(node.getValue());
        imprimir(node.getLeft());
        imprimir(node.getRight());
    }
    }

    public boolean buscar(int value){
        return buscarRec(root, value);

    }

    private boolean buscarRec(Node node, int value) {
    if (node == null) {
        return false;
    }
    if (node.getValue() == value) {
        return true;
    }
    boolean num = buscarRec(node.getLeft(), value);
    if (num) {
        return true;
    }
    return buscarRec(node.getRight(), value);
}

}
