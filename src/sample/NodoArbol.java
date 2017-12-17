package sample;

public class NodoArbol {
    //Declaramos las variables
    private int dato;
    private NodoArbol izq;
    private NodoArbol der;

    //Definimos el contructor
    public NodoArbol(int dato) {
        this.dato = dato;

    }


    //Especificamos los get correspondientes
    public NodoArbol getIzq() {
        return izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    //Especificamos los set correspondientes
    public void setDer(NodoArbol nodo) {
        der = nodo;
    }

    public void setIzq(NodoArbol nodo) {
        izq = nodo;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    //Para obtener el dato
    public int getDato() {
        return dato;
    }

}
