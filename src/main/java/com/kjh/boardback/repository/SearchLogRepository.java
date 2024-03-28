package com.kjh.boardback.repository;

import com.kjh.boardback.repository.resultSet.GetPopularListResultSet;
import com.kjh.boardback.repository.resultSet.GetRelationListResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kjh.boardback.entity.SearchLogEntity;

import java.util.List;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer>{

    @Query(value =
            "SELECT search_word AS searchWord, count(search_word) AS count "+
            "FROM search_log "+
            "WHERE relation IS FALSE "+
            "GROUP BY search_word "+
            "ORDER BY count DESC "+
            "LIMIT 15 ",
            nativeQuery = true
    )
    List<GetPopularListResultSet> getPopularList();

    @Query(value =
            "SELECT relation_word AS searchWord, count(relation_word) AS count "+
                    "FROM search_log "+
                    "WHERE search_word = ?1 "+
                    "AND relation_word IS NOT NULL "+
                    "GROUP BY relation_word "+
                    "ORDER BY count DESC "+
                    "LIMIT 15 ",
            nativeQuery = true
    )
    List<GetRelationListResultSet> getRelationList(String SearchWord);
    
}
