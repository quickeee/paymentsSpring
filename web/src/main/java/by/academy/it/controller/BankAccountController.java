package by.academy.it.controller;

import by.academy.it.service.IBankAccountService;
import by.academy.it.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.academy.it.resources.constant.Constants.*;

/**
 * Created by sam on 20.06.2015.
 */
@Controller
public class BankAccountController {

    @Autowired
    private IBankAccountService bankAccountService;

    @Autowired
    private IOrderService orderService;

//    @Autowired
//    private IOrderService orderService;

    @RequestMapping(value = "/blockBankAccount", method = RequestMethod.POST)
    public String blockBankAccount(
            @RequestParam(PARAM_CLIENT_BANK_ACCOUNT_ID) int bankAccountID,
            @RequestParam(PARAM_BANK_ACCOUNT_BLOCKED) boolean blockBankAccount) {
        bankAccountService.blockBankAccount(bankAccountID, blockBankAccount);
        return "";
    }

    @RequestMapping(value = "/payOrder", method = RequestMethod.POST)
    public String payOrder(
            @RequestParam(PARAM_ORDER_BANK_ACCOUNT_ID) int bankAccountID,
            @RequestParam(PARAM_ORDER_ID) int orderID) {

        bankAccountService.payOrder(bankAccountID, orderID);
        return "";
    }

    @RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
    public String transferMoney(
            @RequestParam(PARAM_BANK_ACCOUNT_ID) int srcBankAccountID,
            @RequestParam(PARAM_BANK_ACCOUNT_TRANSFER_ID) int dstBankAccountID,
            @RequestParam(PARAM_BANK_ACCOUNT_TRANSFER_SUM) double sumForTransfer) {

        if ((srcBankAccountID != dstBankAccountID) && (sumForTransfer > 0)) {
            bankAccountService.transferMoney(dstBankAccountID, srcBankAccountID, sumForTransfer);
        }
        return "";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(
            @RequestParam(PARAM_ORDER_BANK_ACCOUNT_ID) int bankAccountID,
            @RequestParam(PARAM_ORDER_SUM) double sumOrder) {

        orderService.addOrder(bankAccountID, sumOrder);
//        bankAccountService.blockBankAccount(bankAccountID, blockBankAccount);
        return "";
    }


}
