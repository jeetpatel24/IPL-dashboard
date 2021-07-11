package io.javabrains.ipldashboard.repository;

import io.javabrains.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
