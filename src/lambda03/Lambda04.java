package lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        List<Univercity> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println(hukukAra(unv));
        System.out.println(bKSirala(unv));

    }

    // Task 02--> Tum universitelerin notOrt'larinin 74'den buyuk olup,olmadigini kontrol eden methodu yaziniz

    public static boolean notOrt74BykUnv(List<Univercity> unv) {
        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }

    // Task 02--> Universite'lerde herhangi birinde "hukuk" olup olmadigini  kontrol eden method yaziniz

    public static boolean hukukAra(List<Univercity> unv) {

        return unv.
                stream().
                anyMatch(t -> t.getBolum().
                        contains("Hukuk"));
    }

    // Task 03--> Universite'leri ogr sayilarina gore b -> k siralayiniz.

    public static List bKSirala(List<Univercity> unv) {

        return unv.
                stream().
                sorted(Comparator.comparing(Univercity::getOgrSayisi).reversed()).
                collect(Collectors.toList());

    }

}
