public class List<T extends Comparable> {
    private T[] values; //Массив значений
    private int size = 0; //Размер списка
    private int last = -1; //Последний заполненный элемент

    List(T[] array) {
        values = array;
        size = array.length;
    }

    //Возвращает позицию "после последнего"
    public int end() {
        return last + 1;
    }

    //Вставить x на место p
    public void insert(T x, int p) {
        if (last < size - 1 && p <= last + 1 && p >= 0) {
            for (int i = last + 1; i >= p + 1; i--) { //Сдвигаем значения, начиная с p, на одно вправо
                values[i] = values[i - 1];
            }
            values[p] = x;
            last++;
        }
    }

    //Возвращают позицию x
    public int locate(T x) {
        int i = 0;
        while (values[i] != x && i <= last) i++;
        return i;
    }

    //Возвращает элемент в позиции p
    public T retrieve(int p) {
        if (p > last || p < 0) throw new MyException();
        return values[p];
    }

    //Удаляет элемент в позиции p
    public void delete(int p) {
        if (p <= last && p >= 0) {
            for (int i = p; i < last; i++) {
                values[i] = values[i + 1];
            }
            last--;
        }
    }

    //Возвращает следующую за p позицию
    public int next(int p){
        if (p > last || p < 0) throw new MyException();
        return p + 1;
    }

    //Возвращает предшествующую p позицию
    public int previous(int p){
        if (p > last || p <= 0) throw new MyException();
        return p - 1;
    }

    //Делает список пустым
    public void makeNull() {
        last = -1;
    }

    //Возвращает первую позицию в списке
    public int first() {
        return 0;
    }

    //Печать
    public void printList() {
        for (int i = 0; i <= last; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}
