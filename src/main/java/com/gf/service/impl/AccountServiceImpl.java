package com.gf.service.impl;

import com.gf.entity.Account;
import com.gf.mapper.AccountMapper;
import com.gf.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: AccountServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-03-30 12:54
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int add(String name, double money) {
        return accountMapper.add( name , money );
    }

    @Override
    public int update(String name, double money , int id) {
        return accountMapper.update( name , money , id );
    }

    @Override
    public int delete(int id) {
        return accountMapper.delete( id );
    }

    @Override
    public Account findAccount(int id) {
        return accountMapper.findAccount( id );
    }

    @Override
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
