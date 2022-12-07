package by.novikgrits.webapp.controller.payment;

import by.novikgrits.webapp.model.payment.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CheckoutController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @RequestMapping("/checkout/{id}")
    public String checkout(Model model, @PathVariable String id, HttpSession session, HttpServletRequest request) {
        model.addAttribute("amount", request.getParameter("betPrice"));
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        session.setAttribute("foundAuctionId", id);
        session.setAttribute("betPrice", request.getParameter("betPrice"));
        return "checkout";
    }
}
