import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println(longestPodciag("ananas")); //3 nas
        System.out.println(longestPodciag("ananasik")); //5 nasik


    }

    public static int[] mergeTwoArraysAndSort(int[] arr1, int[] arr2) {

        //Inicjalizacja trzech wskaźników: i dla arr1, j dla arr2 oraz k dla merged.

        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;


        /*
        Dopóki któraś z tablic się nie skończy to lecimy z pętlą
        Jeśli arr1[i] jest mniejsze niż arr2[j], to przypisujemy arr1[i] do merged[k], zwiększamy i o 1 i zwiększamy k o 1.
        W przeciwnym przypadku (gdy arr2[j] jest mniejsze lub równe arr1[i]), przypisujemy arr2[j] do merged[k], zwiększamy j o 1 i zwiększamy k o 1.
        Następnie przechodzimy do kolejnego porównania.

        W sumie to wykonaliśmy tu merge sorta, algorytm porównuje kolejne elementy z obu tablic i wstawia je w odpowiedniej kolejności do tablicy wynikowej
         */
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }


        // pętla sprawdza, czy są jeszcze elementy w arr1. Jeśli tak, przypisuje je do merged[k], zwiększa 'i' oraz 'k' o 1.
        while (i < arr1.length) {
            merged[k] = arr1[i];
            i++;
            k++;
        }

        // pętla sprawdza, czy są jeszcze elementy w arr1. Jeśli tak, przypisuje je do merged[k], zwiększa 'j' oraz 'k' o 1.
        while (j < arr2.length) {
            merged[k] = arr2[j];
            j++;
            k++;
        }

        //w zależności od tego w której tablicy pozostały elementy (w arr1 lub arr2) to wykona się jedna z dwóch powyższych pętli while
        //wybrana petla doda te elementy do tablicy merged
        //w sumie nie jest to potrzebne do tego zadania, tzn dla tego konkretnego przykladu, ale jest w razie co

        return merged;
    }

    public static int countCharactersInWord(String word, Character character) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == character) {
                counter++;
            }
        }

        //proste dosyc, niepotrzebny komentarz
        return counter;
    }



    public static int longestPodciag(String word) {
        Set<Character> uniqueChars = new HashSet<>();
        int numberOfLetters = word.length();
        int length = 0;

        /*
        po kolei:
                        dla "ananas"
                     jesteśmy na indexie 0 'a', sprawdzamy czy dany char jest w secie, nie ma wiec go dodajemy i przypisujemy nowa wartosc do length
                     jesteśmy na indexie 1 'n', sprawdzamy czy dany char jest w secie, nie ma wiec go dodajemy i przypisujemy nowa wartosc do length
                     jesteśmy na indexie 2 'a', sprawdzamy czy dany char jest w secie, jest, wiec wychodzimy z petli "j" oraz clearujemy nasz set, length obecnie wynosi = 2
                     jesteśmy na indexie 3 'n', sprawdzamy czy dany char jest w secie, nie ma wiec go dodajemy, length = 2
                     jesteśmy na indexie 4 'a', sprawdzamy czy dany char jest w secie, nie ma wiec go dodajemy, length = 2
                     jesteśmy na indexie 5 's', sprawdzamy czy dany char jest w secie, nie ma wiec go dodajemy, przypisujemy nowa wartosc do length, obecnie jest to 3
                     te wartosc zwracamy, bo wyraz sie 'skonczyl'

        */
        for (int i = 0; i < numberOfLetters; i++) {
            uniqueChars.clear();

            for (int j = i; j < numberOfLetters; j++) {
                if (uniqueChars.contains(word.charAt(j))) {
                    break;
                }

                uniqueChars.add(word.charAt(j));
                if (uniqueChars.size() > length) {
                    length = uniqueChars.size();
                }

            }

        }
        return length;
    }
}
