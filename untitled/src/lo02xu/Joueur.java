package lo02xu;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    private int numJoueur;//the no. of the player
    private int points;//the total points to be affected to his 20 students
    private ArrayList<Etudiant> listEtu;//all the students that he has
    private ArrayList<Etudiant> listReserv;//all the reservists that he has
    private Filiere filiere;//maybe useless property, but the annexe of the project requires
    private String nomJoueur;//maybe useless
    private ArrayList<Zone> listZoneControlee;//the zone that this player has controlled(beat all the enemy in this zone)
    private Control control;//control panel

    public Joueur(int numJoueur, Control control) {//constructor
        this.numJoueur = numJoueur;//ID of the player

        this.listEtu = new ArrayList<Etudiant>();//opened to store the students that he has
        this.listReserv = new ArrayList<Etudiant>();// opened to store the reservists that he has
        this.listZoneControlee = new ArrayList<Zone>();//the zone that this player has controlled(beat all the enemy in this zone)
        this.nomJoueur = "Joueur" + this.numJoueur;//maybe useless
        this.points = 400;//each player has 400 points

        //configuration of the control panel
        this.control = control;
        control.getListJoueur().add(this);

        for (int i = 1; i < 16; i++) {
            Etudiant etu = new Etudiant(i, this);//normal students initialisation
        }

        for (int i = 16; i < 20; i++) {
            Etudiant etu1 = new EtudiantElite(i, this);//EtudiantElite initialisation
        }
        Etudiant etu2 = new MaitreDuGobi(20, this);//MaitreDuGobi initialisation

    }

    //getter and setter
    public int getNumJoueur() {
        return this.numJoueur;
    }

    public void setNumJoueur(int num) {
        this.numJoueur = num;
    }

    public Filiere getFiliere() {
        return this.filiere;
    }

    public void setFiliere(int index) {//set the player's filiere according to the index
        switch (index) {
            case 0 -> this.filiere = Filiere.ISI;
            case 1 -> this.filiere = Filiere.RT;
            case 2 -> this.filiere = Filiere.A2I;
            case 3 -> this.filiere = Filiere.GI;
            case 4 -> this.filiere = Filiere.GM;
            case 5 -> this.filiere = Filiere.MTE;
            case 6 -> this.filiere = Filiere.MM;
        }
    }

    //getter and setter
    public String getNomJoueur() {
        return this.nomJoueur;
    }

    public void setNomJoueur(String nom) {
        this.nomJoueur = nom;
    }

    public ArrayList<Etudiant> getListEtu() {
        return this.listEtu;
    }//get the list of the players for this player


    public ArrayList<Etudiant> getListReserv() {//get the list of the reservist for this player
        return this.listReserv;
    }

    public ArrayList<Zone> getListZoneControlee() {//get the list of the zone controlled by this player
        return this.listZoneControlee;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int point) {
        this.points = point;
    }

    public Control getControl() {
        return this.control;
    }

    public void setReserviste() {
        System.out.println("please input five numbers from 1-20 representing the students got reserved as a reserviste\n");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            //to set the reservist. We make the number input as the reservist
            int position = sc.nextInt() - 1;
            this.listEtu.get(position).addReserviste();
            this.listReserv.add(this.listEtu.get(position));
        }


    }

    public void choisirFiliere(int index) {
        System.out.println("Please input the index of the filiere\n");
        System.out.println("0,ISI. 1,RT. 2,A2I. 3,GI. 4,GM, 5,MTE. 6,MM");
        Scanner sc = new Scanner(System.in);
        index = sc.nextInt();

        //error control. To avoid illegal input
        while (index != 0 || index != 1 || index != 2 || index != 3 || index != 4 || index != 5 || index != 5 || index != 6) {
            System.out.println("Please input again, between 0-6\n");
            index = sc.nextInt();

        }
        this.setFiliere(index);
    }


   //to judge if this student has won the game.
    public boolean gagneOuPas() {
        boolean boo = false;
        if (this.listZoneControlee.size() >= 3) boo = true;
        return boo;

    }
}
