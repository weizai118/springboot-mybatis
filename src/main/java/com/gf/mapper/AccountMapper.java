package com.gf.mapper;

import com.gf.entity.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>Title: AccountMapper</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-03-30 11:32
 */
@Mapper
public interface AccountMapper {


    @Insert("insert into account(name , money) values (#{name},#{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update( "update account set name = #{name} , money = #{money} where id = ${id} " )
    int update(@Param( "name" )String name , @Param( "money" )double money , @Param( "id" )int id);

    @Delete( "delete from account where id = ${id}" )
    int delete(@Param( "id" )int id);

    @Select( "select id , name , money from account where id = ${id}" )
    Account findAccount(@Param( "id" )int id);

    @Select( "select id , name , money from account" )
    List<Account> findAccountList();

}
