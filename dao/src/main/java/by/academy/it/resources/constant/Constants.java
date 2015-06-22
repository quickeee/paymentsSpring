package by.academy.it.resources.constant;

/**
 * Created by Sam on 17.04.2015.
 */
public class Constants {

    public static final String PATH_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String ADDRESS_JDBC = "jdbc:mysql://localhost:3306/payments";
    public static final String PARAM_LOGIN = "root";
    public static final String PARAM_PASS = "admin";

    public static final String PARAM_SESSION_USER_LAST_NAME = "userLastName";
    public static final String PARAM_SESSION_USER_LOGIN = "userLoginID";
    public static final String PARAM_SESSION_ROLE_USER = "role";

    public static final String PARAM_PAGE = "page";

    public static final String SQL_INSERT_CLIENT = "INSERT INTO clients (login,password,first_name,last_name,bank_id,role_id) values (?,?,?,?,?,?)";
    public static final String SQL_INSERT_CREDIT_CARD = "INSERT INTO credit_cards () VALUES()";
    public static final String SQL_INSERT_BANK_ACCOUNT = "INSERT INTO bank_accounts (valid, blocked, credit_card_id, sum) VALUES (?,?,?,?)";
    public static final String SQL_INSERT_ORDERS = "INSERT INTO orders (bank_account_id, sum, paid) VALUES (?,?,?);";


    public static final String SQL_GET_CREDIT_CARD = "SELECT credit_cards.id FROM credit_cards,bank_accounts WHERE (bank_accounts.id = ?) AND (bank_accounts.credit_card_id = credit_cards.id);";
    public static final String SQL_GET_CLIENT_ITEM = "SELECT * FROM clients WHERE (login = ?)";
    public static final String SQL_GET_CLIENT_ITEM_BY_BANK_ACCOUNT = "SELECT * FROM clients WHERE (bank_id = ?)";
    public static final String SQL_GET_BANK_ACCOUNT_ITEM = "SELECT * FROM bank_accounts WHERE (id = ?)";
    public static final String SQL_GET_BANK_ACCOUNT_ID_LIST = "SELECT id FROM bank_accounts";
    public static final String SQL_GET_CLIENTS = "SELECT * FROM clients";
    public static final String SQL_GET_ORDER_ITEM = "SELECT * FROM orders WHERE (id = ?)";
    public static final String SQL_GET_ORDER_LIST = "SELECT * FROM orders";
    public static final String SQL_GET_ORDER_LIST_BY_BANK_ACCOUNT = "SELECT * FROM orders WHERE (bank_account_id = ?)";

    public static final String SQL_DELETE_CREDIT_CARD = "DELETE FROM credit_cards WHERE id=?";
    public static final String SQL_DELETE_BANK_ACCOUNT = "DELETE FROM bank_accounts WHERE id=?";
    public static final String SQL_DELETE_CLIENT_ACCOUNT = "DELETE FROM clients WHERE login=?";
    public static final String SQL_DELETE_ORDER = "DELETE FROM orders WHERE id=?";

    public static final String SQL_BLOCK_BANK_ACCOUNT = "UPDATE bank_accounts SET blocked=? WHERE id=?";
    public static final String SQL_BANK_ACCOUNT_TRANSFER_MONEY = "UPDATE bank_accounts SET sum=? WHERE id=?";
    public static final String SQL_ORDER_PAID = "UPDATE orders SET paid=? WHERE id=?";

    public static final int ROLE_ADMINISTRATOR = 0;
    public static final int ROLE_CLIENT = 1;
    public static final int ROLE_GUEST = 2;

    public static final int INVALID_PARAM = -1;

    public static final String PARAM_CLIENTS = "clients";
    public static final String PARAM_CLIENT_ITEM = "client";
    public static final String PARAM_CLIENT_ID = "clientID";
    public static final String PARAM_CLIENT_LOGIN = "login";
    public static final String PARAM_CLIENT_PASSWORD = "password";
    public static final String PARAM_CLIENT_FIRST_NAME = "firstName";
    public static final String PARAM_CLIENT_LAST_NAME = "lastName";
    public static final String PARAM_CLIENT_ROLE = "role";
    public static final String PARAM_CLIENT_BANK_ACCOUNT_ID = "bankAccountID";

    public static final String PARAM_BANK_ACCOUNT_ITEM = "bankAccount";
    public static final String PARAM_BANK_ACCOUNT_ID = "id";
    public static final String PARAM_BANK_ACCOUNT_SUM = "sum";
    public static final String PARAM_BANK_ACCOUNT_VALID = "valid";
    public static final String PARAM_BANK_ACCOUNT_BLOCKED = "blocked";
    public static final String PARAM_BANK_ACCOUNT_CREDIT_CARD_ID = "creditCardID";

    public static final String PARAM_ORDER_ID = "id";
    public static final String PARAM_ORDER_BANK_ACCOUNT_ID = "bankAccountID";
    public static final String PARAM_ORDER_SUM = "sum";
    public static final String PARAM_ORDER_LIST = "orderList";


    public static final String PARAM_CREDIT_CARD_ID = "id";

    public static final String PARAM_BANK_ACCOUNT_TRANSFER_ID = "bankAccountTransferID";
    public static final String PARAM_BANK_ACCOUNT_TRANSFER_SUM = "bankAccountTransferSum";
    public static final String PARAM_BANK_ACCOUNT_TRANSFER_ID_LIST = "bankAccountIDTransferList";



//    public static final String SQL_INSERT_AUTHOR = "INSERT INTO authors (id,pass,first_name,last_name) values (?,?,?,?)";
//    public static final String SQL_GET_AUTHORS = "SELECT * FROM authors";

//    public static final String PARAM_AUTHORS = "authors";
//    public static final String PARAM_AUTHORS_ID = "id";
//    public static final String PARAM_AUTHORS_PASS = "password";
//    public static final String PARAM_AUTHORS_FIRST_NAME = "firstName";
//    public static final String PARAM_AUTHORS_LAST_NAME = "lastName";

//    public static final String PARAM_TIDINGS = "tidings";
//    public static final String PARAM_TIDINGS_ID = "id";
//    public static final String PARAM_TIDINGS_AUTHOR_ID = "authorID";
//    public static final String PARAM_TIDINGS_TITLE = "title";
//    public static final String PARAM_TIDINGS_DESCRIPTION = "discription";
//    public static final String PARAM_TIDINGS_TIDING = "tiding";

//    public static final String SQL_GET_TIDINGS = "SELECT * FROM tidings";
//    public static final String SQL_INSERT_TIDING = "INSERT INTO tidings (author_id,title,description,tiding) values (?,?,?,?)";
//    public static final String SQL_READ_TIDING = "SELECT * FROM tidings WHERE ";

//    public static final String PAGE_CREATE_AUTHOR = "/pages/createAuthor.jsp";
//    public static final String PAGE_LIST_AUTHORS = "/pages/listAuthors.jsp";
//    public static final String PAGE_LIST_TIDINGS = "/pages/listTidings.jsp";
    public static final String PAGE_TILES_WELCOME = "welcome";
    public static final String PAGE_TILES_LOGIN = "login";
    public static final String PAGE_TILES_REGISTRATION = "registration";
    public static final String PAGE_TILES_ADMIN_INFO_CLIENT = "clientControlService";
    public static final String PAGE_TILES_USER_INFO_CLIENT = "profileClient";
    public static final String PAGE_TILES_LIST_CLIENTS = "listClients";


    public static final String PAGE_LIST_CLIENTS = "/pages/listClients.jsp";
    public static final String PAGE_CLIENT_INFO = "/pages/clientInfo.jsp";
    public static final String PAGE_LOGIN = "/pages/login.jsp";
    public static final String PAGE_PROFILE_CLIENT = "/pages/profileClient.jsp";
    public static final String PAGE_CONTROL_SERVICE_CLIENT = "/pages/clientControlService.jsp";
    public static final String PAGE_LIST_ORDERS = "/pages/listOrder.jsp";

    public static final String PAGE_MAIN = "/index.jsp";

}
