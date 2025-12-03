package com.vamsi.examples.AllExamples.lockingdemo;

import com.vamsi.examples.AllExamples.lockingdemo.Model.Product;
import com.vamsi.examples.AllExamples.lockingdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductRepository productRepository;

    // ✅ Create sample products
    @PostMapping("/init")
    public String createProducts() {
        productRepository.save(new Product("Laptop", 10));
        productRepository.save(new Product("Phone", 20));
        productRepository.save(new Product("Tablet", 15));
        return "Products initialized!";
    }

    @GetMapping("/test-optimistic/{productId}")
    public String testOptimistic(@PathVariable Long productId ) {
//        Long productId = 1L;

        new Thread(() -> productService.updateProductQuantityOptimistic(productId, 100), "Thread-B").start();
        new Thread(() -> productService.updateProductQuantityOptimistic(productId, 50), "Thread-A").start();
        return "Started optimistic locking test";
    }

    @GetMapping("/test-pessimistic")
    public String testPessimistic() {
        Long productId = 1L;
        new Thread(() -> productService.updateProductQuantityPessimistic(productId, 50), "Thread-A").start();
        new Thread(() -> productService.updateProductQuantityPessimistic(productId, 100), "Thread-B").start();
        return "Started pessimistic locking test";
    }

    // ✅ Test endpoint for demonstrating PESSIMISTIC READ behavior
    @GetMapping("/test-pessimistic-read")
    public String testPessimisticRead() {
        // 🔹 The ID of the product to be used for testing
        Long id = 6L;

        // 🔹 Create two read operations (both will acquire a PESSIMISTIC READ lock)
        //    - This means they can both read concurrently,
        //      but will block any write (update/delete) until they finish.
        Runnable t1 = () -> productService.readProductWithPessimisticLock(id);
        Runnable t2 = () -> productService.readProductWithPessimisticLock(id);

        // 🔹 Create two threads simulating concurrent read operations
        Thread threadA = new Thread(t1, "Thread-A");
        Thread threadB = new Thread(t2, "Thread-B");

        // 🔹 Start first read thread
        threadA.start();

        // 🔹 Simultaneously, we’ll try to perform two update operations on the same product.
        //    - These updates use PESSIMISTIC WRITE locks (SELECT ... FOR UPDATE)
        //    - Hence, they’ll be blocked until the read locks are released.
        Long productId = 6L;
        new Thread(() -> productService.updateProductQuantityPessimistic(productId, 50), "Thread-C").start();
        new Thread(() -> productService.updateProductQuantityPessimistic(productId, 100), "Thread-D").start();

        // 🔹 Start second read thread
        threadB.start();

        // 🔹 Return a confirmation message once all threads have been started
        return "✅ Started two concurrent PESSIMISTIC READ operations and two PESSIMISTIC WRITE updates on Product ID = " + id;
    }



}