package gs.springframework.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import gs.springframework.domain.Product;
import gs.springframework.repositories.ProductRepository;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Nike TShirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("www.nike.com");
        shirt.setProductId("201");
        productRepository.save(shirt);

        log.info("Saved TShirt - id: " + shirt.getId());

        Product as = new Product();
        as.setDescription("Addidas Shoe");
        as.setImageUrl("www.adidas.com");
        as.setProductId("202");
        as.setPrice(new BigDecimal("50"));
        productRepository.save(as);

        log.info("Saved Shoe - id:" + as.getId());
        
        Product phone = new Product();
        phone.setDescription("Apple IPHONE14 MAX");
        phone.setImageUrl("www.apple.com");
        phone.setProductId("203");
        phone.setPrice(new BigDecimal("900"));
        productRepository.save(phone);

        log.info("Saved Phone - id:" + phone.getId());
    }
}
