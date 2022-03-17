package filosofos;

import java.util.concurrent.Semaphore;

/**
 * Clase que representa los palillos que usan los filósofos para comer
 * @author Elena Dopico López
 * @version 1.0, 20/11/2020
 */
public class Palillo {
    
    public Semaphore semaforo_palillo = new Semaphore(1);
    
    public int num_palillo;
    
    
    /**
    * Constructor
    * @param num_palillo    Entero que identifica el palillo
    */   
    public Palillo (int num_palillo) {
        this.num_palillo = num_palillo;
    }
    
    
    /**
    * Método para coger el palillo, que establece que mientras un filósofo
    * tiene un palillo el resto no lo pueden usasr
    */       
    public void cogerPalillo() {
        try{
            semaforo_palillo.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("ECCEPCION" + e);
        }
    }
    
    /**
    * Método que libera el palillo
    */  
    public void liberarPalillo(){
       semaforo_palillo.release();
    }
    
    /**
    * Método que comprueba si el palillo está cogido o libre
    * @return estado del palillo
    */ 
    public boolean estaLibre(){
        return semaforo_palillo.availablePermits()>0;
    }     
 }    
  
   
                

