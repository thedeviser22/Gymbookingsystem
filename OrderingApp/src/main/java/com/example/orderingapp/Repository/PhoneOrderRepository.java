package com.example.orderingapp.Repository;

import com.example.orderingapp.Domain.PhoneOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneOrderRepository extends JpaRepository<PhoneOrder,Long> {

}
