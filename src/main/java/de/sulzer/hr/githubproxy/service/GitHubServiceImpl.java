package de.sulzer.hr.githubproxy.service;

import de.sulzer.hr.githubproxy.adapter.GitHubAdapter;
import de.sulzer.hr.githubproxy.adapter.bo.RepositoryDto;
import de.sulzer.hr.githubproxy.service.bo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GitHubServiceImpl implements GitHubService {

    private GitHubAdapter github;

    @Autowired
    public GitHubServiceImpl(GitHubAdapter github) {
        this.github = github;
    }

    @Override
    public List<Repository> getRepositories(String user) {
        return dtoToBo(github.getRepositories(user));
    }

    /**
     * Converts a list of repositories from adapter layer to service layer business objects.
     *
     * @param dto
     * @return
     */
    private List<Repository> dtoToBo(List<RepositoryDto> dto) {
        List<Repository> repos = new LinkedList<Repository>();
        dto.forEach(r -> repos.add(dtoToBo(r)));
        return repos;
    }

    /**
     * Converts a repository from adapter layer to a service layer business object
     *
     * @param dto
     * @return
     */
    private Repository dtoToBo(RepositoryDto dto) {
        Repository repository = new Repository();
        repository.setName(dto.getName());
        repository.setFullName(dto.getFullName());
        repository.setDefaultBranch(dto.getDefaultBranch());
        repository.setDescription(dto.getDescription());
        repository.setUrl(dto.getUrl());
        return repository;
    }

}
