package com.company;

import javax.imageio.ImageReader;

public class NumereAleatoare {

//ATENTIE!!! Am definit doua functii de generare aleatoare a unui numar intreg intre doua limite date Minim respectiv Maxim:
//    genereazaIntegerIntre(int a, int b) care face exact asta: intoarce un intreg dintre cel mai mic dintre a si b si cel mai mare dintre a si b
//    genereazaIntegerPozitivIntre(int a, int b) care arunca semnul lui a si b si genereaza un numar aleator intre modulele lor.

    public static void main(String[] args) {
        int Minim = 100, Maxim = 200;
        System.out.println("Un numar subunitar aleator: " + genereazaDoubleSubunitar()+ "\n");
        System.out.println("Un numar intreg ales aleator intre 0 inclusiv si " + Minim + " inclusiv: " + genereazaIntegerMaiMicSauEgalCu(Minim)+ "\n");
        System.out.println("Numarul tau norocos generat aleator dintre " + Minim + " si " + Maxim + " este: "+ genereazaIntegerPozitivIntre(Minim, Maxim)+ "\n");
        System.out.println("Numarul tau norocos generat aleator este: "+ genereazaIntegerPozitivIntre(-100, 200)+ "\n");
        System.out.println("Numarul tau norocos generat aleator este: "+ genereazaIntegerPozitivIntre(100, -100)+ ". Nicio surpriza aici.\n");

        //Se genereaza varsta unei persoane. Afisam daca este pensionar. Daca nu este, afisam cati ani ii raman pana la 65.
        System.out.println("****************************");
        int varsta = genereazaIntegerMaiMicSauEgalCu(120);
        System.out.println("Varsta persoanei este " + varsta +  ((varsta >= 65) ? " si este pensionar." : " si nu este pensionar."));
        boolean estePensionat = ( (varsta >= 65) ? true : false );
        if( !estePensionat ){
            System.out.println("Mai are " + (65 - varsta) + " ani pana la pensie.");
        }

        //Se genereaza aleator doua numere cuprinse intre Minim si Maxim. Se afiseaza rezultatul compararii.
        System.out.println("****************************");
        int primulNumar = genereazaIntegerIntre(Minim, Maxim);
        int alDoileaNumar = genereazaIntegerIntre(Minim, Maxim);
        int minimulCelorDouaNumere = minimulNumerelor(primulNumar, alDoileaNumar);
        int maximulCelorDouaNumere = maximulNumerelor(primulNumar, alDoileaNumar);
        System.out.println("Numerele generate aleator sunt: " + primulNumar + " si " + alDoileaNumar + ".");
        System.out.println("Numarul " + maximulCelorDouaNumere + " este mai mare decat " + minimulCelorDouaNumere);

        //Se genereaza aleator lungimile catetelor. Se afiseaza ipotenuza.
        System.out.println("****************************");
        int primaCateta = genereazaIntegerMaiMicSauEgalCu(100);
        int aDouaCateta = genereazaIntegerMaiMicSauEgalCu(100);
        System.out.println("Catetele au lungimile " + primaCateta + " respectiv " + aDouaCateta +
                " iar ipotenuza este de " + cuDouaZecimale(ipotenuzaEste(primaCateta, aDouaCateta)));

        //Se genereaza un intreg si se afiseaza daca este divizivil la 2, 3 sau 5
        System.out.println("****************************");
        int intregGeneratAleator = genereazaIntegerMaiMicSauEgalCu(Integer.MAX_VALUE);
        System.out.println("Numarul este " + intregGeneratAleator + " si ");
        System.out.println(esteDivizibilLa(intregGeneratAleator, 2) ? "este divizibil la 2." : "nu este divizibil la 2.");
        System.out.println(esteDivizibilLa(intregGeneratAleator, 3) ? "este divizibil la 3." : "nu este divizibil la 3.");
        System.out.println(esteDivizibilLa(intregGeneratAleator, 5) ? "este divizibil la 5." : "nu este divizibil la 5.");

        //Se genereaza aleator culoarea semaforului
        System.out.println("****************************");
        String[] culoareSemafor = {"verde", "galben", "rosu"};
        int numarCuloareSemafor = genereazaIntegerIntre(0,2);
        System.out.println("Acum semaforul are culoarea " + culoareSemafor[numarCuloareSemafor]);

        //Se genereaza numere de doua cifre si observam chestii
        System.out.println("****************************");
        int numarDouaCifre = genereazaIntegerIntre(10,99);
        int cifraUnitatilor = numarDouaCifre % 10;
        int cifraZecilor = numarDouaCifre / 10;
        System.out.println("Am extras numarul " + numarDouaCifre);
        int diferentaCifrelor = cifraZecilor - cifraUnitatilor;
        switch (diferentaCifrelor){
            case -1:
                System.out.println("Ai noroc! Cifra zecilor este cu o unitate mai mica decat cifra unitatilor!");
                break;
            case 0:
                System.out.println("Ai noroc! Cifra zecilor este egala cu cifra unitatilor!");
                break;
            case 1:
                System.out.println("Ai noroc! Cifra zecilor este cu o unitate mai mare decat cifra unitatilor!");
                break;
            default:
                System.out.println("Ai noroc! Numarul tau este par sau impar!");
                break;
        }

        //Genereaza CNP
        System.out.println("****************************");
        //genereaza sex
        int sex;
        if (dauCuBanul()){
            if(dauCuBanul()){
                sex = 1;
            }else{
                sex = 5;
            }
        }else{
            if(dauCuBanul()){
                sex = 2;
            }else{
                sex = 6;
            }
        }

        //genereaza an, luna, zi, restul celor sase cifre
        int anNastere = genereazaIntegerIntre(00,99);
        int lunaNastere = genereazaIntegerIntre(1,12);
        int ziNastere = genereazaIntegerIntre(1, zileInLuna(lunaNastere, anNastere));
        String restulDeSaseCifre = numarCaSir(genereazaIntegerMaiMicSauEgalCu(999999), 6);
        //Salveaza CNP-ul generat si afiseaza-l
        String cnp = String.valueOf(sex) +
                numarCaSir(anNastere,2) +
                numarCaSir(lunaNastere,2)+
                numarCaSir(ziNastere,2)+
                restulDeSaseCifre;
        System.out.println("Desi este putin legal, noul tau CNP este: " + cnp + "\nSucces!!");


        //Folosim CNP-ul generat aleator pentru a afisa cateva date suplimentare despre client
        System.out.println("****************************");
        String sexDinCnp = cnp.substring(0,1);
        String sexulPersoanei = ( "1526".indexOf(sexDinCnp) < 2 ? "Masculin" : "Feminin");

        int anDinCnp = Integer.parseInt(cnp.substring(1,3));
        int anIntreg = (anDinCnp < 22 ? anDinCnp + 2000 : anDinCnp + 1900);
        String mesaj =  ( esteAnBisect(anIntreg) ? "A fost an bisect. Felicitari!" : "N-a fost an bisect. Imi pare rau!");

        int lunaDinCnp = Integer.parseInt(cnp.substring(3,5));

        System.out.println("Cum ai CNP-ul " + cnp + " este clar ca esti de sex " + sexulPersoanei.toUpperCase() +
                " si te-ai nascut "+ anotimpulEste(lunaDinCnp).toUpperCase() +
                ". \nNu-ti dau 100 de ani asa ca sigur te-ai nascut in anul " + anIntreg +
                ". " + mesaj);

    }




    static double genereazaDoubleSubunitar(){
        //genereaza double in intervalul [0, 1) - inclusiv 0, exclusiv 1

        return Math.random();
    }

    static int genereazaIntegerMaiMicSauEgalCu(int maxim){
        // genereaza un intreg intre 1 si maxim, inclusiv 1, inclusiv maxim

        return (int)Math.floor(genereazaDoubleSubunitar() * maxim + 1);
    }

    
    static int genereazaIntegerPozitivIntre(int minim, int maxim){
        //  genereaza un intreg intre valorile absolute ale numerelor minim si maxim, inclusiv |minim|, inclusiv |maxim|
        int semnMinim = (minim <= 0) ? -1 : 1;
        int semnMaxim = (maxim <= 0) ? -1 : 1;
        if ( semnMinim < 0 || semnMaxim < 0){
            System.out.println("Ai introdus numerele " + minim + " si " + maxim + ".");
            minim *= semnMinim;
            maxim *= semnMaxim;
            System.out.println("A fost o mica eroare de citire. Argumentele trebuie sa fie pozitive." );
            System.out.println("Am presupus ca doresti sa folosim numerele " + minim + " respectiv "  + maxim );
        }
        return genereazaIntegerIntre(minim, maxim);
    }

    static int genereazaIntegerIntre(int minim, int maxim){
        //  genereaza un intreg intre minim si maxim, inclusiv minim, inclusiv maxim.
        //  Daca vreun numar este negativ, rezultatul poate fi negativ

        if( minim > maxim ) {
            int temp = minim;
            minim = maxim;
            maxim = temp;
        }

        // diff este un intreg cuprins intre 0 si ( maxim - minim )
        int diff = genereazaIntegerMaiMicSauEgalCu( maxim + 1 - minim ) -1;
        return minim + diff;
    }


    static int minimulNumerelor(int a, int b){
        //intoarce minimul a doua numere intregi
        return ( (a < b) ? a : b );
    }

    static int maximulNumerelor(int a, int b){
        //intoarce maximul a doua numere intregi
        return ( (a > b) ? a : b );
    }

    static double cuDouaZecimale(double x){
        //intoarce un double truncheat la doua zecimale exacte
        return Math.floor( x * 100) / 100;
    }

    static double patratulEste(double x){
        //intoarce patratul unui double
        return x*x;
    }

    static double ipotenuzaEste(double x, double y){
        //intoarce ipotenuza
        return Math.sqrt( patratulEste(x) + patratulEste(y));
    }

    static boolean esteDivizibilLa(int numar, int divizor){
        //intoarce true daca primul numar se divide la al doilea
        return ( (numar % divizor) == 0 ) ? true : false;
    }

    static boolean dauCuBanul(){
        if( genereazaDoubleSubunitar() < 0.5) {
            return false;
        };
        return true;
    }

    static boolean esteAnBisect(int an){
        if ( (an % 400 == 0)){
            return true;
        }else if( (an % 100 == 0) ) {
            return false;
        }
        else if ( (an % 4 ) == 0){
            return true;
        }
        return false;
    }

    static int zileInLuna(int luna, int an){
        int numarZile;
        switch(luna){
            case 2:
                numarZile = (esteAnBisect(an) ? 29 : 28);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numarZile = 30;
                break;
            default:
                numarZile = 31;
        }
        return numarZile;
    }

    static String numarCaSir(int numar, int numarCaractere){
        return String.format("%0" + numarCaractere + "d", numar);
    }

    static String anotimpulEste( int luna){
        switch (luna){
            case 12: case 1: case 2:
                return "iarna";
            case 3: case 4: case 5:
                return  "primavara";
            case 6: case 7: case 8:
                return "vara";
            default:
                return "toamna";
        }
    }
}
