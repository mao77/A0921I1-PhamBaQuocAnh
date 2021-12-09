package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_StopWatch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        System.out.println("StartTime: " + stopWatch.start());

        long count = 0;
        for (int i = 0; i < 100000; i++) {
            count += i;
        }

        System.out.println("StopTime: " + stopWatch.stop());;
        System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());;
    }
}
