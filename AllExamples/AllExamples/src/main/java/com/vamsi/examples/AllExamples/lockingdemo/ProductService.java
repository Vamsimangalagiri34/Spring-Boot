package com.vamsi.examples.AllExamples.lockingdemo;

import com.vamsi.examples.AllExamples.lockingdemo.Model.Product;
import com.vamsi.examples.AllExamples.lockingdemo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 🔹 1️⃣ Optimistic Lock
    @Transactional
    public void updateProductQuantityOptimistic(Long productId, int newQuantity) {
        try {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            System.out.println("🧵 " + Thread.currentThread().getName() +
                    " loaded version: " + product.getVersion());

            Thread.sleep(3000); // simulate delay
            product.setQuantity(newQuantity);
            productRepository.save(product);

            System.out.println("✅ " + Thread.currentThread().getName() +
                    " updated successfully. New version: " + product.getVersion());

        } catch (Exception e) {
            System.out.println("❌ " + Thread.currentThread().getName() +
                    " failed due to version conflict: " + e.getMessage());
        }
    }

    // 🔹 2️⃣ Pessimistic Write Lock
    @Transactional
    public void updateProductQuantityPessimistic(Long productId, int newQuantity) {
        String threadName = Thread.currentThread().getName();
        System.out.println("🧵 " + threadName + " is trying to acquire WRITE lock...");

        Product product = productRepository.findByIdForUpdate(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println("🔒 " + threadName +
                " acquired WRITE lock on Product ID: " + productId +
                ", current quantity: " + product.getQuantity());

        try {
            Thread.sleep(3000); // simulate long transaction
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        product.setQuantity(newQuantity);
        productRepository.save(product);

        System.out.println("✅ " + threadName +
                " updated quantity to " + newQuantity +
                " and released WRITE lock.");
    }

    // 🔹 3️⃣ Pessimistic Read Lock
    @Transactional
    public void readProductWithPessimisticLock(Long productId) {
        String threadName = Thread.currentThread().getName();
        System.out.println("👁️ " + threadName + " is trying to acquire READ lock...");

        Product product = productRepository.findByIdForRead(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println("📘 " + threadName +
                " acquired READ lock on Product ID: " + productId +
                ", current quantity: " + product.getQuantity());

        try {
            Thread.sleep(3000); // simulate long read
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("✅ " + threadName +
                " finished reading and released READ lock.");
    }
}
