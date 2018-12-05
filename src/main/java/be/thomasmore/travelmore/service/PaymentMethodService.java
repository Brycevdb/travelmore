package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.PaymentMethod;
import be.thomasmore.travelmore.repository.PaymentMethodRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PaymentMethodService {
    @Inject
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod findPaymentMethodById(int id){
        return paymentMethodRepository.findById(id);
    }

    public List<PaymentMethod> findAllPaymentMethods(){
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod findByName(String name) {
        return paymentMethodRepository.findByName(name);
    }
}
