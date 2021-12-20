package ss6_ke_thua.bai_tap.lop_point_va_move_ablepoint;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(1,1);
        System.out.println(movablePoint.move());
        movablePoint.setSpeed(3,3);
        System.out.println(movablePoint.move());
        movablePoint.setSpeed(1,1);
        System.out.println(movablePoint.move());

    }
}
