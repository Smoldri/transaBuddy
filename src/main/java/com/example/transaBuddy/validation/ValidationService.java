package com.example.transaBuddy.validation;


//import ee.bcs.ourBank.domain.account.Account;
//import ee.bcs.ourBank.domain.customer.Customer;
//import ee.bcs.ourBank.infrastructure.exception.BusinessException;
//import ee.bcs.ourBank.infrastructure.exception.DataNotFoundException;

import com.example.transaBuddy.infrastructure.exception.DataNotFoundException;
import com.example.transaBuddy.domain.user.userrole.UserRole;
import com.example.transaBuddy.temp.User;

import java.util.List;
import java.util.Optional;

public class ValidationService {

    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String USER_NOT_EXISTS = "Sellist kasutajat ei eksisteeri";

    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";
    public static final String MINIMUM_DEPOSIT_REQUIREMENT = "Miinumum deposiidi nõue";
    public static final Integer MINIMUM_DEPOSIT_AMOUNT = 5;

    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";

    public static void validatePasswordUserExists(List<UserRole> userRoles) {
        if (userRoles.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellise kasutajanime ja parooliga kontot ei eksisteeri ");
        }
    }
    public static void validateUserExists(Optional<User> user,Integer userId){
        if (user.isEmpty()){
            throw new DataNotFoundException(USER_NOT_EXISTS, "Sellist kasutajat ID'ga " + userId + " ei leitud");
        }
    }

//    public static void validateCustomerExists(Optional<Customer> customer, Integer customerId) {
//        if (customer.isEmpty()) {
//            throw new DataNotFoundException(CUSTOMER_NOT_EXISTS, "Sellist klienti ID'ga " + customerId + " ei leitud");
//        }
//    }
//
//    public static void validateAccountExists(Optional<Account> account, Integer accountId) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellist kontot ID'ga " + accountId + " ei leitud");
//        }
//    }
//
//    public static void validateAccountExists(Optional<Account> account, String accountNumber) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellist kontot kontonubriga " + accountNumber + " ei leitud");
//        }
//    }
//
//    public static void validateEnoughBalance(Integer amount, Account account) {
//        if (account.getBalance() - amount < 0) {
//            throw new BusinessException(INSUFFICIENT_FUNDS, "Kontol " + account.getAccountNumber() +
//                    " pole piisavalt vahendeid. Kontojääk on: " + account.getBalance());
//        }
//    }
//
//    public static void validateDepositAmount(Integer amount) {
//        if (amount < MINIMUM_DEPOSIT_AMOUNT) {
//            throw new BusinessException(MINIMUM_DEPOSIT_REQUIREMENT, "Miinimum deposiit alates €" + MINIMUM_DEPOSIT_AMOUNT);
//        }
//    }
//

}
