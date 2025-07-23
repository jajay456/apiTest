package com.example.apitest.repository;

import com.example.apitest.entity.SsoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsoUserRepository extends JpaRepository<SsoUserEntity, String> {
}
