package filosofos;

/**
 * Propuesta de resolución del problema "La cena de los filósofos".
 * @author Elena Dopico López
 * @version 1.0, 20/11/2020
 */

public class Filosofos {

    /**
     * @param args Argumentos línea comandos
     */
    public static void main(String[] args) {
        
        //Creación de objectos Palillo
        Palillo palillo1 = new Palillo(1);
        Palillo palillo2 = new Palillo(2);
        Palillo palillo3 = new Palillo(3);
        Palillo palillo4= new Palillo(4);
        Palillo palillo5 = new Palillo(5);
        
        //Creación de hilos
        Filosofo filosofo1 = new Filosofo(1,palillo1,palillo5);
        Filosofo filosofo2 = new Filosofo(2,palillo2,palillo1);
        Filosofo filosofo3 = new Filosofo(3,palillo3,palillo2);
        Filosofo filosofo4 = new Filosofo(4,palillo4,palillo3);
        Filosofo filosofo5 = new Filosofo(5,palillo5,palillo4);
        
        //Se inician los hilos
        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
        filosofo5.start();
   
    }
    
}
