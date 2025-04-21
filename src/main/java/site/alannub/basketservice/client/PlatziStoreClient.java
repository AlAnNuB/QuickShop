package site.alannub.basketservice.client;

import site.alannub.basketservice.client.response.PlatziProductReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}", configuration = { site.alannub.basketservice.exception.CustomErrorDecoder.class })
public interface PlatziStoreClient {

    @GetMapping("/products")
    List<PlatziProductReponse> getAllProducts();

    @GetMapping("/products/{id}")
    PlatziProductReponse getProduct(@PathVariable Long id);
}
