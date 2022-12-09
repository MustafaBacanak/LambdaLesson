package lambda03;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
        TASK :
           fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
    */

    public static void main(String[] args) {

        Univercity u01 = new Univercity("Odtü", "Gemi-İnşaat", 890, 74);
        Univercity u02 = new Univercity("Bilkent", "Elektrik-Elektronik", 640, 96);
        Univercity u03 = new Univercity("İtü", "Endüstri Müh.", 358, 65);
        Univercity u04 = new Univercity("Hacettepe", "Tıp", 230, 88);
        Univercity u05 = new Univercity("Gazi", "Hukuk", 1540, 50);

        /*
            - Objelerden olusan bir ArrayList olusturduk ve data type olarak class ismi aldık.
            - Bizim elimizde univercity classindaki objeler var. (u01,u02,u03,u04,u05)
            - Bunlar üzerinden çalışmalar yapıcaz. Integer ya da String degerlerle degil.
         */

        List<Univercity> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println(hukukAra(unv));
        System.out.println(bKSirala(unv));
        System.out.println(matBolumSayisi(unv));
        System.out.println(notOrt(unv));
        System.out.println(enKucukNotOrt(unv));

    }

    // Task 01--> Tum universitelerin notOrt'larinin 74'den buyuk olup,olmadigini kontrol eden methodu yaziniz
    public static boolean notOrt74BykUnv(List<Univercity> unv) {

        return unv.
                stream(). // akıs --> u01,u02,u03,u04,u05
                allMatch(t -> t.getNotOrt() > 74); //allmatch() hepsini kontrol.Eder true-false dondurur.Method boolean
                                                   //getNotOrt() methodunu univercity classindan Enc. ile getirdik.
    }

    // Task 02--> Universite'lerde herhangi birinde "hukuk" olup olmadigini  kontrol eden method yaziniz
    public static boolean hukukAra(List<Univercity> unv) {

        return unv.
                stream().//Akıs basladı
                anyMatch(t -> t.getBolum().//getBolum() ile objelerin bolum isimleri alındı
                        toUpperCase().//Olası her ihtimale karsı kucuk harf yapıldı
                        contains("HUKUK"));//Aranan bolum icinde var mı diye kontrol edildi.
    }

    // Task 03--> Universite'leri ogr sayilarina gore buyukten kucuge doğru siralayiniz.
    public static List<Univercity> bKSirala(List<Univercity> unv) { //Uni'leri istedigi icin List<Univercity> yaptik

        return unv.
                stream().//akis saglandi
                sorted(Comparator.comparing(Univercity::getOgrSayisi).reversed()).//tersten siralama yapildi
                collect(Collectors.toList()); //Stream yapisi List yapisina donusturuldu

          // collect() ile Methodu list olarak olusturdugumuz icin, akisi Stream yapidan List yapiya cevirdik.
    }

    // Task 04--> "Hukuk" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi (List<Univercity> unv){

        return (int) unv. // count() methodu Long dondurur.O yuzden (int) yaparak type casting yapariz
                stream(). //akis basladi
                filter(t->t.getBolum().equalsIgnoreCase("Hukuk")).//Hukuk bolumu filtrelendi
                count();//count() methodu secilen degerin sayisini verir.
    }

    // Task 05--> Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt notOrt(List<Univercity> unv){

        return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(Univercity::getNotOrt).//akisin int ile devam edeceginden eminsek mapToInt kullaniriz.
                                                //mapToInt() ile kullanabilecegimiz yeni methodlar gelir.max()gibi
                max();//belirtilen degerler arasindan en buyugunu verir. Optional deger dondurur.
    }

    // Task 06--> Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt enKucukNotOrt(List<Univercity> unv){

        return unv.
                stream().
                filter(t->t.getOgrSayisi()<1050).
                mapToInt(Univercity::getNotOrt).
                min(); //belirtilen degerler arasindan en kucugunu verir. Optional dondurur.
    }

}
