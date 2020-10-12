package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Order;
import tacos.User;
import tacos.data.OrderRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }


    @GetMapping("/current")
    public String orderForm(Model model, @AuthenticationPrincipal User user) {

        addUserInfoToModel(model, user);

        return "order_form";
    }

    private void addUserInfoToModel(Model model, User user) {
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("street", user.getStreet());
        model.addAttribute("city", user.getCity());
        model.addAttribute("state", user.getState());
        model.addAttribute("zip", user.getZip());
    }

    /*
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("order", new Order());
    }
     */

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors, SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors())
            return "order_form";

        order.setUser(user);

        orderRepo.save(order);

        log.info("Order submitted: " + order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
