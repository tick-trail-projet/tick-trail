import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Horaires {
    private int jour;
    private int mois;
    private int annee;
    private String heure;

    public Horaires(int jour, int mois, int annee, String heure) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
    }

    public boolean check() {
        if (checkDate() == true && checkHeure() == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDate() {
        if (dateValidation(getJour() + "/" + getMois() + "/" + getAnnee())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkHeure() {
        String[] heure_ = getHeure().split(":");
        try {
            int hours = Integer.parseInt(heure_[0]);
            int minutes = Integer.parseInt(heure_[1]);
            if (heure_.length == 2 && hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean dateValidation(String date) {
        boolean status = false;
        if (datePattern(date)) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(date);
                status = true;
            } catch (Exception e) {
                status = false;
            }
        }
        return status;
    }

    static boolean datePattern(String date) {
        String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;
    }

    public int getJour() {
        return this.jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return this.mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getHeure() {
        return this.heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
