package io.javabrains.ipldashboard.repository;

import io.javabrains.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    //we can create a default method in Interface
    default List<Match> findLatestMatchesByTeam(String teamName, int count) {
        return findAllByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
