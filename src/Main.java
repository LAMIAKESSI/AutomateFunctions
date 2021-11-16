import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void  main(String[] args) throws IOException, ClassNotFoundException {
       Automate a;
        ArrayList<String> alphabet=new ArrayList<>();
         ArrayList<Etat> etats=new ArrayList<>();
         Etat etat_initial=new Etat("");
         ArrayList<Etat> etats_finaux=new ArrayList<>();
         ArrayList<Instruction> instructions=new ArrayList<>();
        a=new Automate();
      /* Automate b=new Automate();

        Etat s0,s1,s2;
        Instruction i1,i2,i3,i4,i5;
        s0=new Etat("S0");        s1=new Etat("S1");        s2=new Etat("S2");
        s0.setFin(false); s1.setFin(false);s2.setFin(true);
        i1=new Instruction(); i1.setDepart(s0); i1.setArrive(s1);i1.setAlph("1");
        i2=new Instruction(); i2.setDepart(s0); i2.setArrive(s2);i2.setAlph("1");
        i3=new Instruction(); i3.setDepart(s1); i3.setArrive(s1);i3.setAlph("0");
        i4=new Instruction(); i4.setDepart(s1); i4.setArrive(s2);i4.setAlph("1");
        i5=new Instruction(); i5.setDepart(s2); i5.setArrive(s0);i5.setAlph("0");

        instructions.add(i1);
        instructions.add(i2);
        instructions.add(i3);
        instructions.add(i4);
        instructions.add(i5);

        etats.add(s1);        etats.add(s2);        etats.add(s0);
        etat_initial=s0;
        etats_finaux.add(s2);
        alphabet.add("0");alphabet.add("1");
        a.setAlphabet(alphabet);a.setEtats_finaux(etats_finaux);a.setEtats(etats);a.setInstructions(instructions);
        a.setEtat_initial(etat_initial);
    //    a.afficher_aut();

   b=   a.deterministe_complet();
   Automate c=new Automate();
   b.afficher_aut();
    c=    b.complementaire();
      c.afficher_aut();
      int i=0;
        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "This text has a green background and red text!" + ANSI_RESET);
*/
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "**********************************************************************************************************************************" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "**********************************************************************************************************************************" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "**********************************************************************************************************************************" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "******************************************************TP THP :MANIPULATION D'AUTOMATE*********************************************" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);

        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
        int sousmenu = 0;
        boolean arret = false;
        int n;
        Scanner s = new Scanner(System.in);

       // n = s.nextInt();
        while (!arret){
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                         MENU                                                                     " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      1--Construction : -Tapez 1                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      2--Deterministe : -Tapez 2                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      3--Deterministe-Complet : -Tapez 3                                          " + ANSI_RESET);

            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      4--Réduction : -Tapez 4                                                     " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);

            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      5--Mirroir : -Tapez 5                                                       " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      6--Complementaire : -Tapez 6                                                " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      7--Reconnaisnce d'un mot donné  -Tapez 7                                    " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      8--Afficher l'automate construit:  -Tapez 8                                 " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      9--Quitter:  -Tapez 9                                                       " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                      par: -Ketfi Raniya .                                                        " + ANSI_RESET);
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                           -Kessi Lamia .                                                         " + ANSI_RESET);

            Scanner keyboard = new Scanner(System.in);

            //   Scanner s = new Scanner(System.in);
            Automate b=new Automate();
            Automate c=new Automate();
            sousmenu = s.nextInt();
            switch(sousmenu)
            {
                 case 1 :
                     a=a.Construction();
                     //sauvegarder l'automate dans le fichier
                     ObjectOutputStream out;
                     ObjectInputStream in;
                     try{
                     out = new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(
                                             new File("sauv.txt"))));

                     out.writeObject(a);

                     out.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

                     break;
                case 2 :
                    //determniste :
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    c=b.deterministe();
                    c.afficher_aut();
                    keyboard.nextLine();

                    break;
                case 3 : //Deterministe Complet
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    c=b.deterministe_complet();
                    c.afficher_aut();
                    keyboard.nextLine();
                    break;
                case 4 : //Reduction d'un auttomate
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    c=b.automate_reduit();
                    c.afficher_aut();
                    keyboard.nextLine();
                    break;
                case 5 :
                    //mirroir
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    c=b.miroir();
                    c.afficher_aut();
                    keyboard.nextLine();
                    break;
                case 6 :
                    //complémentaire;
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    c=b.deterministe_complet();
                    c=c.complementaire();
                    c.afficher_aut();
                    keyboard.nextLine();
                    break;
                case 7 :
                    // reconnaisance d'un mot
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    boolean rec=false;
                    System.out.println("Donner le mot que vous voulez tester :");
                    Scanner s1 = new Scanner(System.in);
                    String mot=s1.next();
                    b.reconnaisance_mot(mot,rec);
                    keyboard.nextLine();

                    break;
                case 8 :
                    // affichage du fichiers :
                    in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauv.txt"))));
                    b=(Automate)in.readObject();
                    b.afficher_aut();
                    keyboard.nextLine();
                    break;


                case 9 : arret = true; break;
                default : System.out.println("entrez un choix entre 1 et 3"); break;
            }
        }


    }
}
