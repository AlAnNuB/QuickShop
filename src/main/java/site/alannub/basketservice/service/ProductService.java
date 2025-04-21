package site.alannub.basketservice.service;

import site.alannub.basketservice.client.PlatziStoreClient;
import site.alannub.basketservice.client.response.PlatziProductReponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final PlatziStoreClient storeClient;

    public ProductService(PlatziStoreClient storeClient) {
        this.storeClient = storeClient;
    }

    @Cacheable(value = "produtos")
    public List<PlatziProductReponse> getAllProducts() {
        log.info("Getting all products");
        return storeClient.getAllProducts();
    }

    @Cacheable(value = "produto", key = "#productId")
    public PlatziProductReponse getProduct(Long productId) {
        log.info("Getting product with id: {}", productId);
        return storeClient.getProduct(productId);
    }
}
