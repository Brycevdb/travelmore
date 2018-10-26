package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Period;
import be.thomasmore.travelmore.repository.PeriodRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PeriodService {
    @Inject
    private PeriodRepository periodRepository;

    public Period findPeriodById(int id) {
        return periodRepository.findById(id);
    }

    public List<Period> findAllPeriods() {
        return periodRepository.findAll();
    }

    public void insert(Period period) {
        periodRepository.insert(period);
    }
}
