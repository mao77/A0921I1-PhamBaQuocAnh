package codegym.vn.service;

import codegym.vn.entity.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationService {
    List<MedicalDeclaration> listAllMedicalDeclaration();
    void createMedicalDeclaration(MedicalDeclaration medicalDeclaration);
}
