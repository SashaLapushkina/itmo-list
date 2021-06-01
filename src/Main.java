public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String[] strArr = {"a", "b", "a", "c", "c", "d", "b"};
        Rational[] ratArr = {
                new Rational(1, 2),
                new Rational(-4, 6),
                new Rational(-1, -2),
                new Rational(-7, 2),
                new Rational(7, -2),
                new Rational(5),
                new Rational(4, -6)
        };

        List<Integer> intList = new List<Integer>(new Integer[intArr.length]);

        int j = intList.first();
        for (Integer x: intArr) {
            intList.insert(x, j);
            j = intList.next(j);
        }

        List<String> strList = new List<String>(new String[strArr.length]);

        j = strList.first();
        for (String x: strArr) {
            strList.insert(x, j);
            j = strList.next(j);
        }

        List<Rational> ratList = new List<Rational>(new Rational[ratArr.length]);

        j = ratList.first();
        for (Rational x: ratArr) {
            ratList.insert(x, j);
            j = ratList.next(j);
        }


        intList.printList();
        deleteDuplicates(intList);
        intList.printList();

        strList.printList();
        deleteDuplicates(strList);
        strList.printList();

        ratList.printList();
        deleteDuplicates(ratList);
        ratList.printList();
    }

    //Удаление повторяющихся элементов
    public static <T extends Comparable> void deleteDuplicates(List<T> list) {
        int i = list.first();
        while (i != list.end()) {
            int x = list.next(i);
            while (x != list.end()) {
                if (list.retrieve(i).compareTo(list.retrieve(x)) == 0) {
                    list.delete(x);
                } else if (x != list.end()) x = list.next(x);
            }
            i = list.next(i);
        }

    }
}