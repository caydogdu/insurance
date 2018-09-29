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
public class ElectronicsInsurance implements Insurance {

    private static final Logger logger = LoggerFactory.getLogger(ElectronicsInsurance.class);

    static final double RISK = 0.35;

    final BigDecimal minCoverage = BigDecimal.valueOf(500);

    final BigDecimal maxCoverage = BigDecimal.valueOf(6000);

    @Override
    public BigDecimal calculatePrice(BigDecimal coverage) {
        if (!(coverage.compareTo(minCoverage) > 0 && coverage.compareTo(maxCoverage) < 0)) {
            if (logger.isErrorEnabled()) {
                logger.error("coverage : " + coverage.toString() + ", range : [" + minCoverage.toString() + "-"
                        + maxCoverage + "]");
                logger.error("The coverage for Electronics is not in the range");
            }
            return null;
        }
        return coverage.multiply(BigDecimal.valueOf(RISK));
    }

}
