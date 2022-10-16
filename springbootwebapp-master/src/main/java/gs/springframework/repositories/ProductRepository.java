package gs.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import gs.springframework.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
