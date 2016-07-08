/*
* Ohjelma joka muuntaa roomalaisia numeroita arabialaisiksi
*
* Jenna Halmetoja,
* Avoin yliopisto, syksy 2013
*/
public class Roomalaiset {
    public static void main(String[] args){
        // esitell‰‰n roomalaisten numeroiden merkit vakioina.
        final char I = 'I';
        final char V = 'V';
        final char X = 'X';
        final char L = 'L';
        final char C = 'C';
        final char D = 'D';
        final char M = 'M';
        
        //vakioidaan virheilmoitus
        final String VIRHE = "Virhe!";

        //jatko- ja lopetuskomennukset.
        final char LOPETA = 'e';
        final char JATKA = 'k'; 
        
        //muuttuja johon luetaan roomalainen merkki.
        char roomalainen = ' ';
        String kokoRoomalainen = "";
        int edellinenLuku = 0;
        
        //muuttuja, jolla luetaan k‰ytt‰j‰n valinta jatkamisesta (k/e).
        char valinta;
        
        //muuttuja johon luetaan luvun pituus
        int pituus = 0;
        
        //muuttuja, jolla luetaan roomalaisen numeerinen arvo.
        int luku = 0;
        
        // Lopputulos.
        int arabialainen = 0;
        
        //lippumuuttujat, joiden avulla p‰‰tell‰‰n jatketaanko ja onko syˆte oikein.
        boolean jatketaan = false;
        boolean syoteOK = false;

        System.out.println("Moi! Muunnan roomalaisia arabialaisiksi.");
        
        // P‰‰silmukka.
        do {
            // Alusta tarvittavat muuttujat seuraavaa kierrosta varten.
            arabialainen = 0;
            luku = 0;
            pituus = 0;
            edellinenLuku = 0;
            kokoRoomalainen = "";
            
            //pyydet‰‰n k‰ytt‰j‰lt‰ luvun pituus,
           //niin kauan kuin pituus on 1-15
            do {
                System.out.println("Anna luvun pituus:");
                pituus = In.readInt();
                //jos pituus on alle 1 tai yli 15, tulostetaan virheilmoitus.
                if (pituus < 1 || pituus > 15)
                    System.out.println(VIRHE);
            }
            while (pituus < 1 || pituus > 15);
        
            //tulostetaan "anna _ luku: " niin kauan kuin i <= pituus
            //lis‰t‰‰n laskuria aina joka kierroksella yhdell‰
            for(int i = 1; i <= pituus; i++) {
                do {
                    //luetaan k‰ytt‰j‰lt‰ roomalainen luku.
                    System.out.println("Anna " + i + ". numero:");
                    roomalainen = In.readChar();
                
                    //jos annettu kirjain on roomalainen numero, asetetaan luku muuttujalle roomalaista lukua vastaava arabialainen.
                    if (roomalainen == I || roomalainen == V || roomalainen == X || roomalainen == L ||
                    roomalainen == C || roomalainen == D || roomalainen == M) {
                        if (roomalainen == M)
                            luku = 1000;
                        if (roomalainen == D)
                            luku = 500;
                        if (roomalainen == C)
                            luku = 100;
                        if (roomalainen == L)
                            luku = 50;
                        if (roomalainen == X)
                            luku = 10;
                        if (roomalainen == V)
                            luku = 5;
                        if (roomalainen == I)
                            luku = 1;
                        syoteOK = true;                    
                    }

                    //jos annettu merkki ei ole roomalainen luku, tulostetaan virheilmoitus.
                    else {
                        System.out.println(VIRHE);
                        syoteOK = false;  
                    }
                }
                while(!syoteOK);
                    
                // Liit‰ merkki roomalainen-muuttujaan.
                kokoRoomalainen += roomalainen;
                
                // v‰henn‰, jos edellinen arvo pienempi kuin nykyinen,
                if (edellinenLuku < luku)
                    arabialainen = arabialainen - edellinenLuku;

                // muussa tapauksessa lis‰‰
                else
                    arabialainen = arabialainen + edellinenLuku;
                
                // Muista edellisen kierroksen luku.
                edellinenLuku = luku;
            }
            // Lis‰‰ t‰ss‰ summaan viimeisen roomalaisen numeron arvo.
            arabialainen = arabialainen + edellinenLuku;
            
            //Tulostetaan lopputulos.
            System.out.println(kokoRoomalainen + " = " + arabialainen);

            //Silmukka, jossa p‰‰tell‰‰n halutaanko jatkaa vai ei.
            do {
                // Luetaan k‰ytt‰j‰n valinta
                System.out.println("Jatketaanko (" + JATKA + "/" + LOPETA + ")?");
                valinta = In.readChar();
                if (valinta != JATKA && valinta != LOPETA){
                    System.out.println(VIRHE);
                }
                // Asetetaan lippumuuttujan arvo.
                if (valinta == JATKA || valinta == LOPETA)
                    syoteOK = true;
                else
                    syoteOK = false;
                
            }
            //silmukkaa suoritetaan kunnes syote ei ole ok.
            while (!syoteOK);
             
            // Jos valinta on 'k', silloin jatketaan.
            if (valinta == JATKA){
                jatketaan = true;
            }
            
            //jos valinta on 'e', ohjelman suoritus lopetetaan.
            else
                jatketaan = false;
        }
        //p‰‰silmukkaa suoritetaan niin kauan kuin jatketaan-muuttujan arvo on tosi.
        while (jatketaan);
        
        // Tulostetaan lopputervehdys.
        System.out.println("Kiitokset - tavataan taas.");
    }
}