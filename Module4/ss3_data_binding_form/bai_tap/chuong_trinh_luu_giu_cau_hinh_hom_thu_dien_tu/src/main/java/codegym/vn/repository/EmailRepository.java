package codegym.vn.repository;

import codegym.vn.entity.Email;

import java.util.Map;

public interface EmailRepository {
    Email getConfiguring(Email email);
}
