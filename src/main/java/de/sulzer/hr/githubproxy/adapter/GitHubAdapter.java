package de.sulzer.hr.githubproxy.adapter;


import de.sulzer.hr.githubproxy.adapter.bo.RepositoryDto;

import java.util.List;

/**
 * Simple adapter to access the public GitHub API
 */
public interface GitHubAdapter {
    /**
     * Returns a list of repositories which are owned by given user.
     *
     * @param user User to list repositories for
     * @return List of repositories
     */
    List<RepositoryDto> getRepositories(String user);
}
