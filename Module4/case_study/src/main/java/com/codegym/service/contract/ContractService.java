package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    void createContract(Contract contract);
    Page<Contract> findAllByIdAndAndCustomerId(String id, String customerId, Pageable pageable);
}
