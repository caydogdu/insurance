package bank.insurance.rest;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.insurance.service.InsuranceService;

@RestController
@RequestMapping(value = "/tariffs")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @RequestMapping(method = RequestMethod.GET)
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    public String getTariff(@RequestParam(value = "module") String module,
            @RequestParam(value = "coverage") String coverage) {

        BigDecimal result = insuranceService.calculate(module, new BigDecimal(coverage));
        return result.toString();
    }
}
