package codegym.vn.repository;

import codegym.vn.entity.Email;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class EmailRepositoryImpl implements EmailRepository {

    @Override
    public Email getConfiguring(Email email) {
        return  email;
//      for (Map.Entry<String,String> entry : emailConfiguring1.entrySet()) {
//          emailConfiguring.put(entry.getKey(),entry.getValue());
//      }
//        return emailConfiguring;
    }
}
