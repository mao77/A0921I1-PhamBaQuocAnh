package model.service.impl;

import model.bean.EducationDegree;
import model.repository.EducationDegreeRepository;
import model.repository.impl.EducationDegreeRepositoryImpl;
import model.service.EducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> listAll() {
        return educationDegreeRepository.listAll();
    }
}
