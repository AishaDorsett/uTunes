package com.JavaIdea4.UTunes.repository;

import java.util.List;

import com.JavaIdea4.UTunes.model.Favourite;
import com.JavaIdea4.UTunes.model.Tune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

// @Repository
public interface FavouriteRepository extends PagingAndSortingRepository<Favourite, Long> {
  List<Favourite> findByTuneId(Long id);
  List<Favourite> findAllByTuneId(Long tune_id);
}
