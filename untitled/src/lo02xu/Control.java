package lo02xu;

import java.util.*;

public class Control {
    private ArrayList<Joueur> joueurs;
    private ArrayList<Zone> zones;

    public Control() {
        this.joueurs = new ArrayList<Joueur>();
        this.zones = new ArrayList<Zone>();
        Zone zone0 = new Zone(this);
        Zone zone1 = new Zone(this);
        Zone zone2 = new Zone(this);
        Zone zone3 = new Zone(this);
        Zone zone4 = new Zone(this);
        Joueur joueur1 = new Joueur(1, this);
        Joueur joueur2 = new Joueur(2, this);
    }

    public void init() {
        System.out.println("You should choose the filiere of the two players, please input twice, range 0-6");
        Scanner sc = new Scanner(System.in);
        this.joueurs.get(0).setFiliere(sc.nextInt());
        this.joueurs.get(1).setFiliere(sc.nextInt());

        this.joueurs.get(0).setReserviste();
        this.joueurs.get(1).setReserviste();


        for (Etudiant etu1 : this.joueurs.get(0).getListEtu()) {
            etu1.modifierDataEtu();
            etu1.choisirStrategie();
            etu1.placerZoneIni();
        }
        for (Etudiant etu2 : this.joueurs.get(1).getListEtu()) {
            etu2.modifierDataEtu();
            etu2.choisirStrategie();
            etu2.placerZoneIni();
        }

    }


    public void fight() {
        int drapeau = 0;
        while (drapeau == 0) {
            for (int k = 0; k < this.zones.size(); k++) {
                Zone zone = this.zones.get(k);
                if (zone.isControlee() == 0) {
                    zone.getListEtu().sort(Etudiant.comparatorInitiative);
                    //Iterator<Etudiant> iterator=zone.getListEtu().iterator();
                    int flag = 0;
                    for (int i = 0; i < zone.getListEtu().size(); i++) {
                        if (flag == 0) {
                            Etudiant etu = zone.getListEtu().get(i);
                            etu.combat();
                            flag = zone.isControlee();
                        }
                    }

                    if (this.joueurs.get(0).getListZoneControlee().size() >= 3) {
                        drapeau = 1;
                        break;
                    } else if (this.joueurs.get(1).getListZoneControlee().size() >= 3) {
                        drapeau = 2;
                        break;
                    } else {
                        if (flag == 1) {
                            System.out.println("Now please let joueur " + flag + " to affect his students to other zones\n");
                            treveWinner(zone, flag);
                            treveRes();
                        } else if (flag == 2) {
                            System.out.println("Now please let joueur " + flag + " to affect his students to other zones\n");
                            treveWinner(zone, flag);
                            treveRes();
                        }
                    }
                }
            }
        }

    }

    public void treveWinner(Zone zone, int flag) {
        System.out.println("Now it's the treve, the winner should move his students,please keep at least one student in this zone\n");
        zone.afficherZone();
        int quantity = 0;
        for (Etudiant et : zone.getListEtu()) {
            if (et.getEcts() > 0) {
                et.afficherEtu();
                quantity++;
            }
        }
        System.out.println("You should choose a student from 0~" + (quantity - 1) + "to stay in this zone\n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while (input > quantity - 1) {
            System.out.println("The input is out of range, try to input again\n");
            input = sc.nextInt();
        }

        for (int i = 0; i < quantity; i++) {
            if (i != input) zone.getListEtu().get(i).deplacerZoneTreve();

        }
        System.out.println("Now the player " + flag + " has finished moving his students from the zone controlled\n");

    }


    public void treveRes() {
        System.out.println("Now we want to put the reservistes into the zones not controlled\n");
        int oneneed;
        int twoneed;
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1 do you want to add a reserviste to the zones not controlled ? If yes, input 1. If no, input 0\n");
        oneneed = scan.nextInt();
        while (oneneed != 0 && oneneed != 1) {
            oneneed = scan.nextInt();
            System.out.println("range error, Please input a number 0 or 1");
        }
        int sum1 = 0, sum2 = 0;

        while (oneneed == 1 && sum1 < 5) {
            for (Etudiant res : this.joueurs.get(0).getListReserv()) {
                System.out.println("This is the reserviste that you want to put ? please answer y/n.\n");
                res.afficherEtu();
                String str = scan.next();
                if (str == "y") {
                    res.placerZoneReserviste();
                    sum1++;
                }

            }
        }

        System.out.println("Player 2 do you want to add a reserviste to the zones not controlled ? If yes, input 1. If no, input 0\n");
        twoneed = scan.nextInt();
        while (twoneed != 0 && twoneed != 1) {
            twoneed = scan.nextInt();
            System.out.println("range error, Please input a number 0 or 1");
        }
        while (twoneed == 1 && sum2 < 5) {
            for (Etudiant res : this.joueurs.get(0).getListReserv()) {
                System.out.println("This is the reserviste that you want to put ? please answer y/n.\n");
                res.afficherEtu();
                String str = scan.next();
                if (str == "y") {
                    res.placerZoneReserviste();
                    sum2++;
                }

            }
        }
    }


    public ArrayList<Zone> getListZone() {
        return this.zones;
    }

    public ArrayList<Joueur> getListJoueur() {
        return this.joueurs;
    }
}
