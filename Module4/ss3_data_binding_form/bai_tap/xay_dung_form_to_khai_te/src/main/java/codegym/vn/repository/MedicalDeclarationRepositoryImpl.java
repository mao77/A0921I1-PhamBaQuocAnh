package codegym.vn.repository;
import codegym.vn.entity.MedicalDeclaration;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MedicalDeclarationRepositoryImpl implements MedicalDeclarationRepository{
    private static Map<Integer, MedicalDeclaration> medicalDeclarationMap = new HashMap<>();
    static {
        medicalDeclarationMap.put(1,new MedicalDeclaration(1,"mao",true,"vietnam","999888", new String[]{"tàu bay"}));
        medicalDeclarationMap.put(2,new MedicalDeclaration(2,"mao1",false,"vietnam","999888", new String[]{"tàu bay"}));
        medicalDeclarationMap.put(3,new MedicalDeclaration(3,"mao2",true,"vietnam","999888", new String[]{"tàu bay","oto"}));
    }

    @Override
    public List<MedicalDeclaration> listAllMedicalDeclaration() {
        return new ArrayList<>(medicalDeclarationMap.values());
    }

    @Override
    public void createMedicalDeclaration(MedicalDeclaration medicalDeclaration) {
        Set<Integer> keySet = medicalDeclarationMap.keySet();
        medicalDeclarationMap.put((keySet.size()+1),new MedicalDeclaration((keySet.size()+1),medicalDeclaration.getName(),
                medicalDeclaration.getSex(),medicalDeclaration.getCountry(),medicalDeclaration.getPassport(),
                medicalDeclaration.getTravelInformation()));
    }


}
