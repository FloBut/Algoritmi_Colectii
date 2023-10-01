import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_3_Duplicate {
    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(6, 5, 6, 2, 3, 1);
        System.out.println(getNumbersOfDuplicate(numbersList)); // cand apelez metoda numarul de aparitii este 1
        //{1=1, 2=1, 3=1, 5=1, 6=1}
    }



  public static Map<Integer,Integer> getNumbersOfDuplicate(List<Integer> numbersList) {
        //parcurg lista si pentru fiecare numar din lista numar de cate ori apare in lista respectiva
        //salvez in mapa numarul si de fiecare data cand il gasesc cresc numarul de aparitii si il pun
      //in mapa la cheia valoare
        Map<Integer, Integer> numbersOfDuplicate = new HashMap<>();
        for (int i = 0; i < numbersList.size(); i++) {
            int no = numbersList.get(i);
            int appearanceNo = 1;
            for (int j = i + 1; j < numbersList.size(); j++) {
                if (no == numbersList.get(j)) {
                    ++appearanceNo;
                }
            }
            System.out.println(appearanceNo); //pentru 6 numarul de aparitii este 2
            numbersOfDuplicate.put(no, appearanceNo);
        }
       return numbersOfDuplicate;
    }
}
//3.Sa se verifice daca un array contine duplicate
//Exemplu:
//Input: [6,5,6,2,3,1]
//Output: true, pentru ca 6 apare de doua ori
//(hint: construieste o mapa care sa numere de cate ori apare fiecare element din lista)
