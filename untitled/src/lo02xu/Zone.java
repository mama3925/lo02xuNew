package lo02xu;

import java.util.*;

public class Zone {
    private NomZone nomZone;//maybe useless, just because the annex of the project requires this property
    private static int numZone = 0;//static variable, just used to initialization, to set 5 zone names
    private ArrayList<Etudiant> listEtu;//the students in this zone
    private int numOfEtu;//maybe useless, maybe we use it to guarantee that it has at least 1 student in this zone.
    private int indexZone;//very important, it's the ID of the zone (1,2,3,4,5)
    private int controlee;//to see if it's controlled or not
    private Control control;//one object control has 2 objects player.

    public Zone(Control control) {
        numOfEtu = 0;
        this.listEtu = new ArrayList<Etudiant>();

        switch (numZone) {
            case 0 -> {
                this.nomZone = NomZone.Bibliotheque;
                this.indexZone = 0;
            }
            case 1 -> {
                this.nomZone = NomZone.BureauDesEtudiants;
                this.indexZone = 1;
            }
            case 2 -> {
                this.nomZone = NomZone.QuartierAdministratif;
                this.indexZone = 2;
            }
            case 3 -> {
                this.nomZone = NomZone.HallesIndustrielles;
                this.indexZone = 3;
            }
            case 4 -> {
                this.nomZone = NomZone.HalleSportive;
                this.indexZone = 4;
            }
        }
        numZone++;
        this.controlee = 0;

        this.control = control;
        control.getListZone().add(this);

    }

    public int getIndexZone() {
        return this.indexZone;
    }

    public void setNumZone(int numZone) {
        this.indexZone = numZone;
    }

    public NomZone getNomZone() {
        return this.nomZone;
    }

    public void setNomZone(NomZone nomZone) {
        this.nomZone = nomZone;
    }

    public int getNumOfEtu() {
        return this.numOfEtu;
    }

    public void setNumOfEtu(int numOfEtu) {
        this.numOfEtu = numOfEtu;
    }

    public ArrayList<Etudiant> getListEtu() {
        return this.listEtu;
    }

    public int isControlee() {
        if (this.controlee == 0) {
            ArrayList<Etudiant> tempListEtuJou1 = new ArrayList<Etudiant>();
            ArrayList<Etudiant> tempListEtuJou2 = new ArrayList<Etudiant>();
            //Etudiant etu : this.listEtu
            for (int i = 0; i < this.listEtu.size(); i++) {
                if (this.listEtu.get(i).getJoueur() == this.control.getListJoueur().get(0)) {
                    tempListEtuJou1.add(this.listEtu.get(i));
                } else if(this.listEtu.get(i).getJoueur() == this.control.getListJoueur().get(1)){
                    tempListEtuJou2.add(this.listEtu.get(i));
                }
            }
            int flag1 = 0;
            int flag2 = 0;
            for (Etudiant etu : tempListEtuJou1) {
                flag1 += etu.getEcts(); //in fact it's stupid to add this line here, because we have written a function for adding the total ects
            }
            for (Etudiant etu : tempListEtuJou2) {
                flag2 += etu.getEcts(); //in fact it's stupid to add this line here, because we have written a function for addingt the total ects
            }
            if (flag1 == 0) {
                this.controlee = 2;
                this.control.getListJoueur().get(1).getListZoneControlee().add(this);

            } else if (flag2 == 0) {
                this.controlee = 1;
                this.control.getListJoueur().get(0).getListZoneControlee().add(this);

            }
        }
        return controlee;
    }

    public int getTotalPoints1() {
        int sum = 0;
        Iterator<Etudiant> it = this.listEtu.iterator();
        while (it.hasNext()) {
            Etudiant etu = it.next();
            if (etu.isReserviste() == false && etu.getEcts() > 0 && etu.getJoueur() == this.control.getListJoueur().get(0)) {
                sum += etu.getEcts();
            }
        }
        return sum;
    }

    public int getTotalPoints2() {
        int sum = 0;
        Iterator<Etudiant> it = this.listEtu.iterator();
        while (it.hasNext()) {
            Etudiant etu = it.next();
            if (etu.isReserviste() == false && etu.getEcts() > 0 && etu.getJoueur() == this.control.getListJoueur().get(1)) {
                sum += etu.getEcts();
            }
        }
        return sum;

    }

    public String afficherZone() {
        StringBuffer sb = new StringBuffer();
        sb.append("Zone " + this.getNomZone() + "\n");
        sb.append("Joueur1 a totalement " + this.getTotalPoints1() + " points.\n");
        sb.append("Joueur2 a totalement " + this.getTotalPoints2() + " points.\n");
        return sb.toString();
    }
}
