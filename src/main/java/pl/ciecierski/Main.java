package pl.ciecierski;


import pl.ciecierski.model.Level;
import pl.ciecierski.view.*;

//import java.util.ArrayList;
//import java.util.List;

public class Main {

//    public static final int height=40, weight=40;
//    public static final Level level=Level.HARD;

    public static final int height=90, weight=90;
    public static final Level level=Level.IMPOSSIBLE47;
    public static final int quantity=90;


 /* minimum 3 7
     45 185
    .43 extreme
    .3 hard
    .1 easy
  */

    public static void main(String[] args) {

//        height = Integer.parseInt(args[0]);
//        weight = Integer.parseInt(args[1]);
//        level = Level.valueOf(args[2]);
//        quantity = Integer.parseInt(args[3]);



        /*
        lista parametrów
        h wysokość labiryntu
        w szerkosc labiryntu
        level poziom trudnosci
        ilosc labiryntow do wyprodukowania
         */




//generuje losowy labirynt, umieszcza w pliku, w pliku JSON, wystawia API i pokazuje na ekranie


//        1. generuje i pokazuje na ekranie
       // new ViewFromRandom().show();

//        2. generuje losowy labirynt, serializuje do pliku, deserializuje i pokazuje na ekrnie
//        pokazuje na ekranie labirynt z pliku
//        new pl.ciecierski.view.ViewFromFile().show();
//

//        3. generuje losowy labirynt serializuje JSONa do pliku, deserializuje z JSONa
//        pokazuje na ekranie labirynt z JSONa z pliku
       new ViewFromJSON().show();

//        4.pokazuje na ekranie labirynt z API
//        new ViewFromAPI().show(int height, int weight);

    }
}
