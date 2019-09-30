import java.util.Scanner;

/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 30/09/2019
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Sten saks papir 1.0");

        Haand kelvin = Haand.SAKS;
        Haand henrik = Haand.PAPIR;
        Haand mik = Haand.STEN;
        Haand andras = Haand.STEN;

        // Her starter spillet
        SteenSaksPapir runde1 = new SteenSaksPapir();
        // System.out.println(runde1.slaa(kelvin, mik));

        // Computer generere en hånd
        Haand computerensHaand = null;
        int haandInt =(int) (Math.random()*3+1);
        // Korte nørklet kode  computersHaand = Haand.values()[haandInt];
        if (haandInt == 1) { computerensHaand = Haand.STEN; }
        if (haandInt == 2) { computerensHaand = Haand.SAKS; }
        if (haandInt == 3) { computerensHaand = Haand.PAPIR; }
        System.out.println("Computer slår " + computerensHaand);

        // Indlæse spillerns hånd
        Scanner scanner = new Scanner(System.in);
        Haand spillerensHaand = null;
        String spillerenString = scanner.next();
        if (spillerenString.equals("sten")) { spillerensHaand = Haand.STEN; }
        if (spillerenString.equals("saks")) { spillerensHaand = Haand.SAKS; }
        if (spillerenString.equals("papir")) { spillerensHaand = Haand.PAPIR; }
        System.out.println("Spiller slår " + spillerensHaand);

        // Sammenligne med slaa() metoden
        int resultat = runde1.slaa(computerensHaand, spillerensHaand);

        // Udråbe en vinder
        System.out.println("Resultatet er " + resultat);
        // TODO vis resultatet mere meningsfuldt
    }

}
