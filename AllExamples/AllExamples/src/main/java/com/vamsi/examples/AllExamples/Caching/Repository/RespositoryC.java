package com.vamsi.examples.AllExamples.Caching.Repository;

import com.vamsi.examples.AllExamples.Caching.Model.ModelCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespositoryC extends JpaRepository<ModelCache,Integer> {

}
