package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_StopWatch;

public class StopWatch {
    private long startTime, endTime;
    StopWatch() {
        this.startTime = System.currentTimeMillis();
    }
    public long start() {
         this.startTime = System.currentTimeMillis();
         return this.startTime;
    }
    public long stop() {
        this.endTime = System.currentTimeMillis();
        return endTime;
    }
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}
