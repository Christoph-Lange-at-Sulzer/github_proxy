# Task: GitHub proxy with spring-boot

Welcome to the Sulzer candidate task for the java programming language and spring-boot. This task will build upon an existing repository to query the public GitHub API
to fetch repository data for specific users. After installing and validating the application, you may continue with the tasks listed below.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development purpose.

### Prerequisites

Following programs are required:


* Your favorite text editor or IDE
* JDK 1.8 or later
* Maven 3.0+

### Installing

Download and unzip the source repository for this task, or clone it using Git:

```
git clone https://github.com/TBD.git
```

Open a terminal window, go to the downloaded/cloned task's source folder and execute then Maven command to start spring-boot:

```
./mvn spring-boot:run
```

Open your browser at [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to validate that the application is running. You should see the swagger UI. Click on the github-controller and the /repository-endpoint to test the connection between your application and GitHub. E.g. use user=spring-projects to fetch all spring repositories. After clicking Try out, you should see an array of repositories as response body.

## Tasks


### A: Sorting of repositories

The existing application's endpoint should support a possibility to sort the returned list of repositories by _name_, _size_, _forks_, _watchers_, _creation date_ and _date of last push_. The sorting order should also be provided by the REST endpoint. Sorting should be optional but only aforementioned fields should be possible as well as _ASC_ and _DESC_ as sorting direction.

Sample request:
```
GET /repository?user=spring-projects&sortby=forks&sort=DESC
```

Sample response:
```
[
  {
    "name": "aws-ant",
    [...]
  },
  {
    [...]
  }
]
```


### B: Paging of repositories

The existing application's endpoint should support the possibility to limit the amount of returned repositories as well as a form of paging. Furthermore the total number of repositories should be included in the response.

Sample request:
```
GET /repository?user=spring-projects&page=2&limit=5
```

Sample response:
```
{
    "repositories": [
      {
        "name": "aws-ant",
        [...]
      },
      {
        [...]
      }
    ],
    "total": 30
}
```

### C: Retrieve an Emoji's image URL

The application should be able to return the image URL of an emoji which can be used on GitHub.

Use the API's endpoint for a complete list of emojis and their image URL: https://api.github.com/emojis

#### Task
Extend the existing GitHub proxy application to provide an additional endpoint in the REST controller which accepts the name of a GitHub emoji. The application should query the GitHub's API to retrieve the correct image URL and should return this URL only.

Sample request:
```
GET /emoji?name=beers
```

Sample response:
```
{
    "url: "https://assets-cdn.github.com/images/icons/emoji/unicode/1f37b.png?v7"
}
```





