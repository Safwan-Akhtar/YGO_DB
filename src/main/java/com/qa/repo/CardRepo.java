package com.qa.repo;

import com.qa.Domain.Card_DB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card_DB, Long> {
}