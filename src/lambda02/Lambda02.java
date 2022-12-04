package lambda02;

import lambda01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("\n * * * ");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n * * * ");
        ciftKarekokPrint(sayi);
        System.out.println("\n * * * ");
        maxElBul(sayi);
        structuredMaxElBul(sayi);
        ciftEnBuyukElKaresi(sayi);
        tumElToplami(sayi);
        cifCarpim(sayi);
        enKucuk(sayi);
        bestenBykTekKucuk(sayi);
        ciftElKareKBSort(sayi);

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin karelerini
    //          ayni satirda aralarina bosluk bırakarak print ediniz.
    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul). //lambda01 classinda olusturdugumuz cift bulma methodunu cagirdik.
                map(t -> t * t). // Akıs icerisindeki elemanlari baska degerlere donusturur.(16,4,36)
                forEach(Lambda01::yazdir); //lambda01 classinda olusturdugumuz yazdir methodunu cagirdik.

    }

    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    //        ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 != 0).
                map(t -> (t * t * t) + 1).
                forEach(Lambda01::yazdir);

    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    //          karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz.
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). //double döndürür. O yüzden lambda01 classindan yazdir(int a) methodu kullanilmaz
                forEach(t -> System.out.print(String.format("%.2f", t) + " "));

    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); //Eger result tek bir deger ise reduce terminal opt. kullanilir.
        System.out.println(maxSayi);
    }

    // Structured kullanarak yapalim
    public static void structuredMaxElBul(List<Integer> sayi) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < sayi.size(); i++) {
            if (sayi.get(i) > max) {
                max = sayi.get(i);
            }
        }
        System.out.println("En buyuk sayi :" + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftEnBuyukElKaresi(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//Math::max e gore daha hizli calisir.
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void tumElToplami(List<Integer> sayi) {
        int toplam = sayi.
                stream().
                reduce(0, (a, b) -> a + b);
        System.out.println("toplam = " + toplam);
    /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
          bu örnekte 0 oluyor
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır
    */
}

    // Task-7: List'teki cift elemanlarin carpimini yazdiriniz.
    public static void cifCarpim(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void enKucuk(List<Integer> sayi) {

        //1.Yol : Method Referance
        System.out.println(sayi.
                stream().
                reduce(Integer::min));//Math::min

        //2.Yol : Method Referance
        System.out.println(sayi.
                stream().
                reduce(Lambda02::minSayi));

    }

    public static int minSayi(int x, int y) {

        return x < y ? x : y;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykTekKucuk(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(t -> (t % 2 == 1) && (t > 5)).
                reduce(Lambda02::minSayi));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftElKareKBSort(List<Integer> sayi) {
        sayi.
                stream(). // Akisi baslattik.
                filter(Lambda01::ciftBul). // Akis icinde cift sayilari aldik.
                map(t -> t * t). // Sayilarin karesini alarak yeni bir akis olusturduk.
                sorted(). // Akistaki sayilari kucukten buyuge siralama yaptik.
                forEach(Lambda01::yazdir); // Akistaki sayilari ekrana yazdirdik.

    }

}
