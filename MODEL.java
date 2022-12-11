package test;

public interface MODEL {



	/**
	 * Interface de base pour les éléments GTFS 
	 */

	public int getNbEntry();
	public void fromStringArray(String[] value) throws FileFormatException;
}

