package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Payments;
import be.thomasmore.travelmore.repository.PaymentsRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PaymentsService {
    @Inject
    private PaymentsRepository paymentsRepository;

    public Payments findPaymentById(int id){
        return paymentsRepository.findById(id);
    }
    public List<Payments> findAllPayments(){
        return paymentsRepository.findAll();
    }
}
