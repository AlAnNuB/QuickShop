package site.alannub.basketservice.repository;

import site.alannub.basketservice.entity.Basket;
import site.alannub.basketservice.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientAndStatus(Long client, Status status);
}
