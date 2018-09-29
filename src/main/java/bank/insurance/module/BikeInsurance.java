package bank.insurance.module;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bank.insurance.model.Insurance;

/**
 *
 * @author caydogdu
 *
 */
public class BikeInsurance implements Insurance {

    private static final Logger logger = LoggerFactory.getLogger(BikeInsurance.class);

    static final double RISK = 0.3;

    final BigDecimal minCoverage = BigDecimal.valueOf(0);

    final BigDecimal maxCoverage = BigDecimal.valueOf(3000);

    @Override
    public BigDecimal calculatePrice(BigDecimal coverage) {
        if (!(coverage.compareTo(minCoverage) > 0 && coverage.compareTo(maxCoverage) < 0)) {
            if (logger.isErrorEnabled()) {
                logger.error("coverage : " + coverage.toString() + ", range : [" + minCoverage.toString() + "-"
                        + maxCoverage + "]");
                logger.error("The coverage for Bike is not in the range");
            }
            return null;
        }
        return coverage.multiply(BigDecimal.valueOf(RISK));
    }

}
