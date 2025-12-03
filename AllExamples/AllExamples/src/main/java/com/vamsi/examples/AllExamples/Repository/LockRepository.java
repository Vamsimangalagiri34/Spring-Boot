package com.vamsi.examples.AllExamples.Repository;

import com.vamsi.examples.AllExamples.Model.ObjectLock;
import com.vamsi.examples.AllExamples.lockingdemo.Model.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LockRepository extends JpaRepository<ObjectLock,Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> findByIdForUpdate(@Param("id") Long id);

}
