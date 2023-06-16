package com.mdb.managerdb.services;

import com.mdb.managerdb.entities.*;
import com.mdb.managerdb.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseDataManager {
    private final CartRepository cartRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final RecentlyWatchedProductRepository watchedProductRepository;
    private final UserRepository userRepository;
    public <T> void deleteTable(Class<T> dataType) {
        switch (dataType.getSimpleName()) {
            case "UserEntity":
                userRepository.deleteAll();
                break;
            case "Product":
                productRepository.deleteAll();
                break;
            case "Category":
                categoryRepository.deleteAll();
                break;
            case "Cart":
                cartRepository.deleteAll();
                break;
            case "RecentlyWatchedProduct":
                watchedProductRepository.deleteAll();
                break;
            default:
                throw new RuntimeException("Invalid class");
        }
    }
    public <T> void replaceDataInTable(Class<T> dataType, List<T> replacementData) {
        switch (dataType.getSimpleName()) {
            case "UserEntity" -> {
                userRepository.deleteAll();
                userRepository.saveAll((List<UserEntity>) replacementData);
            }
            case "Product" -> {
                productRepository.deleteAll();
                productRepository.saveAll((List<Product>) replacementData);
            }
            case "Category" -> {
                categoryRepository.deleteAll();
                categoryRepository.saveAll((List<Category>) replacementData);
            }
            case "Cart" -> {
               cartRepository.deleteAll();
                cartRepository.saveAll((List<Cart>) replacementData);
            }
            case "RecentlyWatchedProduct" ->{
                watchedProductRepository.deleteAll();
                watchedProductRepository.saveAll((List<RecentlyWatchedProduct>) replacementData);
            }
            default -> throw new RuntimeException("Invalid class");
        }
    }

}
