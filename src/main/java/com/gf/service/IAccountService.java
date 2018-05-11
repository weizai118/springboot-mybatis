package com.gf.service;

import com.gf.entity.Account;

import java.util.List;

/**
 * <p>Title: IAccountService</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-03-30 12:51
 */
public interface IAccountService {

    int add(String name , double money);

    int update(String name , double money , int id);

    int delete(int id);

    Account findAccount(int id);

    List<Account> findAccountList();

}
