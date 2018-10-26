package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Period;
import be.thomasmore.travelmore.service.PeriodService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PeriodController {
    private Period newPeriod = new Period();

    @Inject
    private PeriodService periodService;

    public Period getNewPeriod() {
        return newPeriod;
    }

    public void setNewPeriod(Period newPeriod) {
        this.newPeriod = newPeriod;
    }

    public List<Period> getPeriods() {
        return this.periodService.findAllPeriods();
    }

    public Period findPeriodById(int id) {
        return this.periodService.findPeriodById(id);
    }

    public void submit() {
        this.periodService.insert(newPeriod);
    }
}
