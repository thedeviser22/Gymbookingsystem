package com.example.orderingapp.Service;

import com.example.orderingapp.Domain.PhoneOrder;
import com.example.orderingapp.Repository.PhoneOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneOrderImpl implements PhoneOrderService {
    @Autowired
   PhoneOrderRepository phoneOrderRepository;

    @Override
    public PhoneOrder savePhoneOrder(PhoneOrder phoneOrder) {
        return phoneOrderRepository.save(phoneOrder);
    }

    @Override
    public PhoneOrder getPhoneOrderById(long Id) {
        Optional<PhoneOrder> phoneOrder = phoneOrderRepository.findById(Id);
        PhoneOrder emptyPhoneOrder = null;
        if (phoneOrder.isPresent()) {
            emptyPhoneOrder = phoneOrder.get();
            return emptyPhoneOrder;
        }
        else {
            throw new RuntimeException("Order not found");
        }
    }
    @Override
    public List<PhoneOrder> getAllPhoneOrders() {
        return phoneOrderRepository.findAll();
    }

    @Override
    public PhoneOrder updatePhoneOrder(PhoneOrder phoneOrder) {
        Optional<PhoneOrder> optionalPhoneOrder = phoneOrderRepository.findById(phoneOrder.getId());
        if (optionalPhoneOrder.isPresent()) {
            PhoneOrder updatePhoneOrder = new PhoneOrder();
            updatePhoneOrder.setContact(phoneOrder.getContact());
            updatePhoneOrder.setPhoneName(phoneOrder.getPhoneName());
            updatePhoneOrder.setId(phoneOrder.getId());
            updatePhoneOrder.setPrice(phoneOrder.getPrice());
            updatePhoneOrder.setQuantity(phoneOrder.getQuantity());
            updatePhoneOrder.setName(phoneOrder.getName());
            phoneOrderRepository.save(updatePhoneOrder);
            return updatePhoneOrder;

        }
        else{
            throw new RuntimeException("Order not Available");
        }
    }
    @Override
    public void deletePhoneOrder(long Id) {
        phoneOrderRepository.deleteById(Id);

    }
}
