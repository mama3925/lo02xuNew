package lo02xu;

import java.util.ArrayList;
import java.util.Random;

public class Aleatoire implements Strategie {
    private String strategie;
    private int indexStrategie;

    public Aleatoire() {
        this.strategie = "Aleatoire";
        this.indexStrategie = 2;
    }

    public String getStrategie() {
        return this.strategie;
    }

    public int getIndexStrategie() {
        return this.indexStrategie;
    }

    public void combat(Etudiant student){
        Random ran = new Random();
        boolean bo = ran.nextBoolean();
        if(bo){
            Etudiant attaquant = student;
            Zone zoneCurrent = attaquant.getZone();
            ArrayList<Etudiant> listEtu = zoneCurrent.getListEtu();
            listEtu.sort(Etudiant.comparatorEcts);
            Etudiant attaque = listEtu.get(0);
            int i = 1;
            while (attaque.getJoueur() == attaquant.getJoueur() || attaque.isReserviste() == true)  i++;

            attaque = listEtu.get(i);

            Random random = new Random();
            int x = random.nextInt(101);
            double y = random.nextDouble();
            if (x >= 0 && x <= 40 + 3 * attaquant.getDexterite()) {
                int coefDegat = Math.max(0, Math.min(100, 10 * attaquant.getForce() - 5 * attaque.getResistance()));
                int degat = (int) (Math.floor(y * (1 + coefDegat) * 10));
                if (attaquant.getEcts() > 0 && attaque.getEcts() > 0 && attaquant.isReserviste() == false) {
                    if (degat < attaque.getEcts()) {
                        attaque.setEcts(attaque.getEcts() - degat);
                        System.out.println("etudiant " + attaquant.getNumEtu() + " a effectue " + degat + " a l'edu " + attaque.getNumEtu() + "\n");
                    } else {
                        System.out.printf("etudiant " + attaquant.getNumEtu() + " a tue etu " + attaque.getNumEtu() + "\n");
                        listEtu.remove(attaque);
                    }
                }

            } else System.out.println("L'attaquant etu " + attaquant.getNumEtu() + " a echoue l'attaque\n");
        }
        else if(!bo){
            Etudiant soignant = student;
            Zone zoneCurrent = soignant.getZone();
            ArrayList<Etudiant> cureEtu = zoneCurrent.getListEtu();
            cureEtu.sort(Etudiant.comparatorEcts);
            Etudiant soigne = cureEtu.get(0);
            int i = 1;


            while (soigne.getJoueur() != soignant.getJoueur() || soigne.isReserviste() == true) i++;

            soigne = cureEtu.get(i);

            int flag = 0;
            Random random = new Random();
            int x = random.nextInt(101);
            double y = random.nextDouble();
            if (y > 0.6) y -= 0.4;

            while (soignant.isReserviste() == false && soignant.getEcts() > 0 && soigne.getEcts() > 0 && flag == 0) {
                if (soigne.getEcts() >= 30 + soigne.getConstitution()) {
                    i++;
                } else if (x >= 0 && x <= 20 + 6 * soignant.getDexterite()) {
                    int soin = (int) Math.floor(y * (10 + soigne.getConstitution()));
                    if (soin + soigne.getEcts() < 30 + soigne.getConstitution()) {
                        soigne.setEcts(soin + soigne.getEcts());
                        System.out.println("etu " + soignant.getNumEtu() + " a soine " + soin + " a l'etu " + soigne.getNumEtu() + "\n");
                        flag++;
                    } else {
                        soigne.setEcts(30 + soigne.getConstitution());
                        int soinReel = 30 + soigne.getConstitution() - soigne.getEcts();
                        System.out.println("etu " + soignant.getNumEtu() + " a soine " + soinReel + " a l'etu " + soigne.getNumEtu() + "\n");
                        flag++;
                    }
                } else {
                    System.out.println("Etu " + soignant.getNumEtu() + " a echoue le soin\n");
                    flag++;
                }
            }
        }
    }
}
