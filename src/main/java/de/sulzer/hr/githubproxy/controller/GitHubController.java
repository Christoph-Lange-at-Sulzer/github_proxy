package de.sulzer.hr.githubproxy.controller;


import de.sulzer.hr.githubproxy.common.Validator;
import de.sulzer.hr.githubproxy.controller.bo.RepositoryVo;
import de.sulzer.hr.githubproxy.exceptions.ValidationException;
import de.sulzer.hr.githubproxy.service.GitHubServiceImpl;
import de.sulzer.hr.githubproxy.service.bo.Repository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class GitHubController {

    private GitHubServiceImpl github;
    private Validator validator;

    @Autowired
    public GitHubController(GitHubServiceImpl github, Validator validator) {
        this.github = github;
        this.validator = validator;
    }

    @ApiOperation(value = "Get GitHub repositories",
            notes = "Returns a list of repositories for a specific GitHub user.")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/repository", method = RequestMethod.GET)
    public List<RepositoryVo> getUserRepository(@RequestParam String username) {

        // validate input
        validator.isNotNull(username, new ValidationException("User may not be null."));
        validator.isNotBlank(username, () -> new ValidationException("User may not be blank."));

        return boToVo(github.getRepositories(username));
    }

    private List<RepositoryVo> boToVo(List<Repository> dto) {
        List<RepositoryVo> repos = new LinkedList<RepositoryVo>();
        dto.forEach(r -> repos.add(boToVo(r)));
        return repos;
    }

    private RepositoryVo boToVo(Repository dto) {
        RepositoryVo repository = new RepositoryVo();
        repository.setName(dto.getName());
        repository.setFullName(dto.getFullName());
        repository.setDefaultBranch(dto.getDefaultBranch());
        repository.setDescription(dto.getDescription());
        repository.setUrl(dto.getUrl());
        return repository;
    }
}
