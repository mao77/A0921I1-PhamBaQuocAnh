package ss15_xu_ly_ngoai_le_debug.bai_tap.su_dung_lop_illegaltriangleexception.triangleEdgesCheck;

import ss15_xu_ly_ngoai_le_debug.bai_tap.su_dung_lop_illegaltriangleexception.triangleEdgesException.TriangleEdgesException;

public class TriangleEdgesCheck {
    // Ham kiem tra tam giac hop le
    public void checkTriangleEdges(double a, double b, double c) throws TriangleEdgesException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleEdgesException("Loi: Tam giac khong hop le!");
        } else {
            System.out.println("Tam giac hop le!");
        }
    }
}
