public class List<T extends Comparable> {
    private T[] values = (T[]) new Object[10]; //Массив значений
    private int size = 0; //Размер списка
    private int last = -1; //Последний заполненный элемент

    //Возвращает позицию "после последнего"
    public int end() {
        return last + 1;
    }

    //Вставить x после на место p
    public void insert(T x, int p) {
        if (p <= end() && p >= 0) {
            for (int i = end(); i >= p + 1; ) { //Сдвигаем значения, начиная с p, на одно вправо
                values[i] = values[--i];
            }
            values[p] = x;
            last++;
            size++;
        }
    }

    //Возвращают позицию x
    public int locate(T x) {
        int i = 0;
        while (values[i] != x && i < end()) i++;
        return i;
    }

    //Возвращает элемент в позиции p
    public T retrieve(int p) {
        if (p >= end() || p < 0) throw new MyException();
        return values[p];
    }

    //Удаляет элемент в позиции p
    public void delete(int p) {
        if (p < end() && p >= 0) {
            for (int i = p; i < last; ) {
                values[i] = values[++i];
            }
            last--;
            size--;
        }
    }

    //Возвращает следующую за p позицию
    public int next(int p){
        if (p >= end() || p < 0) throw new MyException();
        //if (p == last) return end();
        return p + 1;
    }

    //Возвращает предшествующую p позицию
    public int previous(int p){
        if (p >= end() || p <= 0) throw new MyException();
        return p - 1;
    }

    //Делает список пустым
    public void makeNull() {
        size = 0;
        last = -1;
    }

    //Возвращает первую позицию в списке
    public int first() {
        //if (size == 0) return end();
        //else
            return 0;
    }

    //Печать
    public void printList() {
        for (int i = first(); i < end(); i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}
