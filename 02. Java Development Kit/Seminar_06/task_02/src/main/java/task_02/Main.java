package task_02;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));

        System.out.println("Развернутый список элементов: " + Lists.reverse(arrayList));

        System.out.println("Получить лист Character из строки: " + Lists.charactersOf("adsfgafgdfgd"));

        System.out.println("Разделить лист на группы по 2 элемента: " + Lists.partition(arrayList, 2));


        System.out.println("Получить итоговый Set из двух коллекций: " + Sets.union(Set.of(arrayList), Set.of(arrayList2)));
        System.out.println("Получить итоговый Set из общих элементов двух коллекций: " + Sets.union(Set.copyOf(arrayList), Set.copyOf(arrayList2)));
        System.out.println("Получить итоговый Set из непересекающихся элементов двух коллекций: " + Sets.symmetricDifference(Set.copyOf(arrayList), Set.copyOf(arrayList2)));
    }
}
