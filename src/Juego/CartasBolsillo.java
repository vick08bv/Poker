package Juego;

import Juego.Carta;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Las cartas de bolsillo son el par de cartas
 * que tiene cada jugador en una mano de póker.
 */
public class CartasBolsillo extends ConjuntoCartas{
   
    
    /**
     *Las cartas de bolsilo que tendrá cada
     *jugador, también cuentan con un 
     *puntaje, siguiendo el ejemplo de la
     *puntuación en las manos, 
     * (y apoyándose en ella).
     */
    private long puntaje;
    

    /**
     * Constructor.
     * @param cartas Lista de cartas. 
     */
    public CartasBolsillo(ArrayList<Carta> cartas){
        
        super(cartas);
     
        this.puntaje = 0;
        
    }
    
    
    /**
     * Calcula el puntaje que tiene
     * el par de cartas.
     */
    public void establecerPuntaje(){
        
        /*
         *Para darle un puntaje a las cartas
         *de bolsillo, formamos una mano 
         *imaginaria, con tres cartas más 
         *(imaginarias).
         */
        
        int mayorValor = this.getValoresOrden().get(0);
        int menorValor = this.getValoresOrden().get(1);
		
        /*
         *Las tres cartas imaginarias tienen
         *un palo imaginario (flechas) y un 
         *valor imaginario (que depende de 
         *los valores de las cartas de bolsillo
         *dadas.)
         */
        
        ArrayList<Carta> cartasFormadas = 
        new ArrayList<>(
        Arrays.asList(
        this.cartas.get(0),this.cartas.get(1),
        new Carta(5*(mayorValor+menorValor),0),
        new Carta(5*mayorValor+7*menorValor,0),
        new Carta(7*(mayorValor+menorValor),0)
        ));

        /*
         *Estas cartas imaginarias no existen en
         *la baraja francesa, pero se inventan 
         *para aprovechar el sistema de puntuación
         *de las manos y darle un valor a las 
         *cartas de bolsillo.
         *Si originalmente teniamos dos cartas del 
         *mismo valor, tendrán más puntaje pues 
         *la mano imaginaria será de tipo par
         *(las tres cartas imaginarias tienen valores
         *distintos entre sí).
         */
        
        Mano manoFormada = new Mano(cartasFormadas);
        
        manoFormada.establecerPuntaje();
        
        this.puntaje = manoFormada.getPuntaje();
		
        /*
         *Si las cartas son del mismo palo, se agrega 
         *un valor extra.
         */
        
        if(this.getPalosSinRepetir().size() == 1){
            
            this.puntaje += 5000000;
			
        }
        
        /*
         *Se corrige el puntaje para hacer
         *que esté en el rango de 
         *604,000 al 86,400, para hacer
         *que estos puntaje queden por debajo
         *de los puntaje de carta alta (en mano).
         *Y seguir la linea del sistema de 
         *puntuación.
         */
        
        this.puntaje /= 200;
	
    }
	

    /**
     * 
     * @return puntaje
     */
    public long getPuntaje(){
	
        return this.puntaje;
	
    }
    
    
    /**
     * @return  Información sobre la combinación
     * que forman el par de cartas.
     */
    public String  tipoDeCartasToString(){
     
        /*
         *En las cartas de bolsillo, podemos encontrar 
         *un par de cartas con el mismo palo 
         *(el conjunto de palos será de cardinalidad 1)
         *o con el mismo valor 
         *(el conjunto da valores será de cardinalidad 1).
         */
        
        String tipoDeCartas = "";
        
        if (this.getValoresSinRepetir().size() == 1){
        
            tipoDeCartas += 
            String.format(
            "\n%s%s\n","Par de ", this.cartas.get(0).valorToString()
            );
            
        }
        
        if (this.getPalosSinRepetir().size() == 1){
            
            tipoDeCartas += 
            String.format(
            "\n%s%s\n","Par de ", this.cartas.get(0).paloToString()
            );
            
        }
        
        return tipoDeCartas;
        
    }
    
    
    /**
     * 
     * @return Puntaje del par de cartas.
     */
    public String puntajeToString(){
        
        return String.format("\nPuntuación Java : %s\n", 
        this.puntaje);
        
    }
    
    
    /**
     * @return Información de ambas cartas y 
     * el tipo de combinación que forman.
     */
    @Override
    public String toString(){
        
        String cartasBolsillo  = this.tipoDeCartasToString();
            
        cartasBolsillo += super.toString();    
       
        return cartasBolsillo;
        
    }
    
    
}