package lo02xu;

import java.util.Comparator;
import java.util.Scanner;

public class Etudiant {
    private int numEtu;//the no. of student
    private int ects;// the life value of student
    private int dexterite; // the 5 from dexterite to initiative is the property for fight
    private int force;
    private int resistance;
    private int constitution;
    private int initiative; //the 5 from dexterite to initiative is the property for fight
    private Strategie strategie; // decide to attack enermy or cure the mates
    private boolean reserviste;// to set 5, who does not participate in the combat

    //private Strategie strategie;
    private Zone zone; //
    private Filiere filiere; // to identify it belongs to which player
    private Joueur joueur; // one player has 30 students(including the etudiantelite and the maitre du gobi)

    public Etudiant(int numEtu, Joueur joueur) {
        this.ects = 30; //student has 30 points of life
        this.dexterite = 0; // set to 0 at first
        this.force = 0; // set to 0
        this.resistance = 0; //set to 0
        this.constitution = 0; //set to 0
        this.initiative = 0; //set to 0

        this.numEtu = numEtu; //the class Joueur give numEtu from 0 to 20 to the object of this class

        this.joueur = joueur;
        this.joueur.getListEtu().add(this);//to put the etudiant into the object joueur

        this.reserviste = false; // the phase initialisation set all students to combattant

    }


    public static final Comparator<Etudiant> comparatorInitiative = new Comparator<Etudiant>() {
        public int compare(Etudiant e1, Etudiant e2) {
            return e2.getInitiative() - e1.getInitiative();
        } //to compare the initiative of every student
    };
    public static final Comparator<Etudiant> comparatorEcts = new Comparator<Etudiant>() {
        public int compare(Etudiant e1, Etudiant e2) {
            return e1.getEcts() - e2.getEcts();
        } // to compare the ects of every student
    };

    //getter and setter
    public int getEcts() {
        return this.ects;
    }

    public void setEcts(int Ects) {
        this.ects = Ects;
    }

    public int getDexterite() {
        return this.dexterite;
    }

    public void setDexterite(int Dexterite) {
        this.dexterite = Dexterite;
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int Force) {
        this.force = Force;
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setResistance(int Resistance) {
        this.resistance = Resistance;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public void setConstitution(int Constitution) {
        this.constitution = Constitution;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public void setInitiative(int Initiative) {
        this.initiative = Initiative;
    }

    //public Strategie getStrategie() {
//	return this.strategie;
//}
//public void setStrategie(Strategie strat) {
//	this.strategie=strat;
//}
    public Zone getZone() {
        return this.zone;
    }

    public void setZone(Zone zo) {
        this.zone = zo;
    }

    public Filiere getFiliere() {
        return this.filiere;
    }

    public void setFiliere(Filiere fil) {
        this.filiere = fil;
    }

    public int getNumEtu() {
        return this.numEtu;
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    //getter and setter, about the property reservist
    public boolean isReserviste() {
        return this.reserviste;
    }

    public void addReserviste() {
        this.reserviste = true;
    }


    public String afficherEtu() {
        //to display the features of this student.
        StringBuffer sb = new StringBuffer();
        sb.append("the student " + this.numEtu + " of filiere " + this.filiere + this.joueur + " has\n");
        sb.append(this.ects + " ects\n");
        sb.append(this.force + " force\n");
        sb.append(this.dexterite + " dexterite\n");
        sb.append(this.resistance + " resistance\n");
        sb.append(this.constitution + " constitution\n");
        sb.append(this.initiative).append(" initiative\n");
        sb.append("in the zone ").append(this.zone).append("\n");
        return sb.toString();
    }


    public void modifierDataEtu() {//to change the property of a student, whether add or minus
        System.out.print("---Now you need to initialize the student" + this.numEtu + "---\n");
        System.out.print("the force, dex, res, init are between 0 and 10, the constitution is between 0 and 30\n");
        System.out.print("you should input the right statistic for the propreties\n");
        int forceIn;
        int dexIn;
        int resIn;
        int consIn;
        int initIn; //variables storing input values
        int error = 1;//use it as a sign to jump out from the loop
        while (error == 1) {
            Scanner scan = new Scanner(System.in);
            forceIn = scan.nextInt();
            dexIn = scan.nextInt();
            resIn = scan.nextInt();
            consIn = scan.nextInt();
            initIn = scan.nextInt();

            //here we use plenty of "nested IF ELSE", just to make sure that all the input is legal(obey the rules of the game)

            if (forceIn >= 0 && forceIn <= 10) {
                if (dexIn >= 0 && dexIn <= 10) {
                    if (resIn >= 0 && resIn <= 10) {
                        if (consIn >= 0 && consIn <= 30) {
                            if (initIn >= 0 && initIn <= 10) {
                                if (forceIn + dexIn + resIn + consIn + initIn <= this.joueur.getPoints()) {
                                    this.force = forceIn;
                                    this.dexterite = dexIn;
                                    this.resistance = resIn;
                                    this.constitution = consIn;
                                    this.ects += consIn - this.constitution;
                                    this.initiative = initIn;
                                    error = 0;// jump out from the loop(same function as Break;)

                                } else
                                    System.out.println("Your total points affected to the student is higher than the points of Joueur.\n");//warnings shown to the player because all the ECTS of a player reach zero.
                            } else
                                System.out.println("initiative should be 0-10\n");//warnings shown to the player, because of the illegal input
                        } else System.out.println("constitution should be 0-30\n");//the same as above
                    } else System.out.println("resistance should be 0-10\n");//the same as above
                } else System.out.println("dexterite should be 0-10\n");//the same as above
            } else System.out.println("force should be 0-10\n");//the same as above
        }
    }

    public void choisirStrategie() {//choose the strategy for this student, so that the student can attack enemy or cure mate according to his property "strategy"
        System.out.println("Now you should choose a strategie for the student " + this.numEtu + "\n");
        System.out.println("input 0 for offensive, input 1 for defensive, input 2 for aleatoire\n");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();//to input a number 0 or 1, 0 means offensive, 1 means defensive;

        while (index != 0 && index != 1 && index != 3) {
            System.out.println("You should input a number 0, 1 or 2. The other is not allowed\n");
            index = sc.nextInt();
        }

        if (index == 0) {
            Offensive offensive = new Offensive();
            this.strategie = offensive;

        } else if (index == 1) {
            Defensive defensive = new Defensive();
            this.strategie = defensive;
        } else if (index == 2) {
            Aleatoire aleatoire = new Aleatoire();
            this.strategie = aleatoire;
        }

    }

    public void placerZoneIni() {//initialisation of this student's property "zone"
        System.out.println("You have to put student" + this.numEtu + "into the following zones\n");
        System.out.println("input 0 as Bibliotheque,\n");
        System.out.println("input 1 as BureauDesEtudiants,\n");
        System.out.println("input 2 as QuartierAdministratif,\n");
        System.out.println("input 3 as HallesIndustrielles,\n");
        System.out.println("input 4 as HalleSportive\n");

        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();

        while (index != 0 && index != 1 && index != 2 && index != 3 && index != 4) {
            System.out.println("You should input a number between 0,1,2,3,4\n");
            index = sc.nextInt();// in case the player inputs an illegal number.
        }
        if (this.reserviste == false) {
            this.zone = this.joueur.getControl().getListZone().get(index);
            this.zone.getListEtu().add(this);

            System.out.println("Student " + this.numEtu + "has been put into the zone +" + this.zone.getNomZone() + "\n");
        }

    }

    public void deplacerZoneTreve() {
        System.out.println("You have to put student" + this.numEtu + "into the following zones\n");
        System.out.println("input 0 as Bibliotheque,\n");
        System.out.println("input 1 as BureauDesEtudiants,\n");
        System.out.println("input 2 as QuartierAdministratif,\n");
        System.out.println("input 3 as HallesIndustrielles,\n");
        System.out.println("input 4 as HalleSportive\n");
        System.out.println("BUT caution, you are in zone " + this.zone + " , you should not choose this zone\n");

        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();

        while (index == this.zone.getIndexZone()) {
            System.out.println("you should not choose the zone where you were, please try another number");
            index = sc.nextInt();// error input prevention
        }
        while (this.joueur.getControl().getListZone().get(index).isControlee() == 1 || this.joueur.getControl().getListZone().get(index).isControlee() == 2) {
            System.out.println("The destination zone is controlled by your opponent. Please try another");
            index = sc.nextInt();// error input prevention
        }

        //to change the student's zone. It also needs to change the arraylist in the object zone.
        this.zone.getListEtu().remove(this);
        this.zone = this.joueur.getControl().getListZone().get(index);
        this.zone.getListEtu().add(this);

        System.out.println("Student " + this.numEtu + " has been replaced into the zone" + this.zone.getNomZone() + "\n");
    }


    public void combat() {
        this.strategie.combat(this);
    }//fight with enemy, or cure the mates.

    public void placerZoneReserviste() {
        System.out.println("You have to put reserviste" + this.numEtu + "into the following zones\n");
        System.out.println("input 0 as Bibliotheque,\n");
        System.out.println("input 1 as BureauDesEtudiants,\n");
        System.out.println("input 2 as QuartierAdministratif,\n");
        System.out.println("input 3 as HallesIndustrielles,\n");
        System.out.println("input 4 as HalleSportive\n");

        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();//input a number to decide the zone that this student reservist will be put into.

        while (index != 0 && index != 1 && index != 2 && index != 3 && index != 4) {
            System.out.println("You should input a number between 0,1,2,3,4\n");
            index = sc.nextInt();//error control
        }

        while (this.joueur.getControl().getListZone().get(index).isControlee() == 1 || this.joueur.getControl().getListZone().get(index).isControlee() == 2) {
            System.out.println("this zone is controlled, please choose another");
            index = sc.nextInt();//error control
        }

        //to change the zone of the "reservist student". It also needs to change the arraylist in the object zone.
        this.zone = this.joueur.getControl().getListZone().get(index);
        this.zone.getListEtu().add(this);
        this.reserviste = false;

        System.out.println("reserviste " + this.numEtu + "has been put into the zone +" + this.zone.getNomZone() + "\n");


    }
}
