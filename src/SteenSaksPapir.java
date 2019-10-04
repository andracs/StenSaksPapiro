/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 30/09/2019
 */

public class SteenSaksPapir {

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

    // TODO flereKampe() {}

}
