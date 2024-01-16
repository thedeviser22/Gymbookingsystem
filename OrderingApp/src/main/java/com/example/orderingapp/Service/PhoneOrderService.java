package com.example.orderingapp.Service;

import com.example.orderingapp.Domain.PhoneOrder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PhoneOrderService {
    PhoneOrder savePhoneOrder(PhoneOrder phoneOrder);
    PhoneOrder getPhoneOrderById(long Id);
    List<PhoneOrder> getAllPhoneOrders();
    PhoneOrder updatePhoneOrder(PhoneOrder phoneorder);
    void deletePhoneOrder(long Id);

}
