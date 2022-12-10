package com.ticktrail;

/**
 * classe gerant l'itinéraire
 */
public class Itineraires {
    private String start;
    private String end;
	
	/**
	 * constructeur
	 * @param start debut
	 * @param end fin
	 */
    public Itineraires(String start, String end) {
        this.start = start;
        this.end = end;
    }
	
	/**
	 *
	 * @return le debut de l'itineraire
	 */
    public String getStart() {
        return this.start;
    }
	
	/**
	 * positionne le debut de l'itineraire
	 * @param start le debut de l'itineraire
	 */
    public void setStart(String start) {
        this.start = start;
    }
	
	/**
	 *
	 * @return la fin de l'itineraire
	 */
    public String getEnd() {
        return this.end;
    }
	
	/**
	 * positionne la fin de l'itineraire
	 * @param end la fin de l'itineraire
	 */
    public void setEnd(String end) {
        this.end = end;
    }
	
	/**
	 *
	 * @param start le debut de l'itineraire
	 * @return l'itineraire
	 */
    public Itineraires start(String start) {
        setStart(start);
        return this;
    }
	
	/**
	 *
	 * @param end la fin de l'itineraire
	 * @return l'itineraire
	 */
    public Itineraires end(String end) {
        setEnd(end);
        return this;
    }
}
