package com.app.kuri.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.kuri.Model.Authority;

@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, Long>{
    
}
