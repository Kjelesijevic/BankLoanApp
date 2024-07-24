package com.sapfioneer.bankloans;

import com.sapfioneer.bankloans.controller.BankLoanController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = BankLoansApplication.class)
@WebMvcTest(BankLoanController.class)
public class BankLoanControllerTest {

}
