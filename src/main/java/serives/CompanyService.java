package serives;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import pojos.Company;

import static utils.StringUtils.getRandomNumber;
import static utils.StringUtils.getRandomString;

@Data
@Log4j2
public class CompanyService {
    public static Company getRandomCompany() {
        Company company = new Company(getRandomString(), getRandomString(), getRandomNumber(), getRandomNumber());
        log.info(String.format("Generating random company with params: %s", company));
        return company;
    }
}
