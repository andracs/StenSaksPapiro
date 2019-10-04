import java.util.Scanner;

/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 30/09/2019
 */

public class SteenSaksPapir {

    public static void startSpillet() {
        SteenSaksPapir runde1 = new SteenSaksPapir();

        int count = 1;
        while (count>=1) {
        // Indlæse spillerns hånd
        Scanner scanner = new Scanner(System.in);
        System.out.print("Runde " + count + " - hvad slår du (sten, saks, papir)? ");
        Haand spillerensHaand = null;
        String spillerenString = scanner.next();
        if (spillerenString.equalsIgnoreCase("sten")) { spillerensHaand = Haand.STEN; }
        if (spillerenString.equalsIgnoreCase("saks")) { spillerensHaand = Haand.SAKS; }
        if (spillerenString.equalsIgnoreCase("papir")) { spillerensHaand = Haand.PAPIR; }
        if (spillerenString.equalsIgnoreCase("afslut")) { break; }

            System.out.println("Spiller slår " + spillerensHaand);

        // Computer generere en hånd
        Haand computerensHaand = null;
        int haandInt =(int) (Math.random()*3+1);
        // Korte nørklet kode  computersHaand = Haand.values()[haandInt];
        if (haandInt == 1) { computerensHaand = Haand.STEN; }
        if (haandInt == 2) { computerensHaand = Haand.SAKS; }
        if (haandInt == 3) { computerensHaand = Haand.PAPIR; }
        System.out.println("Computer slår " + computerensHaand);

        // Sammenligne med slaa() metoden
        int resultat = runde1.slaa(spillerensHaand, computerensHaand);

        // Udråbe en vinder
        if (resultat==1) { System.out.println("Du har vundet!"); }
        if (resultat==2) { System.out.println("Du har tabt!"); }
        if (resultat==0) { System.out.println("Uafgjort :)"); }
        if (resultat==-1) { System.out.println("Der er sket en funky fejl, prøv igen!"); }

        count++;
        }
    }

    /** Hvis den første hånd vinder, returneres 1
     *  Hvis den anden hånd vinder, returneres 2
     *  Hvis uafgjort, returneres 0
     *  Hvis der er en fejl, så returnerer den -1 */
    int slaa(Haand a, Haand b) {

        int resultat = -1;
        // TODO refaktorer, så det bliver kortere med f.eks.
        //  if(a == Haand.STEN && b== Haand.STEN) { resultat = 0;}
        //  if(a == Haand.STEN && b== Haand.SAKS) { resultat = 1;}

        // første hånd sten
        if(a == Haand.STEN) {
            // anden hånd er sten
            if (b== Haand.STEN) { resultat = 0; }
            // anden hånd er saks
            if (b== Haand.SAKS) { resultat = 1; }
            // anden hånd er papir
            if (b== Haand.PAPIR) { resultat = 2; }
        }
        // første hånd saks
        if(a == Haand.SAKS) {
            // anden hånd er sten
            if (b== Haand.STEN) { resultat = 2; }
            // anden hånd er saks
            if (b== Haand.SAKS) { resultat = 0; }
            // anden hånd er papir
            if (b== Haand.PAPIR) { resultat = 1; }
        }
        // første hånd papir
        if(a == Haand.PAPIR) {
            // anden hånd er sten
            if (b== Haand.STEN) { resultat = 1; }
            // anden hånd er saks
            if (b== Haand.SAKS) { resultat = 2; }
            // anden hånd er papir
            if (b== Haand.PAPIR) { resultat = 0; }
        }

        return resultat;
    }
}
