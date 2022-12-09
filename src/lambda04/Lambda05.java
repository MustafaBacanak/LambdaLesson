package lambda04;

import lambda01.Lambda01;

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println("toplam = " + topla(5));
        System.out.println("toplaFunctional = " + toplaCincix(5));
        System.out.println("toplaCift = " + toplaCift(5));
        System.out.println("ilkPozitifCiftTop = " + ilkPozitifCiftTop(5));
        System.out.println("ilkPozitifTekTop() = " + ilkPozitifTekTop(5));
        ikininIlkXKuvvetPrint(5);
        istSayininXKuvveti(3,5);
        istSayininFaktoriyeli(5);

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar
    // (x dahil) tamsayilari toplayan bir program create ediniz.

    // Structured
    public static int topla(int x) {

        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;

        }
        return toplam;
    }

    // Functional
    public static int toplaCincix(int x) {  // List<Integer> x ---> x.stream().

        return IntStream. // int değerlerde bir akış sağlar
                range(1, x + 1). // range(a,b) --> a dan b'ye kadar ( b dahil değil) int değerler akısa alındı
                sum();// akışdan gelen değerler toplandı


    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {

        return IntStream.
                rangeClosed(1, x). // 1.ve 2. parametre dahil
                        filter(Lambda01::ciftBul). // Lambda01 classndan cift methodunu aldık
                        sum();

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program create ediniz.
    public static int ilkPozitifCiftTop(int x) {

//         1.Yol
//        return IntStream.
//                rangeClosed(1, x).
//                limit(x).
//                filter(t -> t % 2 == 0).
//                sum();

         //2.Yol
        return IntStream. // int akıs baslatır.
                iterate(2, t -> t + 2). // ilk parametreden baslar, belirtilen şekilde sonsuza kadar gider
                limit(x).// x değerine kadar gider (sınırlar)
                sum(); // toplar

    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkPozitifTekTop(int x) {

        return IntStream.
                iterate(1, t -> t + 2).
                limit(x).
                sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) { // 2,4,8,16,32

        IntStream.
                iterate( 2, t->t*2 ). // iterasyon için sartımızı yazdık
                limit(x). // x değeri ile sınırladık
                forEach(Lambda01::yazdir); //Lamnbda01 clasındaki yazdır() metodunu çağırarak ekrana yazdık
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istSayininXKuvveti (int istenenSayi,int x ){

        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(istenenSayi).
                forEach(Lambda01::yazdir);

    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static void istSayininFaktoriyeli (int istenenSayi){

//        IntStream.iterate(istenenSayi,t->t*(istenenSayi-1)).
//                limit(istenenSayi).
//                forEach(Lambda01::yazdir);

        IntStream.
                rangeClosed(1,istenenSayi).
                reduce(1,(t,u)->t*u);
    }
}
