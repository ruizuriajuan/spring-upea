package com.ruizuria.ecommerce.repository;

import com.ruizuria.ecommerce.dto.OrderItemDto;
import com.ruizuria.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT SUM(p.price * oi.quantity) "
            + "FROM orders o "
            + "JOIN order_items oi ON oi.id_order  = o.id "
            + "JOIN products p ON  p.id = oi.id_product "
            + "WHERE o.id = ?1", nativeQuery = true)
    BigDecimal getTotalPriceByOrderId(Integer orderId);

    @Query("SELECT SUM(p.price * oi.quantity) "
            + "FROM Order o "
            + "JOIN o.items oi "
            + "JOIN oi.product p "
            + "WHERE o.id = ?1")
    BigDecimal getTotalPrice(Integer orderId);

    @Query("SELECT new com.ruizuria.ecommerce.dto.OrderItemDto(p.id, oi.quantity, new java.math.BigDecimal (p.price * oi.quantity)) "
                    + "FROM Order o "
                    + "JOIN o.items oi "
                    + "JOIN oi.product p "
                    + "WHERE o.id = ?1")
    List<OrderItemDto> getItemsWithTotalPrice(Integer orderId);

}
