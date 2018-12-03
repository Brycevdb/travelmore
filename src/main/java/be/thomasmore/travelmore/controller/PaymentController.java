package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Payments;
import be.thomasmore.travelmore.service.PaymentsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class PaymentController {

    @Inject
    PaymentsService paymentsService;

    public List<Payments> getPayments() {
        return this.paymentsService.findAllPayments();
    }
}
