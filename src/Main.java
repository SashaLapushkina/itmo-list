public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 1, 3, 3, 4, 2};
        String[] strArr = {"a", "b", "a", "c", "c", "d", "b"};
        Rational[] ratArr = {
                new Rational(1, 2),
                new Rational(4, 6),
                new Rational(1, 2),
                new Rational(7, 2),
                new Rational(7, 2),
                new Rational(5),
                new Rational(4, 6)
        };

        List<Integer> intList = new List<>();
        int p = intList.first();
        for (Integer val: intArr){
            intList.insert(val, p);
            p = intList.next(p);
        }

        List<String> strList = new List<>();
        p = strList.first();
        for (String val: strArr){
            strList.insert(val, p);
            p = strList.next(p);
        }

        List<Rational> ratList = new List<>();
        p = ratList.first();
        for (Rational val: ratArr){
            ratList.insert(val, p);
            p = ratList.next(p);
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
        while (i < list.end()) {
            int x = list.next(i);
            while (x < list.end()) {
                if (list.retrieve(i).compareTo(list.retrieve(x)) == 0) list.delete(x);
                try {
                    x = list.next(x);
                } catch (MyException e) {

                }
            }
            i = list.next(i);
        }

    }
}
