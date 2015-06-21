package by.academy.it.controller;

import by.academy.it.bean.impl.ClientControlBean;
import by.academy.it.bean.impl.ClientListBean;
import by.academy.it.bean.impl.OrderBean;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Client;
import by.academy.it.entity.Order;
import by.academy.it.service.IBankAccountService;
import by.academy.it.service.IClientService;
import by.academy.it.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.academy.it.resources.constant.Constants.*;

/**
 * Created by sam on 20.06.2015.
 */

@Controller
public class ClientController {


    @Autowired
    private IBankAccountService bankAccountService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/controlClient", method = RequestMethod.POST)
    public ModelAndView controlClient(
            @RequestParam(PARAM_ORDER_BANK_ACCOUNT_ID) int bankAccountID,
            @RequestParam(PARAM_ORDER_SUM) double sumOrder) {

        Client client = clientService.getClientByBankAccountID(bankAccountID);
        BankAccount bankAccount = bankAccountService.getBankAccount(bankAccountID);
        List<Order> orderList = orderService.getOrderListByBankAccount(bankAccountID);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("clientBean", prepareClientBean(client, bankAccount, orderList));

        return new ModelAndView("clientControlService", model);
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public String createClient(
            @RequestParam(PARAM_CLIENT_LOGIN) String login,
            @RequestParam(PARAM_CLIENT_PASSWORD) String password,
            @RequestParam(PARAM_CLIENT_FIRST_NAME) String firstName,
            @RequestParam(PARAM_CLIENT_LAST_NAME) String lastName) {


        return "welcome";
    }

    @RequestMapping(value = "/controlClient", method = RequestMethod.POST)
    public ModelAndView listClient() {
        List<Client> clientList = clientService.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put(PARAM_CLIENTS, prepareClientListBean(clientList));
        return new ModelAndView(PAGE_LIST_CLIENTS, model);
    }

    @RequestMapping(value = "/profileClient", method = RequestMethod.POST)
    public ModelAndView profileClient(
            @RequestParam(PARAM_CLIENT_LOGIN) String login){
        Client client = clientService.getClientByLogin(login);
        BankAccount bankAccount = bankAccountService.getBankAccount(client.getBankAccountID());
        List<Order> orderList = orderService.getOrderListByBankAccount(client.getBankAccountID());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("clientBean", prepareClientBean(client, bankAccount, orderList));

        model.put(PARAM_BANK_ACCOUNT_TRANSFER_ID_LIST, bankAccountService.getBankAccountIDList());

        return new ModelAndView(PAGE_PROFILE_CLIENT, model);
    }

    /*
    private Employee prepareModel(ClientBean employeeBean){
        Employee employee = new Employee();
        employee.setEmpAddress(employeeBean.getAddress());
        employee.setEmpAge(employeeBean.getAge());
        employee.setEmpName(employeeBean.getName());
        employee.setSalary(employeeBean.getSalary());
        employee.setEmpId(employeeBean.getId());
        employeeBean.setId(null);
        return employee;
    }*/
/*
    private List<ClientBean> prepareListOfBean(List<Client> employees){
        List<EmployeeBean> beans = null;
        if(employees != null && !employees.isEmpty()){
            beans = new ArrayList<EmployeeBean>();
            EmployeeBean bean = null;
            for(Employee employee : employees){
                bean = new EmployeeBean();
                bean.setName(employee.getEmpName());
                bean.setId(employee.getEmpId());
                bean.setAddress(employee.getEmpAddress());
                bean.setSalary(employee.getSalary());
                bean.setAge(employee.getEmpAge());
                beans.add(bean);
            }
        }
        return beans;
    }
*/
    private ClientControlBean prepareClientBean(Client client, BankAccount bankAccount, List<Order> orderList) {
        ClientControlBean clientControlBean = new ClientControlBean();
        clientControlBean.setClientID(client.getId());
        clientControlBean.setLogin(client.getLogin());
        clientControlBean.setFirstName(client.getFirstName());
        clientControlBean.setLastName(client.getLastName());
        clientControlBean.setBankAccountID(client.getBankAccountID());
        clientControlBean.setBlocked(bankAccount.isBlocked());
        clientControlBean.setSum(bankAccount.getSum());
        clientControlBean.setCreditCardID(bankAccount.getCreditCardID());
        for (Order order : orderList) {
            OrderBean orderBean = new OrderBean();
            orderBean.setId(order.getId());
            orderBean.setSum(order.getSum());
            orderBean.setPaid(order.isPaid());
            clientControlBean.getOrderList().add(orderBean);
        }
        return clientControlBean;
    }

    private List<ClientListBean> prepareClientListBean(List<Client> clientList) {
        List<ClientListBean> beanList = new ArrayList<ClientListBean>();
        for (Client client : clientList) {
            ClientListBean bean = new ClientListBean();
            bean.setId(client.getId());
            bean.setLogin(client.getLogin());
            bean.setFirstName(client.getFirstName());
            bean.setLastName(client.getLastName());
            beanList.add(bean);
        }
        return beanList;
    }


}
