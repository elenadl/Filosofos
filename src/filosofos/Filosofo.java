package filosofos;

/**
 * Clase que representa un filósofo y que extiende de Thread
 * @author Elena Dopico López
 * @version 1.0, 20/11/2020
 */
public class Filosofo extends Thread {
    
    public final static int PENSANDO = 0;
    public final static int HAMBRIENTO = 1;
    public final static int COMIENDO = 2;
    int estado_filosofo;
    int num_filosofo;
    Palillo palillo_derecho;
    Palillo palillo_izquierdo;

    
    /**
     * Constructor
     * @param num_filosofo      Entero que identifica al filósofo
     * @param palillo_derecho    Objecto que identifica al palillo derecho
     * @param palillo_izquierdo    Objecto que identifica al palillo izquierdo
     */   
    public Filosofo (int num_filosofo, Palillo palillo_derecho, Palillo palillo_izquierdo){
        this.num_filosofo = num_filosofo;
        this.palillo_derecho = palillo_derecho;
        this.palillo_izquierdo = palillo_izquierdo;
        estado_filosofo = PENSANDO;     
    }
    
    
     /**
     * Método que ejecuta las distintas acciones asociadas a cada estado
     * del filósofo
     */  
    @Override
    public void run(){
        //El filósofo transiciona 10 veces por cada estado      
        for (int i=0; i<=2; i++){
         
            while (estado_filosofo == PENSANDO){
                pensar();
            }

            while (estado_filosofo == HAMBRIENTO) {
                intentar_comer();
            } 

            while (estado_filosofo == COMIENDO){
                comer();
            }
        }
    }
    
    /**
    * Método que mantiene al filósofo en estado Pensando durante un period de 
    * tiempore y después lo transiciona a estado Hambriento
    */  
    public void pensar(){
        System.out.println("Filósofo " + num_filosofo +  " Pensando");
        long tiempo_pensar = 3000;
        try {
            sleep(tiempo_pensar);
        } catch (InterruptedException ex) {
        }
        estado_filosofo = HAMBRIENTO;
        System.out.println("Filósofo " + num_filosofo +  " Hambriento");
    }
    
    /**
    * Método que comprueba si los palillos del filósofo están libres y, si es
    * así, los coge y transiciona al filósofo a estado Comiendo
    */      
    public synchronized void intentar_comer(){
               if (palillo_derecho.estaLibre() && palillo_izquierdo.estaLibre()) {
            palillo_derecho.cogerPalillo();
            palillo_izquierdo.cogerPalillo();
            estado_filosofo = COMIENDO;
        }    
    }
    
    /**
    * Método que mantiene al filósofo un periodo de tiempo comiendo y, cuando
    * acaba, libera los palillos y transiciona al filósofo a estado Pensando
    */ 
    public void comer(){
        System.out.println("Filósofo " + num_filosofo +  " Comiendo");
        long tiempo_comer = 3000;
        try {
            sleep(tiempo_comer);
        } catch (InterruptedException ex) {
        }
        System.out.println("Filósofo " + num_filosofo +  " Termina de comer. Libres palillos: " + palillo_derecho.num_palillo + ", " + palillo_izquierdo.num_palillo);
        palillo_derecho.liberarPalillo();
        palillo_izquierdo.liberarPalillo();
        estado_filosofo = PENSANDO;
    }
 }    
  
 