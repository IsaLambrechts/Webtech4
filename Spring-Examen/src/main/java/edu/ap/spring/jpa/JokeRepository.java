package edu.ap.spring.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "joke_post", path = "joke_post")
public interface JokeRepository extends PagingAndSortingRepository<Joke, Long> {
    String findByJoke(String joke);
}
