package com.JavaIdea4.UTunes.repository;

import java.util.List;
import com.JavaIdea4.UTunes.model.Tune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuneRepository extends CrudRepository< Tune , Long> {
    List<Tune> findByGenre(String genre);
}