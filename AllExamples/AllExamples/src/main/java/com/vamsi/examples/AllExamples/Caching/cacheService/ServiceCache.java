package com.vamsi.examples.AllExamples.Caching.cacheService;

import com.vamsi.examples.AllExamples.Caching.Model.ModelCache;
import com.vamsi.examples.AllExamples.Caching.Repository.RespositoryC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Service
public class ServiceCache {

    @Autowired
    RespositoryC repo;


    // GET (Cacheable)
    @Cacheable(value = "cacheStorage", key = "#id")
    public ResponseEntity<?> findById(int id) {
        Optional<ModelCache> optionalModelCache = repo.findById(id);

        if (optionalModelCache.isPresent()) {
            return ResponseEntity.ok(optionalModelCache.get());
        }

        return ResponseEntity.notFound().build();
    }

    // CREATE
    public ResponseEntity<?> createModel(ModelCache modelCache) {
        try {
            ModelCache saved = repo.save(modelCache);
            return ResponseEntity.ok(saved);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    // UPDATE (CachePut)
    @CachePut(value = "cacheStorage", key = "#modelCache.id")
    public ResponseEntity<?> updateModel(ModelCache modelCache) {
        if (repo.existsById(modelCache.getId())) {
            ModelCache updated = repo.save(modelCache);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE (CacheEvict)
    @CacheEvict(value = "cacheStorage", key = "#id")
    public ResponseEntity<?> deleteModel(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("Deleted ID: " + id);
        }
        return ResponseEntity.notFound().build();
    }

    // GET ALL (No caching)
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // CLEAR ALL CACHE
    @CacheEvict(value = "cacheStorage", allEntries = true)
    public ResponseEntity<?> clearCache() {
        return ResponseEntity.ok("Cache cleared");
    }


}
