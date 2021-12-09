package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }

    public static int minValue(int[] array) {
        int min_index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min_index]) {
                min_index = i;
            }
        }
        return min_index;
    }
}
