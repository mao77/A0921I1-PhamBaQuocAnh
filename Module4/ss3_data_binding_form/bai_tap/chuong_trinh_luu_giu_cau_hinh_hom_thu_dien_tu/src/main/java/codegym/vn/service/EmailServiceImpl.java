package codegym.vn.service;

import codegym.vn.entity.Email;
import codegym.vn.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class EmailServiceImpl implements EmailService{
    private EmailRepository emailRepository ;
    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email getConfiguring(Email email) {
        return emailRepository.getConfiguring(email);
    }
}
