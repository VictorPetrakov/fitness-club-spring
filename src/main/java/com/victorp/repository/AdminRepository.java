package com.victorp.repository;

import com.victorp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
