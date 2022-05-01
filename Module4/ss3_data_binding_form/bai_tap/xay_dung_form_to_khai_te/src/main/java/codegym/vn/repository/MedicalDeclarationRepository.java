package codegym.vn.repository;
import codegym.vn.entity.MedicalDeclaration;
import java.util.List;


public interface MedicalDeclarationRepository {
    List<MedicalDeclaration> listAllMedicalDeclaration();
    void createMedicalDeclaration(MedicalDeclaration medicalDeclaration);
}
