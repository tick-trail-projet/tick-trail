package com.ticktrail.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * classe decrivant la gestion de la sauvegarde
 */
public class Storage {
    private String path;
	
	/**
	 * Initialise le chemin du fichier de sauvegarde
	 *
	 * @param path chemin
	 * @throws FileNotFoundException Fichier introuvable
	 */
    public Storage(String path) throws FileNotFoundException {
        if (exists(path)) {
            this.path = path;
        } else {
            throw new FileNotFoundException("Fichier introuvable");
        }
    }
	
	/**
	 * lecture du fichier
	 *
	 * @return contenu du fichier
	 * @throws IOException  Si une erreur de lecture/ecriture arrive
	 */
    public String read_file() throws IOException {
        File doc = new File(this.getPath());
        BufferedReader obj = new BufferedReader(new FileReader(doc));

        String strng = obj.readLine();

        obj.close();
        return strng;
    }
	
	/**
	 * sauvegarde de donnees dans un fichier
	 *
	 * @param text contenu a sauvegarder
	 * @throws IOException  Si une erreur de lecture/ecriture arrive
	 */
    public void write_file(String text) throws IOException {
        new FileOutputStream(this.getPath()).close();
        File doc = new File(this.getPath());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(doc.getPath(), true)));
        out.print(text);
        out.close();
    }
	
	/**
	 * fermeture du fichier
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    public void clear_file() throws IOException {
        new FileOutputStream(this.getPath()).close();
    }
	
	/**
	 *  verifie que le fichier existe
	 *
	 * @param path_name chemin
	 * @return true si le fichier est present sinon false
	 */
    public boolean exists(String path_name) {
        File f = new File(path_name);
        return f.exists();
    }
	
	/**
	 * recupere le chemin du fichier
	 *
	 * @return le chemin du fichier
	 */
    public String getPath() {
        return this.path;
    }
	
	/**
	 * postionne le chemin du fichier
	 *
	 * @param path le chemin
	 */
    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws IOException {
        Storage storage = new Storage("./src/main/java/com/ticktrail/database/trip.txt");
        storage.write_file("Blois,Paris,2022-12-07");
        System.out.println(storage.read_file().split(",")[0]);
    }
}
