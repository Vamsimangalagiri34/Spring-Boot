package com.vamsi.examples.AllExamples.Caching;

import com.vamsi.examples.AllExamples.Caching.Model.ModelCache;
import com.vamsi.examples.AllExamples.Caching.cacheService.ServiceCache;
import com.vamsi.examples.AllExamples.Repository.LockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    ServiceCache serviceCache;

    @Autowired
    CacheManager cacheManager;


    @GetMapping("/view-cache")
    public Object viewCache() {
        Cache cache = cacheManager.getCache("cacheStorage");

        if (cache == null) {
            return "Cache not found!";
        }

        // ConcurrentMapCache exposes the underlying map
        ConcurrentMap<Object, Object> map =
                (ConcurrentMap<Object, Object>) cache.getNativeCache();

        return map;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return serviceCache.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createModel(@RequestBody ModelCache modelCache) {
        return serviceCache.createModel(modelCache);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateModel(@RequestBody ModelCache modelCache) {
        return serviceCache.updateModel(modelCache);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return serviceCache.deleteModel(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return serviceCache.getAll();
    }

    @DeleteMapping("/clear-cache")
    public ResponseEntity<?> clearCache() {
        return serviceCache.clearCache();
    }
}
