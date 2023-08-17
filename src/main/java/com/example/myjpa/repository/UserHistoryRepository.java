package com.example.myjpa.repository;

import com.example.myjpa.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    List<UserHistory> findByUserId(Long userId);
}
