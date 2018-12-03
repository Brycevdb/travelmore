package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.PaymentMethod;
import be.thomasmore.travelmore.service.PaymentMethodService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PaymentMethodController {

    @Inject
    PaymentMethodService paymentMethodService;

    public List<PaymentMethod> getPaymentMethods() {
        return this.paymentMethodService.findAllPaymentMethods();
    }
}
