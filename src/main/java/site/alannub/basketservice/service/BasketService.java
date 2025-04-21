package site.alannub.basketservice.service;

import site.alannub.basketservice.client.response.PlatziProductReponse;
import site.alannub.basketservice.controller.request.BasketRequest;
import site.alannub.basketservice.controller.request.PaymentRequest;
import site.alannub.basketservice.entity.Basket;
import site.alannub.basketservice.entity.Product;
import site.alannub.basketservice.entity.Status;
import site.alannub.basketservice.exception.BusinessException;
import site.alannub.basketservice.exception.DataNotFoundException;
import site.alannub.basketservice.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Optional<Basket> getBasketById(String id) {
        return basketRepository.findById(id);
    }

    public Basket createBasket(BasketRequest basketRequest) {
        basketRepository.findByClientAndStatus(basketRequest.getClientId(), Status.OPEN).ifPresent(basket -> {
            throw new BusinessException("Basket already exists");
        });

        List<Product> products = manageProductsRequest(basketRequest);

        Basket basket = Basket.builder()
                .client(basketRequest.getClientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket updateBasket(String basketId, BasketRequest basketRequest) {
        Basket basket = getBasket(basketId);

        List<Product> products = manageProductsRequest(basketRequest);

        basket.setProducts(products);
        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket payBasket(String basketId, PaymentRequest paymentRequest) {
        Basket basket = getBasket(basketId);
        basket.setPaymentMethod(paymentRequest.getPaymentMethod());
        basket.setStatus(Status.SOLD);
        return basketRepository.save(basket);
    }

    public void deleteBasket(String basketId) {
        getBasket(basketId);
        basketRepository.deleteById(basketId);
    }

    private Basket getBasket(String basketId) {
        return this.getBasketById(basketId).orElseThrow(() -> new DataNotFoundException("Basket not found"));
    }

    private List<Product> manageProductsRequest(BasketRequest basketRequest) {
        List<Product> products = new ArrayList<>();
        basketRequest.getProducts().forEach(productRequest -> {
            PlatziProductReponse platziProductReponse = productService.getProduct(productRequest.getId());
            products.add(Product.builder()
                    .id(platziProductReponse.id())
                    .price(platziProductReponse.price())
                    .title(platziProductReponse.title())
                    .quantity(productRequest.getQuantity())
                    .build());

        });
        return products;
    }
}
