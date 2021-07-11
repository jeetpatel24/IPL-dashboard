package io.javabrains.ipldashboard.controller;

import io.javabrains.ipldashboard.model.Match;
import io.javabrains.ipldashboard.model.Team;
import io.javabrains.ipldashboard.repository.MatchRepository;
import io.javabrains.ipldashboard.repository.TeamRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName) {
        Team team = teamRepository.findByTeamName(teamName);
        team.setLatestMatchesList(matchRepository.findLatestMatchesByTeam(teamName, 4));

        return team;
    }
}
