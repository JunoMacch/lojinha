package com.lojinha.repositories;

import com.lojinha.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Aqui a annotation @Repository se torna opcional pq a classe
 * CategoryRepository ja esta herdando de JpaRepository que já esta registrada como componente do Spring
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
