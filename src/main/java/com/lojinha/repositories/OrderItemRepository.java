package com.lojinha.repositories;

import com.lojinha.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Aqui a annotation @Repository se torna opcional pq a classe
 * UserRepository ja esta herdando de JpaRepository que já esta registrada como componente do Spring
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
