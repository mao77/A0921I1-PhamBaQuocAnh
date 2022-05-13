package com.codegym.vn.repository;

import com.codegym.vn.entity.Blog;;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {
}
