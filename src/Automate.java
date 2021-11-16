import java.io.Serializable;
import java.util.*;

public class Automate implements Serializable {

    private ArrayList<String> alphabet = new ArrayList<>();
    private ArrayList<Etat> etats = new ArrayList<>();
    private Etat etat_initial;
    private ArrayList<Etat> etats_finaux = new ArrayList<>();
    private ArrayList<Instruction> instructions = new ArrayList<>();
    // couleur
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
    //
  public Automate(){}


    public ArrayList<Etat> getEtats() {
        return etats;
    }

    public ArrayList<Etat> getEtats_finaux() {
        return etats_finaux;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    public Etat getEtat_initial() {
        return etat_initial;
    }

    public void setAlphabet(ArrayList<String> alphabet) {
        this.alphabet = alphabet;
    }

    public void setEtat_initial(Etat etat_initial) {
        this.etat_initial = etat_initial;
    }

    public void setEtats(ArrayList<Etat> etats) {
        this.etats = etats;
    }

    public void setEtats_finaux(ArrayList<Etat> etats_finaux) {
        this.etats_finaux = etats_finaux;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
    public Automate Construction() {
     Automate aut=new Automate();
        ArrayList<String> alphabet=new ArrayList<>();
        ArrayList<Etat> etats=new ArrayList<>();
        Etat etat_initial=new Etat("");
        ArrayList<Etat> etats_finaux=new ArrayList<>();
        ArrayList<Instruction> instructions=new ArrayList<>();

        Etat e, e1;
        String ch, a, ch1;
        int i = 0, j, t, in;

        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                    Construction d'un automate:                                                   " + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                                                                                                                  " + ANSI_RESET);

        System.out.println( "************************************************************* Alphabets  :  ************************************************  " + ANSI_RESET);
        System.out.println("");
        System.out.println("                   ***Tapez le nombre de l'alphabet de cet automate : ***  ");
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        for (i = 0; i < n; i++) {

            System.out.println("alphabet :" +( i+1));
            a = s.next();
           alphabet.add(a);
            System.out.println("");
        }
        System.out.println( "**************************************************************** Etats  :  ************************************************  " + ANSI_RESET);

        System.out.println("Tapez le nombre d'état ");
        n = s.nextInt();

        for (i = 0; i < n; i++) {
            System.out.println("Tapez le nom de l'etat   :");
            ch = s.next();
            System.out.println("Est-il final ? : ");
            System.out.println("");
            System.out.println("1- oui     -- tapez 1.");
            System.out.println("2- Non     -- tapez 2 .");

            j = s.nextInt();
            System.out.println("");
            if (j == 1)// etat final
            {
                e = new Etat(ch);
                e.setFin(true);
               etats.add(e);
             etats_finaux.add(e);

            }
            if (j == 2)  //etat non final
            {
                e = new Etat(ch);
               etats.add(e);
            }

        }
        System.out.println( "************************************************************* Etat initial  :  ************************************************  " + ANSI_RESET);

        System.out.println("Entrez le nom de l'etat initial");
        System.out.println("");
        ch = s.next();
        e = new Etat(ch);
        boolean trouv = false, stop = false;
        i = 0;
        while (stop == false) {
            while (i < etats.size()) {

                if (etats.get(i).getNm().equals(ch)) {
                    stop = true;
                    trouv = true;
                }
                i++;
            }
            if (stop == false) {
                System.out.println(" cet etat n'appartient pas a l'ensemble des etats ");
                System.out.println("veuillez ressaisir  le nom d'etat initial ");
                ch = s.next();
                i = 0;
            }
        }
        e.setNm(ch);
      etat_initial = e;
        System.out.println( "************************************************************* Instructions  :  ************************************************  " + ANSI_RESET);

        System.out.println(" veuillez Tapez le nombre d'instruction ");
        n = s.nextInt();
        Instruction ins = new Instruction();

        for (j = 0; j < n; j++) // pour chaque instruction
        { ins = new Instruction();
            System.out.println("Instruction " + (j + 1));
            System.out.println(" Tapez l'etat de depart : ");
            ch = s.next();
            e = new Etat(ch);
            trouv = false;
            stop = false;
            i = 0;
            while (stop == false) {
                while (i < etats.size()) {
                    if (etats.get(i).getNm().equals(ch)) {
                        stop = true;
                        trouv = true;
                    }
                    i++;
                }
                if (stop == false) {

                    System.out.println(" cet etat n'appartient pas a l'ensemble des etats ");
                    System.out.println("veuillez ressaisir  le nom d'etat initial ");
                    ch = s.next();
                    i = 0;
                }
            }
            while (i < etats.size()) {
                if (etats.get(i).getNm().equals(ch)) {
                    e = etats.get(i);
                }
                i++;
            }

            ins.setDepart(e);
            System.out.println(" Tapez l'etat d'arrivée : ");
            ch = s.next();
            e1 = new Etat(ch);
            trouv = false;
            stop = false;
            i = 0;
            while (stop == false) {
                while (i < etats.size()) {
                    if (etats.get(i).getNm().equals(ch)) {
                        trouv = true;
                        stop = true;
                    }
                    i++;
                }
                if (stop == false) {
                    System.out.println(" cet etat n'appartient pas a l'ensemble des etats ");
                    System.out.println("veuillez ressaisir  le nom d'etat initial ");
                    ch = s.next();
                    i = 0;
                }
            }
            i = 0;
            while (i < etats.size()) {
                if (etats.get(i).getNm().equals(ch)) {
                    e = etats.get(i);
                }
                i++;
            }
            ins.setArrive(e);
            System.out.println("Donnez l'alphabet de transitions : ");
            ch = s.next();
            ins.setAlph(ch);
            instructions.add(ins);

        }

     aut.setAlphabet(alphabet);
        aut.setEtat_initial(etat_initial);
        aut.setInstructions(instructions);
        aut.setEtats_finaux(etats_finaux);
        aut.setEtats(etats);

        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "                                            l'Automate est pret :                                                            " + ANSI_RESET);
  return aut;
    }
///////////////////////////////////////////////////***********

    public void afficher_aut() {
        System.out.println("************************** l'alphabet de cet automate est :  **********************  ");
        int i = 0;
        for (i = 0; i < this.alphabet.size(); i++) {
            System.out.print("  " + (i + 1)+" - ");
            System.out.println(this.alphabet.get(i));

        }
        System.out.println("**********************************l'etat initial est :  *************************** ");
        System.out.println(this.etat_initial.getNm());
        System.out.println(" *********************************l'ensemble des états est :***********************   ");
        i = 0;
        for (i = 0; i < this.etats.size(); i++) {
            System.out.println(this.etats.get(i).getNm());
        }
        System.out.println("*********************************** l'ensembles des état finaux  est****************:");

        i = 0;
        for (i = 0; i < this.etats_finaux.size(); i++) {
            System.out.println(this.etats_finaux.get(i).getNm());
        }
        System.out.println("*********************************** l'ensemble des Instructions  est :***************");

        i = 0;
        for (i = 0; i < this.instructions.size(); i++) {
            System.out.println(this.instructions.get(i).getDepart().getNm() +"  -> "+ this.instructions.get(i).getAlph()+" -> " + this.instructions.get(i).getArrive().getNm());
        }

    }
////////////////******************************/
public Automate deterministe()// transfromation en un automate  deterministe //lazem nsauvegardi les instructions kaml
{

    Automate a =new Automate();
    if(this.est_det()==false) {
        Stack<ArrayList<Etat>>pile =new Stack<>();
        Stack<ArrayList<Etat>>traite =new Stack<>();
        ArrayList<Instruction>sauv =new ArrayList<Instruction>();
        Stack<String> trans=new Stack<>(); // nkhabi fiha les alphabets de transitions
        ArrayList<ArrayList<Etat>> e=new ArrayList<>();
        ArrayList<Etat> ensemble=new ArrayList<Etat>();
        ArrayList<Etat> etat=new ArrayList<Etat>();
        boolean tr=false;
        ArrayList<Etat> fin=new ArrayList<Etat>();
        boolean yes = false,fin1=false,fin2=false;

        Etat p,depart,et1;
        p=this.etat_initial;
        int i=0,j=0,d=0,f=0,s = 0;
        String alph,ch1 ="",ch2="";
        Instruction ins;
        ensemble.add(p);
        pile.push(ensemble);
        traite.push(ensemble);
        ins=new Instruction();
        Etat et=new Etat(etat_initial.getNm());
        boolean ajout=false ;
        e.add(ensemble);
        while (pile.isEmpty()==false) // pour chaque ensemble d'etats
        {

            ArrayList<Etat> ens=new ArrayList<Etat>();

            ensemble=pile.pop();
            // ins.setDepart(new Etat(nom_etat(ensemble)));
            while (i<this.alphabet.size()) // pour chaque alphabet
            {
                ens=new ArrayList<Etat>();

                alph = this.alphabet.get(i);
                //j = 0;
                for(d=0;d<ensemble.size();d++) // pour chaque etat de l'ensemble
                {
                    depart=ensemble.get(d);
                    for (j = 0; j < this.instructions.size(); j++) //pour chaque instruction
                    {

                        if ((depart.getNm().equals(this.instructions.get(j).getDepart().getNm())) &&
                            (alph.equals(this.instructions.get(j).getAlph())))
                        { if(ens.contains(this.instructions.get(j).getArrive())==false)
                        {
                            ens.add(this.instructions.get(j).getArrive());
                        }
                            ajout=true;

                        }// ajouter l'etat à l'ensemble
                    }
                }

                if (ajout==true)
                {
                    Collections.sort(ens, new Comparator<Etat>() {

                        @Override
                        public int compare(Etat o1, Etat o2) {

                            return o1.compareTo(o2);
                        }

                    });

                    ins=new Instruction();

                    for (f = 0; f < ens.size(); f++)
                    {
                        ch1 = ch1 + ens.get(f).getNm();

                    }
                    // mettre une condition ajout bool
                    et=new Etat(ch1);

                    for (f = 0; f< ensemble.size(); f++)
                    {
                        ch2 = ch2 + ensemble.get(f).getNm();

                    }

                    et1 = new Etat(ch2);
                    ins.setDepart(et1);
                    ins.setArrive(et);
                    ins.setAlph(alph);
                    ch2="";
                    ajout=false;


                    sauv.add(ins);

                    for(f=0;f<e.size();f++)
                    {
                        for(d=0;d<e.get(f).size();d++)
                        {
                            ch2=ch2+e.get(f).get(d).getNm();
                        }
                        if(ch2.equals(ch1)==true)
                        {
                            tr=true;
                        }
                        ch2="";
                    }

                    // if (e.contains(ens)==false)
                    if(tr==false)
                    {

                        e.add(ens);
                        pile.push(ens);
                        traite.push(ens);
                    }
                    ch1 = "";
                    ch2="";
                    tr=false;
                }

                i++;
            }
            i=0;}

        //sauvegarder les etats;
        for(i=0;i< e.size();i++)
        {
            et=new Etat("");

            for (j=0;j<e.get(i).size();j++)
            {
                ch1=ch1+e.get(i).get(j).getNm();
                if(e.get(i).get(j).isFin()==true)
                {
                    et.setFin(true);yes=true;
                }
            }
            et.setNm(ch1);
            ch1="";
            if(yes==true)
            {
                fin.add(et);
            }
            yes=false;
            etat.add(et);

        }
        //mettre a fin les instruction
        for(i=0;i<sauv.size();i++)
        {
            for(j=0;j<fin.size();j++)
            {
                if(sauv.get(i).getDepart().getNm().equals(fin.get(j).getNm()))
                {
                    sauv.get(i).getDepart().setFin(true);
                }
                if(sauv.get(i).getArrive().getNm().equals(fin.get(j).getNm()))
                {
                    sauv.get(i).getArrive().setFin(true);
                }
            }
        }
        a.setEtats(etat);
        a.setEtats_finaux(fin);
        a.setAlphabet(this.alphabet);
        a.setEtat_initial(this.etat_initial);
        a.setInstructions(sauv);

        return a;}
    else
    {
        System.out.println("cet automate est deja deterministe ! ");
        return this;
    }
}
    /////////////////////*********************
    public Automate deterministe_complet()// transfromation en un automate  deterministe complet//lazem nsauvegardi les instructions kaml
    {

            Automate a = new Automate();

            Stack<ArrayList<Etat>> pile = new Stack<>();
            Stack<ArrayList<Etat>> traite = new Stack<>();
            ArrayList<Instruction> sauv = new ArrayList<Instruction>();
            Stack<String> trans = new Stack<>(); // nkhabi fiha les alphabets de transitions
            ArrayList<ArrayList<Etat>> e = new ArrayList<>();
            ArrayList<Etat> ensemble = new ArrayList<Etat>();
            ArrayList<Etat> etat = new ArrayList<Etat>();

            ArrayList<Etat> fin = new ArrayList<Etat>();
            boolean yes = false;
            Etat p, depart, et1;
            p = this.etat_initial;
            int i = 0, j = 0, d = 0, f, s = 0;
            String alph, ch1 = "", ch2 = "";
            Instruction ins;
            ensemble.add(p);
            pile.push(ensemble);
            traite.push(ensemble);
            ins = new Instruction();
            Etat puit = new Etat("P");
            puit.setFin(false);
            Etat et = new Etat(etat_initial.getNm());
            boolean ajout = false;
            boolean pu = false;
            e.add(ensemble);
            while (pile.isEmpty() == false) // pour chaque ensemble d'etats
            {

                ArrayList<Etat> ens = new ArrayList<Etat>();

                ensemble = pile.pop();
                // ins.setDepart(new Etat(nom_etat(ensemble)));
                while (i < this.alphabet.size()) // pour chaque alphabet
                {
                    ens = new ArrayList<Etat>();

                    alph = this.alphabet.get(i);
                    //j = 0;
                    for (d = 0; d < ensemble.size(); d++) // pour chaque etat de l'ensemble
                    {
                        depart = ensemble.get(d);
                        for (j = 0; j < this.instructions.size(); j++) //pour chaque instruction
                        {

                            if ((depart.getNm().equals(this.instructions.get(j).getDepart().getNm())) &&
                                    (alph.equals(this.instructions.get(j).getAlph()))) {
                                if (ens.contains(this.instructions.get(j).getArrive()) == false) {
                                    ens.add(this.instructions.get(j).getArrive());
                                }
                                ajout = true;

                            }// ajouter l'etat à l'ensemble
                        }
                    }

                    if (ajout == true) {
                        Collections.sort(ens, new Comparator<Etat>() {

                            @Override
                            public int compare(Etat o1, Etat o2) {

                                return o1.compareTo(o2);
                            }

                        });

                        ins = new Instruction();

                        for (f = 0; f < ens.size(); f++) {
                            ch1 = ch1 + ens.get(f).getNm();
                        }
                        // mettre une condition ajout bool
                        et = new Etat(ch1);

                        ch1 = "";
                        for (f = 0; f < ensemble.size(); f++) {
                            ch2 = ch2 + ensemble.get(f).getNm();
                        }
                        et1 = new Etat(ch2);
                        ins.setDepart(et1);
                        ins.setArrive(et);
                        ins.setAlph(alph);
                        ch2 = "";
                        ajout = false;
                        sauv.add(ins);

                        if (e.contains(ens) == false) {

                            e.add(ens);
                            pile.push(ens);
                            traite.push(ens);
                        }
                    } else //ajouter un état puit
                    {
                        pu = true;
                        ins = new Instruction();
                        for (f = 0; f < ensemble.size(); f++) {
                            ch2 = ch2 + ensemble.get(f).getNm();
                        }

                        et1 = new Etat(ch2);
                        ins.setDepart(et1);
                        ins.setArrive(puit);
                        ins.setAlph(alph);
                        ch2 = "";
                        sauv.add(ins);

                    }

                    i++;
                }
                i = 0;
            }

            //sauvegarder les etats;
            for (i = 0; i < e.size(); i++) {
                et = new Etat("");

                for (j = 0; j < e.get(i).size(); j++) {
                    ch1 = ch1 + e.get(i).get(j).getNm();
                    if (e.get(i).get(j).isFin() == true) {
                        et.setFin(true);
                        yes = true;
                    }
                }
                et.setNm(ch1);
                ch1 = "";
                if (yes == true) {
                    fin.add(et);
                }
                yes = false;
                etat.add(et);

            }
            if (pu == true)  //ajouter les transitions de l'etat puit
            {
                for (i = 0; i < this.alphabet.size(); i++) {
                    ins = new Instruction();
                    ins.setDepart(puit);
                    ins.setArrive(puit);
                    ins.setAlph(this.alphabet.get(i));
                    sauv.add(ins);
                }
                etat.add(puit);
            }
            a.setEtats(etat);
            a.setEtats_finaux(fin);
            a.setAlphabet(this.alphabet);
            a.setEtat_initial(this.etat_initial);
            a.setInstructions(sauv);

        return a;
    }
    ////////////////////**

    public Automate complementaire() // complémentaire de A
    { Automate a=new Automate();
    int i=0;
    Etat et;
    ArrayList<Etat> etat=new ArrayList<>();
    ArrayList<Etat> fin=new ArrayList<>();
        a.setEtat_initial(this.etat_initial);//garder le mm état initial

        for (i=0;i<this.etats.size();i++)
        {
            // System.out.println("hna te3 les finaux  ");
            if (this.etats.get(i).isFin()==false ) // les etats non finaux deviennent finaux
            {
                et=this.etats.get(i);
                et.setFin(true);
                fin.add(this.etats.get(i));
                etat.add(et);
            }
            else //etat final devient non final
                {
                    et=this.etats.get(i);
                    et.setFin(false);
                    etat.add(et);
            }
        }

        a.setAlphabet(this.getAlphabet());
        a.setEtats_finaux(fin);
        a.setEtats(etat);
        a.setInstructions(this.instructions);

       return a;

    }
    public Boolean est_det()
    {
        Boolean det=true;
        Etat depart;
        String alph;
        int i=0,j=0,cpt=0,d=0;
        for(i=0;i<this.etats.size();i++)  //pour chaque etat;
        {
            depart=this.etats.get(i);
            for(d=0;d<this.alphabet.size();d++) //pour chaque alphabet
            {
                alph=this.alphabet.get(d);
                for (j = 0; j < this.instructions.size(); j++) // pour chaque instruction
                {
                    if (depart.getNm().equals(this.instructions.get(j).getDepart().getNm())&&(alph.equals(this.instructions.get(j).getAlph())))
                    {
                        cpt++;
                    }
                    if(cpt>1)
                    {
                        det=false;
                    }
                }
                cpt=0;
            }
        }
        return det;

    }
    public boolean contain(ArrayList<Etat> list ,String e){
        int i=0;
        while (i<list.size()){
            if (list.get(i).getNm().equals(e)){
                return true;
            }
            i++;

        }
        return false;
    }


    public ArrayList<Etat> list_coacc(){
        ArrayList<Etat> list_etat_coacc=new ArrayList<>();
        /* recherche des etats coaccessibles */
        Etat e;
        boolean exist=true;
        int i=0,j=0;
        /* les etats finaux sont tous des etats coaccessibles */
        for (i=0;i<etats_finaux.size();i++){
            /*inserer les etats finaux dans la liste des etats coacc*/
            e=etats_finaux.get(i);
            list_etat_coacc.add(e);
        }
        while (exist){
            exist=false;
            while (j<instructions.size()){
                Etat Si=instructions.get(j).getDepart();
                Etat Sj=instructions.get(j).getArrive();

                if ((contain(list_etat_coacc,Sj.getNm()))&&(!(contain(list_etat_coacc,Si.getNm())))){
                    list_etat_coacc.add(Si);
                    exist=true;
                }
                j++;
            }
        }
        return list_etat_coacc;

    }



    public ArrayList<Etat> list_acc(){
        boolean exist=true;
        int i=0;
        ArrayList<Etat> list_etat_acc=new ArrayList<>();
        list_etat_acc.add(etat_initial);//initialiser la liste des etats accessibles par l'etat initial de l'automate qu'est accessible
        while (exist){
            exist=false;
            while (i<instructions.size()){
                Etat Si=instructions.get(i).getDepart();
                Etat Sj=instructions.get(i).getArrive();

                if ((contain(list_etat_acc,Si.getNm()))&&(!(contain(list_etat_acc,Sj.getNm())))){
                    list_etat_acc.add(Sj);
                    exist=true;
                }
                i++;
            }
        }
        return list_etat_acc;
    }






    public Automate automate_reduit()
    {

        int i=0,j=0,l=0,k=0;
        Automate a=new Automate();

        ArrayList<Instruction> list_instruction=new ArrayList<>();
        ArrayList<Etat> list_etats=new ArrayList<>();
        ArrayList<Etat> etats_fin=new ArrayList<>();
        ArrayList<Etat> list_etat_coacc= new ArrayList<>();

        ArrayList<Etat> list_etat_acc= new ArrayList<>();

        /* construire la nouvelle liste des etats: insersection de liste des etats accesssibles et listes des etats coaccessibles */
        list_etat_acc=list_acc();
        list_etat_coacc= list_coacc();

        for (i=0;i<list_etat_acc.size();i++){
            for (j=0;j<list_etat_coacc.size();j++){
                if (list_etat_coacc.get(j).getNm().equals(list_etat_acc.get(i).getNm())){
                    list_etats.add(list_etat_acc.get(i));


                }
            }
        }
        /* construire la listes des instructions de l'automate reduit */
        for (l=0;l<instructions.size();l++){
            Instruction ins=instructions.get(l);
            if ((contain(list_etats,ins.getDepart().getNm()))&&(contain(list_etats,ins.getArrive().getNm()))){
                list_instruction.add(ins);
            }
        }
        /*construire la liste de etats finaux*/
        i=0;
        for (k=0;k<list_etats.size();k++){
            for (i=0;i<etats_finaux.size();i++){
                if (list_etats.get(k).equals(etats_finaux.get(i))){
                    etats_fin.add(etats_finaux.get(i));

                }
            }
        }
        a.setEtat_initial(this.etat_initial);//garder le mm état initial
        a.setAlphabet(this.alphabet);//garder la mm liste d'alphabet
        a.setEtats_finaux(etats_fin);
        a.setEtats(list_etats);
        a.setInstructions(list_instruction);

        return a;
    }
    public Automate miroir(){
        Automate automate=new Automate();
        ArrayList<Etat> list_etat=new ArrayList<>();
        ArrayList<Instruction>list_instruction=new ArrayList<>();
        ArrayList<String> list_alph=new ArrayList<>();
        ArrayList<Etat> list_fin=new ArrayList<>();
        Etat etat_init;
        Etat ajou;
        Instruction ins;
        ajou=new Etat("new");
        list_etat=this.etats;

        int i=0,j=0;
        if (this.etats_finaux.size()==1)
        {

            for (i=0;i<this.etats.size();i++)
            {
                if (this.etats.get(i).isFin()==true)
                {
                    list_etat.get(i).setFin(false);
                }
            }
            /********inverser les transitions*******/
            for (i=0;i<instructions.size();i++){
                ins=new Instruction();
                ins.setDepart(instructions.get(i).getArrive());
                ins.setArrive(instructions.get(i).getDepart());
                ins.setAlph(instructions.get(i).getAlph());
                list_instruction.add(ins);


            }

            etat_init=this.etats_finaux.get(0);
            etat_init.setFin(false);
            list_fin.add(this.etat_initial);
            list_fin.get(0).setFin(true);
            automate.setAlphabet(this.alphabet);
        }
        else
        {
            for (i=0;i<this.etats.size();i++)
            {
                if (this.etats.get(i).isFin()==true)
                {
                    list_etat.get(i).setFin(false);
                }
                if(this.etats.get(i)==this.etat_initial){
                    list_etat.get(i).setFin(true);
                }
            }
            list_fin.add(this.etat_initial);

            for (i=0;i<instructions.size();i++)
            {
                ins = new Instruction();
                ins.setDepart(instructions.get(i).getArrive());
                ins.setArrive(instructions.get(i).getDepart());
                ins.setAlph(instructions.get(i).getAlph());
                list_instruction.add(ins);
            }

            ajou.setFin(false);
            for (i=0;i<this.etats_finaux.size();i++)
            {
                ins=new Instruction();

                ins.setAlph("eps");
                ins.setDepart(ajou);
                ins.setArrive(this.etats_finaux.get(i));
                list_instruction.add(ins);
            }
            etat_init=ajou;
            list_etat.add(ajou);
            automate.setAlphabet(this.alphabet);
            automate.getAlphabet().add("eps");

        }
        automate.setEtat_initial(etat_init);
        automate.setInstructions(list_instruction);
        automate.setEtats(list_etat);
        automate.setEtats_finaux(list_fin);

        return automate;
    }
    /****************************reconnaisance d'un mot ********************/
    public void reconnaisance_mot(String mot,boolean reconnai){

        ArrayList<Etat> chemin=new ArrayList<>();
        Automate a=new Automate();
        int i=0,j=0;
        reconnai=false;
        boolean det=false;
        boolean found=false;
        det=est_det();

        if (det==false){
            a=deterministe();
            //commancant la recherche par l'etat initial
            Etat e=a.etat_initial;
            chemin.add(e);
            while (i<mot.length()){

                String s=Character.toString(mot.charAt(i));

                for (j=0;j<a.instructions.size();j++){//trouvant les transtion de e

                    if (a.instructions.get(j).getDepart().getNm().equals(e.getNm())&&(a.instructions.get(j).getAlph().equals(s))&&(found==false)){
                        Etat Sj=a.instructions.get(j).getArrive();
                        if (i<mot.length()-1){
                            chemin.add(Sj);
                            found=true;
                            e=a.instructions.get(j).getArrive();
                        }
                        else {
                            if (contain(a.etats_finaux,Sj.getNm())==true){
                                chemin.add(Sj);
                                reconnai=true;
                            }
                            else {
                                reconnai=false;
                            }
                        }
                    }

                }
                found=false;

                i++;
            }
            if (reconnai==true){
                System.out.println("Le mot est reconnai par l'automate");

            }
            else {
                System.out.println("Le mot n'est pas reconnai par l'automate !!!!!!");
            }


        }
        else {
            //commancant la recherche par l'etat initial
            Etat e=this.etat_initial;
            chemin.add(e);
            while (i<mot.length()){

                String s=Character.toString(mot.charAt(i));

                for (j=0;j<instructions.size();j++){//trouvant les transtion de e

                    if (instructions.get(j).getDepart().getNm().equals(e.getNm())&&(instructions.get(j).getAlph().equals(s))&&(found==false)){
                        Etat Sj=instructions.get(j).getArrive();
                        if (i<mot.length()-1){
                            chemin.add(Sj);
                            found=true;
                            e=instructions.get(j).getArrive();
                        }
                        else {
                            if (this.etats_finaux.contains(Sj)){
                                chemin.add(Sj);
                                reconnai=true;
                            }
                            else {
                                reconnai=false;
                            }
                        }
                    }

                }
                found=false;

                i++;
            }
            if (reconnai==true){
                System.out.println("Le mot est reconnai par l'automate");

            }
            else {
                System.out.println("Le mot n'est pas reconnai par l'automate !!!!!!");
            }
        }
        /********** print le chemin reussi du mot *************/
        if (reconnai==true){
            System.out.println("Le chemin reussi est le suivant : ");
            for (i=0;i<chemin.size();i++){
                System.out.print(chemin.get(i).getNm()+" -> ");

            }
            System.out.print("fin de chemin");
        }

    }

}

