package ss10_dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_cua_arraylist_theo_thu_vien_javautilarraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        elements = (E[]) new Object[size];
    }

    private void ensureCapa() {
        if (size > elements.length) {
            int biggerSize = size * 2 + 1;
            elements = Arrays.copyOf(elements, biggerSize);
        }
    }

    public void add(E e, int index) {
        if (index >= 0 && index <= size) {
            size += 1;
            ensureCapa();
            for (int i = size - 2; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = e;
        }
    }
}
