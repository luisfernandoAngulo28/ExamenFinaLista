/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author fernando
 */
public class Lista {

    //Atributos
    Nodo L;
    int Cant;

    public Lista() {
        L = null;
        Cant = 0;
    }

    public boolean Vacio() {
        return (L == null);
    }

    public int Cantidad() {
        return Cant;
    }

    public void Insertar(int ele) {
        if (Vacio()) {
            Nodo P = new Nodo();
            P.setDato(ele);
            L = P;
            Cant++;

        } else {
            Nodo Ant = null;
            Nodo Auxi = L;//hace referencia al primer elemento de la Lista

            while ((Auxi != null) && (Auxi.getDato() < ele)) {
                Ant = Auxi;
                Auxi = Auxi.getEnlace();
            }
            if (Ant == null) {
                Nodo P = new Nodo();
                P.setDato(ele);
                P.setEnlace(L);
                L = P;
                Cant++;
            } else {
                //Insertar En el cuerpo
                if (Ant.getDato() != ele) {

                    Nodo P = new Nodo();
                    P.setDato(ele);
                    Ant.setEnlace(P);

                    P.setEnlace(Auxi);
                    Cant++;
                }
            }
        }
    }

    public void Eliminar(int ele) {
        if (Vacio()) {
            Nodo Auxi = L;
            Nodo Ant = null;
            while ((Auxi != null) && (Auxi.getDato() != ele)) {
                Ant = Auxi;
                Auxi = Auxi.getEnlace();
            }
            if (Auxi != null) {
                if (Ant == null) {
                    L = L.getEnlace();
                } else {
                    Ant.setEnlace(Auxi.getEnlace());
                }
            }
        }
    }

    public int GetDato(int pos) {
        Nodo Auxi = L;
        for (int i = 1; i < pos; i++) {
            Auxi = Auxi.getEnlace();
        }
        return Auxi.getDato();
    }

    public void invertira2() {
        Nodo aux = L;
        Nodo pos = L.getEnlace();
        Nodo ant = new Nodo();
        while (pos != null) {
            aux.setEnlace(pos.getEnlace());
            pos.setEnlace(aux);
            if (aux == L) {
                L = pos;
            } else {
                ant.setEnlace(pos);
            }
            ant = aux;
            aux = aux.getEnlace();
            if (aux == null) {
                pos = aux;
            } else {
                pos = aux.getEnlace();
            }
        }
    }

    @Override
    public String toString() {
        String s = "L -> ";
        Nodo aux = L;
        while (aux != null) {
            s = s + "[" + aux.getDato() + " | ]->";
            aux = aux.getEnlace();
        }
        return s + "null";
    }

    public void Volcar2() {
        Nodo aux = L;
        Nodo pos = L.getEnlace();
        Nodo ant = new Nodo();//null;
        //recorrmos con pos
        while (pos != null) {
            aux.setEnlace(pos.getEnlace());
            pos.setEnlace(aux);
            if (aux == L) {
                L = pos;
            } else {
                ant.setEnlace(pos);
            }
            //cambio de punteros
            ant = aux;
            aux = aux.getEnlace();

            if (aux != null) {
                pos = aux.getEnlace();
            } else {
                pos = aux;
            }

        }
    }

    public void VolcarDea2() {
        Nodo Nodoauxiliar = L;
        Nodo pos = L.getEnlace();
        Nodo ant = null;
        //recorrmos con pos
        while (pos != null) {
            Nodo val = pos.getEnlace();
            Nodoauxiliar.setEnlace(val);
            pos.setEnlace(Nodoauxiliar);
            if (Nodoauxiliar != L) {
                ant.setEnlace(pos);
                // System.out.println(ant.toString());
            } else {

                L = pos;
            }
            //cambio de punteros
            ant = Nodoauxiliar;
            Nodoauxiliar = Nodoauxiliar.getEnlace();

            if (Nodoauxiliar != null) {
                pos = Nodoauxiliar.getEnlace();
            } else {
                pos = Nodoauxiliar;
            }

        }
    }

    public void Enroque2() {
        if (Cant > 2) {
            Nodo ant = L;
            Nodo A = L.getEnlace();
            Nodo B = L.getEnlace().getEnlace();
            while (A.getEnlace() != null) {
                ant.setEnlace(B);
                A.setEnlace(B.getEnlace());
                B.setEnlace(A);
                if (A.getEnlace() != null) {
                    ant = ant.getEnlace().getEnlace();
                    A = A.getEnlace();
                    B = A.getEnlace();
                }
            }
        }
    }

    //GETTERS
    public void intercalarDeA1SinListaAux() {
        Nodo p = L;
        while (p != null) {
            if (p.getEnlace() != null) {
                p.setEnlace(p.getEnlace().getEnlace());
            }
            p = p.getEnlace();
        }
    }
//L ->[1|]->[2|]->[3|]->[4|]->[5|]->null
    //Si es par          L ->[1|]->[2|]->[3|]->[4|]->[5|]->[6|]->null

    public void InvertirLista() {
        if (Cant > 1) {
            Nodo nodoAux;
            Nodo nodoAnt;
            if (Cant % 2 != 0) {
                nodoAnt = L;
                nodoAux = nodoAnt.getEnlace();
            } else {

                nodoAux = L;
                nodoAnt = new Nodo();
            }

            while (nodoAux != null) {
                Nodo nodoPos = nodoAux.getEnlace();

                nodoAux.setEnlace(nodoPos.getEnlace());
                nodoPos.setEnlace(nodoAux);

                if (L != nodoAux) {
                    nodoAnt.setEnlace(nodoPos);
                } else {

                    L = nodoPos;
                }

                nodoAnt = nodoAux;
                nodoAux = nodoAux.getEnlace();

            }

        }
    }

    public void movera4en4() {
        Nodo a = L;
        Nodo b = a.getEnlace();
        Nodo c = b.getEnlace();
        Nodo d = c.getEnlace();

        Nodo sig = d.getEnlace();
        L = d;
        for (int i = 1; i <= (Cantidad() / 4) - 1; i++) {

            a.setEnlace(sig.getEnlace().getEnlace().getEnlace());
            c.setEnlace(a);
            b.setEnlace(c);
            d.setEnlace(b);
            a = sig;
            b = a.getEnlace();
            c = b.getEnlace();
            d = c.getEnlace();
            sig = d.getEnlace();

        }
        c.setEnlace(a);
        b.setEnlace(c);
        d.setEnlace(b);
        a.setEnlace(sig);

    }

    public void Movera4() {

        if (Cantidad() > 3) {
            Nodo a = L;
            Nodo b = a.getEnlace();
            Nodo c = b.getEnlace();
            Nodo d = c.getEnlace();
            Nodo sig = d.getEnlace();
            L = d;

            for (int i = 1; i <= (Cantidad() / 4) - 1; i++) {
                a.setEnlace(sig.getEnlace().getEnlace().getEnlace());
                d.setEnlace(c);
                c.setEnlace(b);
                b.setEnlace(a);
                a = sig;
                b = a.getEnlace();
                c = b.getEnlace();
                d = c.getEnlace();
                sig = d.getEnlace();
            }

            d.setEnlace(c);
            c.setEnlace(b);
            b.setEnlace(a);

            if (Cantidad() % 4 == 0) {
                a.setEnlace(null);
            } else {
                a.setEnlace(sig);
            }

        }
    }

    public static void main(String[] args) {
        Lista L = new Lista();
        L.Insertar(1);
        L.Insertar(2);
        L.Insertar(3);
        L.Insertar(4);
        L.Insertar(5);
        L.Insertar(6);
        L.Insertar(7);
        L.Insertar(8);
        System.out.println(L.toString());
        L.movera4en4();
        System.out.println(L.toString());
        // System.out.println("   ");

    }
}
