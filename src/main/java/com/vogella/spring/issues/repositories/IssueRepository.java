package com.vogella.spring.issues.repositories;

import com.vogella.spring.issues.entities.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssueRepository extends JpaRepository<IssueReport, Long> {

    @Query(value = "select i from IssueReport i where i.markedAsPrivate = false")
    List<IssueReport> findAllByMarkedAsPrivate();

    List<IssueReport> findAllByEmail(String email);
}
