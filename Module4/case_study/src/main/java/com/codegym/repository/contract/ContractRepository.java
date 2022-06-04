package com.codegym.repository.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "SELECT * FROM contract where id like concat('%',:id,'%') " +
            "and customer_id like concat('%',:customerId,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM contract where id like concat('%',:id,'%') and customer_id like concat('%',:customerId,'%') ) abc ")
    Page<Contract> findAllByIdAndAndCustomerId(@Param("id") String id, @Param("customerId") String customerId, Pageable pageable);
}
