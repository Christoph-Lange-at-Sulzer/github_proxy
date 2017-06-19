package de.sulzer.hr.githubproxy.adapter.rest;

import de.sulzer.hr.githubproxy.adapter.GitHubAdapter;
import de.sulzer.hr.githubproxy.adapter.bo.RepositoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GitHubAdapterImpl implements GitHubAdapter {
    private static final String GET_REPOSITORY_URL = "https://api.github.com/users/%s/repos";

    private RestTemplate restTemplate;

    @Autowired
    public GitHubAdapterImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<RepositoryDto> getRepositories(String user) {
        String url = String.format(GET_REPOSITORY_URL, user);
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RepositoryDto>>() {
        }).getBody();
    }
}
