package lambda_practice.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        hepsiniYazdir(list);
        System.out.println();
        negatifYaz(list);
        System.out.println();
        ciftYaz(list);
        System.out.println();
        pozVeCift(list);
        System.out.println();
        pozVeyaCiftYaz(list);
        System.out.println();
        kareleriniYazdir(list);
        System.out.println();
        ciftKupYazdir(list);
        System.out.println();
        tekrarsizKare(list);
        System.out.println();
        elSirala(list);
        System.out.println();
        elTersSirala(list);
        System.out.println();
        pozKup5List(list);
        System.out.println("pozKare5DegilList =" + pozKare5DegilList(list));
        System.out.println("elToplam(list) = " + elToplam(list));
        System.out.println("elToplamReference(list) = " + elToplamReference(list));
        System.out.println("elToplamReferenceInt(list) = " + elToplamReferenceInt(list));
        pozElTop(list);
    }

    // S1: Listi aralarinda bosluk birakarak yazdiriniz

    public static void hepsiniYazdir(List<Integer>l){

        l.stream().forEach(t->System.out.print(t+" "));
    }
    // S2: Sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer>l){

        l.stream().filter(t->t<0).forEach(t-> System.out.print(t+" "));
    }
    // S3: Cift olanlardan yeni bir liste olustur
    public static void ciftYaz(List<Integer>l){

        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));

    }
    // S4: Pozitif ve çift olanları yazdırın

    public static void pozVeCift(List<Integer>l){

        l.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t+" "));
    }

    // S5: Pozitif veya cift olanlari yazdirin

    public static void pozVeyaCiftYaz(List<Integer>l){
        l.stream().filter(t->t>0 || t%2==0).forEach(t-> System.out.print(t+" "));

    }

    // S6: List'in elemanlarin karelerini aynı satırda bır bosluklu yazdıralim

    public static void kareleriniYazdir(List<Integer> l){

        l.stream().map(t-> t*t).forEach(t-> System.out.print(t+" "));

    }

    // S7: List'in cift elemanlarinin kup'lerini yazdirin

    public static void ciftKupYazdir(List<Integer>l){
        l.
                stream().
                filter(t->t%2==0).
                map(t->t*t*t).
                forEach(t-> System.out.print(t+" "));
    }

    // S8: listin elemanlarin karelerinden tekrarsiz yazdıralım

    public static void tekrarsizKare(List<Integer> l){

        l.stream().map(t->t*t).distinct().forEach(t-> System.out.print(t+" "));

    }
    // S9: Listin elemanlarini kucukten buyuge siralayin

    public static void elSirala(List<Integer>l){

        l.stream().sorted().forEach(t-> System.out.print(t+" "));
    }

    // S10: listin elemanlarini buyukten kucuge siralayalim

    public static void elTersSirala(List<Integer>l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

    public static void pozKup5List(List<Integer> l){
        List<Integer> list= l.stream().filter(t-> t>0).map(t->t*t*t).filter(t-> t%10==5).collect(Collectors.toList());
        System.out.println(list);

    }

    // S11: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayan yeni bir list olusturalim

    public static List<Integer> pozKare5DegilList(List<Integer> l){
        List<Integer> list =l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
        return list;
    }

    // S12 :list elemanlarini toplamini bulalim
    public static int elToplam(List<Integer>l){
        int i=l.stream().reduce(0,(x,y)->x+y);
        return i;
    }


    public static int elToplamReference(List<Integer>l){
        int i=l.stream().reduce(0,Math::addExact);
        return i;
    }

    public static int elToplamReferenceInt(List<Integer>l){
        int i=l.stream().reduce(0,Integer::sum);
        return i;
    }

    //S14 : Listin pozitif elemanları toplamını bulalım

    public static void pozElTop(List<Integer> l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));
    }




}