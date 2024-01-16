package com.example.orderingapp.Controller;

import com.example.orderingapp.Domain.PhoneOrder;
import com.example.orderingapp.Service.PhoneOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhoneOrderController {
    @Autowired
    PhoneOrderService phoneOrderService;

    @GetMapping("/PhoneHomepage")
    public String homePage(Model model){
        model.addAttribute("phoneOrder",phoneOrderService.getAllPhoneOrders());
        return "home";

    }
    @GetMapping("/ShowOrderForm")
    public String showOrderForm(Model model){
        PhoneOrder phoneOrder = new PhoneOrder();
        model.addAttribute("phoneOrder",phoneOrder);
        model.addAttribute("nextPage","New Order");
        return "New_Order";

    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("phoneOrder") PhoneOrder phoneOrder, RedirectAttributes redirectAttributes){
       phoneOrderService.savePhoneOrder(phoneOrder);
        redirectAttributes.addFlashAttribute("message", "Order update");
        redirectAttributes.addFlashAttribute("color", "success");

        return "redirect:/PhoneHomepage";
    }
    @GetMapping("/updateOrder/{id}")
    public String showEditForm(@PathVariable("id") Integer Id, Model model, RedirectAttributes redirectAttributes) {
        try {
            PhoneOrder phoneOrder= phoneOrderService.getPhoneOrderById(Id);
            model.addAttribute("phoneOrder", phoneOrder);
            model.addAttribute("pageTitle", "Edit Order Id:" + Id);
            return "updateOrder";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");

            return "redirect:/PhoneHomepage";
        }
    }
    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute("phoneOrder") PhoneOrder phoneOrder, RedirectAttributes redirectAttributes){
        try {
            phoneOrderService.savePhoneOrder(phoneOrder);
            redirectAttributes.addFlashAttribute("message", "Order updated successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating Order: " + e.getMessage());
        }
        return "redirect:/PhoneHomepage";
    }
    @GetMapping("deleteOrder/{id}")
    public String deletePhoneOrder(@PathVariable long Id, RedirectAttributes redirectAttributes) {
        try {
            phoneOrderService.deletePhoneOrder(Id);
            redirectAttributes.addFlashAttribute("message", "Order Deleted successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/PhoneHomepage";
    }
}

