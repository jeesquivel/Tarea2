package com.company;

import java.util.ArrayList;

public class Tarea {

    /**
     *  Funcion prima para calcular el cero por medio de la bisección
     * @param x argumento de la funcion
     * @return la imagen de x
     */

    public double funcionPrima(double x){
        return  Math.pow(Math.E,x)-2*x;
    }

    /**
     *  Funcion para calcular el cero por medio de la bisección
     * @param x argumento de la funcion
     * @return la imagen de x
     */

    public double funcion(double x){
        return  Math.pow(Math.E,x)-Math.pow(x,2);
    }



    /**
     * Calcula el MCD por medio del algortmo de Euclides
     * @param a  extremo inferior de un intervalo euclideo
     * @param b  extremo superior de un intervalo euclideo
     */
    public   void Euclides(int a, int b){
        int r=a%b;
        while (r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        System.out.print("Máximo común divisor es: "+ b);
    }




    /**
     *  Metodo de biseccion
     * @param a extremo inferior del intervalo
     * @param b extremo superior del itervalo
     * @param tol tolerancia del erro absoluto
     */
    public void biseccion(double a, double b, double tol){
        double errorAbs=0;
        double x;
        int iteraciones=0;
        if (funcion(a)*funcion(b)<0){
            do {
                x=(a+b)/2;
                errorAbs=(b-a)/2;
                boolean test= funcion(a)*funcion(x)<0;
                if (test) b=x;
                else{
                    if (!test) a=x;
                    else  errorAbs=0;
                }
                iteraciones++;
            }while (errorAbs>tol);
            System.out.println("Aproximación: "+x+ " | Cantidad de iteraciones: "+ iteraciones);
        }
        else System.out.println("No se garantiza la existencia de soluciones :(");
    }

    /**
     * Aproxima el cero de una función
     * @param x valor inicial
     * @param tol tolerancia en el error relativo
     * @param iteraciones cantidad de iteraciones máximas
     */
    public void NewtonRaphson(double x, double tol, int iteraciones){
        double errorRelativo= Double.POSITIVE_INFINITY;
        double xi;
        int i=0;
        while (errorRelativo>tol&& i<iteraciones){
            i++;
            xi=x-funcion(x)/funcionPrima(x);
            errorRelativo= Math.abs((xi-x)/xi);
            x=xi;
        }
        if (i>= iteraciones){
            System.out.print("No se ha podido calcular la aproximación");
        }else
            System.out.println("Aproximación:"+x+ "| iteraciones: "+i);
    }

    public  void quicksort(ArrayList<Integer> lista, int izq, int der) {

        int pivote= lista.get(4); // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las búsquedas
            while(lista.get(i)<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(lista.get(j)>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado
                aux= lista.get(i);                  // los intercambia
                lista.set(i,lista.get(j));
                lista.set(j,aux);
            }
        }
        lista.set(izq,lista.get(j)); // se coloca el pivote en su lugar de forma que tendremos
        lista.set(j,pivote); // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quicksort(lista,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quicksort(lista,j+1,der); // ordenamos subarray derecho
    }



    public static void main(String[] args) {


        Tarea tarea= new Tarea();

        tarea.biseccion(-2,0,0.001);

        tarea.Euclides(2366,273);

        tarea.NewtonRaphson(2,0.001,20);

    }
}
