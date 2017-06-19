package de.sulzer.hr.githubproxy.service;


import de.sulzer.hr.githubproxy.service.bo.Repository;

import java.util.List;

/**
 * Simple service to access public GitHub API
 */
public interface GitHubService {

    /**
     * Returns a list of repositories which are owned by given user.
     *
     * @param user User to list repositories for
     * @return List of repositories
     */
    List<Repository> getRepositories(String user);
}
