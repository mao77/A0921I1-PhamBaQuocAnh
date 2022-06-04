package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractRepository contractRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void createContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAllByIdAndAndCustomerId(String id, String customerId, Pageable pageable) {
        return contractRepository.findAllByIdAndAndCustomerId(id,customerId,pageable);
    }
}
