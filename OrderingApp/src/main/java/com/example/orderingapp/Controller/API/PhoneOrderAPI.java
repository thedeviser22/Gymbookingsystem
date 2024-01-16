package com.example.orderingapp.Controller.API;

import com.example.orderingapp.Domain.PhoneOrder;
import com.example.orderingapp.Repository.PhoneOrderRepository;
import com.example.orderingapp.Service.PhoneOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class PhoneOrderAPI {
    @Autowired
    PhoneOrderRepository phoneOrderRepository;
    @Autowired
    PhoneOrderService phoneOrderService;

    @GetMapping("/phoneOrder")
    public ResponseEntity<List<PhoneOrder>> getAllPhoneOrder() {
        return ResponseEntity.ok().body(phoneOrderService.getAllPhoneOrders());
    }
    @GetMapping
    public ResponseEntity<PhoneOrder> getPhoneOrderById(@PathVariable long id){
        return ResponseEntity.ok().body(phoneOrderService.getPhoneOrderById(id));
    }
    @PostMapping("/phoneOrder")
    public ResponseEntity<PhoneOrder> savePhoneOrder(@RequestBody PhoneOrder phoneOrder){
        return ResponseEntity.ok().body(phoneOrderService.savePhoneOrder(phoneOrder));
    }
    @PutMapping("/phoneOrder/{id}")
    public ResponseEntity<PhoneOrder> updateOrder(@PathVariable long id, @RequestBody PhoneOrder phoneOrder){
        return ResponseEntity.ok().body(phoneOrderService.updatePhoneOrder(phoneOrder));
    }
    @DeleteMapping("/phoneOrder/{id}")
    public HttpStatus deletePhoneOrder(@PathVariable long id ){
        phoneOrderService.deletePhoneOrder(id);
        return HttpStatus.OK;
    }
}
