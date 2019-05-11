import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;


/**
 * Un conjunto de cartas cualquiera.
 */
public class ConjuntoCartas{
	
    /**
    *Guarda las cartas que 
    *forman el conjunto.
    */
    public ArrayList<Carta> cartas;
    
    /*
    Las siguientes listas y conjuntos nos servirán para 
    calcular el tipo de mano y la puntuación para 
    objetos tipo mano y cartas de bolsillo.
    */
    
    /**
     * Lista con los valores (de mayor a menor) que
     * aparecen en las cartas que pertenecen al
     * conjunto.
     */
    public ArrayList<Integer> valoresOrden;
    
    /**
     * 
     * Conjunto de valores que aparecen
     * en el conjunto de cartas.
    */
    public HashSet <Integer> valoresSinRepetir;
    
    /**
     * Lista de todos los palos que 
     * aparecen en el conjunto de cartas.
     */
    public ArrayList<Integer> palosOrden;
    
    /**
     * 
     * Conjunto de palos que aparecen
     * en el conjunto de cartas.
    */
    public HashSet<Integer> palosSinRepetir;


    /**
     * Se recibe un ArrayList con cartas, el atributo
     * principal del conjunto de cartas.
     * @param cartas Cartas que forman el conjunto. 
     */
    public ConjuntoCartas(ArrayList<Carta> cartas){
        
        this.cartas = new ArrayList<>(7);
        
        /*
        *Se forman las listas con los
        valores y palos y se ordenan
        de mayor a menor.
        */
        
        ArrayList<Integer> valores = new ArrayList<>(7);
        ArrayList<Integer> palos = new ArrayList<>(7);
        
        for(Carta carta: cartas){
            
            this.cartas.add(carta);
            
            valores.add(carta.getValor());
            palos.add(carta.getPalo());
            
        }
	     
        Collections.sort(valores);
        Collections.reverse(valores);
        	
        Collections.sort(palos);
        Collections.reverse(palos);
        
        this.valoresOrden = valores;
        this.palosOrden = palos;
        
        /*
        *No se cuentan las repeticiones en 
        *los conjuntos (se ocupará su tamaño).
        */
        
        this.valoresSinRepetir = new HashSet<>(valores);
        this.palosSinRepetir = new HashSet<>(palos);
		
    }
    

    /**
     * @return valoresOrden
    */
    public ArrayList<Integer> getValoresOrden(){
        
        return this.valoresOrden;
        
    }
    
    
    /**
     * @return valoresSinRepetir
    */
    public HashSet<Integer> getValoresSinRepetir(){
        
        return this.valoresSinRepetir;
        
    }
    
    
    /**
     * @return palosOrden
    */
    public ArrayList<Integer> getPalosOrden(){
        
        return this.palosOrden;
        
    }

    
    /**
     * @return palosSinRepetir
    */
    public HashSet<Integer> getPalosSinRepetir(){
        
        return this.palosSinRepetir;
        
    }
    
    
    /**
     * Representación de todas las cartas que
     * forman el conjunto.
     * @return Información de cada carta. 
     */
    public String toString() {
        
        String cartas = "";
        
        for(Carta carta: this.cartas){
            
            cartas += "\n" + carta.toString();
            
        } 
        
        return cartas + "\n";
        
    }
    
     
}