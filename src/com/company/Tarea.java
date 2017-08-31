package com.company;

public class Tarea {


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
     *  Funcion para calcular el cero por medio de la bisección
     * @param x argumento de la funcion
     * @return la imagen de x
     */
    public double funcion(double x){
         return  Math.pow(Math.E,x)-Math.pow(x,2);
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


    public static void main(String[] args) {


        Tarea tarea= new Tarea();

        tarea.biseccion(-2,0,0.001);

        tarea.Euclides(2366,273);

    }
}
