package codegym.vn.service;

import codegym.vn.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    private DictionaryRepository dictionaryRepository;
    @Autowired
    public void setDictionaryRepository(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
