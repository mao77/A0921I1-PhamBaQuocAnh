package codegym.vn.repository;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImp implements DictionaryRepository{
    private static Map<String,String> map =new HashMap<>();
    static {
        map.put("hello","xin chào");
        map.put("goodbye","tạm biệt");
        map.put("father","bố");
        map.put("mother","mẹ");
        map.put("computer","máy tính");
        map.put("teacher","giáo viên");
    }
    @Override
    public String translate(String word) {
        String result = null;
        if (map.containsKey(word)) {
            result = map.get(word);
        }
        return result;
    }
}
