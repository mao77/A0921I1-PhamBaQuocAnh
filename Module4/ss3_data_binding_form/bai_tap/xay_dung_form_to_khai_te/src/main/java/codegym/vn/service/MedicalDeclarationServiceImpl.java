package codegym.vn.service;

import codegym.vn.entity.MedicalDeclaration;
import codegym.vn.repository.MedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalDeclarationServiceImpl implements MedicalDeclarationService{
    private MedicalDeclarationRepository medicalDeclarationRepository;
    @Autowired
    public void setMedicalDeclarationRepository(MedicalDeclarationRepository medicalDeclarationRepository) {
        this.medicalDeclarationRepository = medicalDeclarationRepository;
    }

    @Override
    public List<MedicalDeclaration> listAllMedicalDeclaration() {
        return medicalDeclarationRepository.listAllMedicalDeclaration();
    }

    @Override
    public void createMedicalDeclaration(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.createMedicalDeclaration(medicalDeclaration);
    }
}
