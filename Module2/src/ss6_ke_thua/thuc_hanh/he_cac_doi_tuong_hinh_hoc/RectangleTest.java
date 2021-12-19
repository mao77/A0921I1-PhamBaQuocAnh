package ss6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class RectangleTest {
    public static void main(String[] args) {
        Retangle retangle = new Retangle();
        System.out.println(retangle);
        retangle = new Retangle(2.3,5.8);
        System.out.println(retangle);
        retangle = new Retangle(2.3,5.8,"red",true);
        System.out.println(retangle);
    }
}
