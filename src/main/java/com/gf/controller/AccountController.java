package com.gf.controller;

import com.gf.entity.Account;
import com.gf.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title: AccountController</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-03-30 12:59
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "/list")
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccount( id );
    }

    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id , @RequestParam(value = "name" , required = true) String name , @RequestParam(value = "money" , required = true) double money){
        int num = accountService.update( name , money , id );
        if(1 == num){
            return "success";
        }else{
            return "fail";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") int id){
        int num = accountService.delete( id );
        if(1 == num){
            return "success";
        }else{
            return "fail";
        }
    }

    @PostMapping(value = "")
    public String postAccount(@RequestParam(value = "name" , required = true) String name , @RequestParam(value = "money" ,required = true) double money){
        int num = accountService.add( name , money );
        if(1 == num){
            return "success";
        }else{
            return "fail";
        }
    }

}
