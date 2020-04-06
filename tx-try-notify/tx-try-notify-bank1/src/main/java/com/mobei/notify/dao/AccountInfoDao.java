package com.mobei.notify.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountInfoDao {

    /**
     * 修改账户金额
     *
     * @param accountNo
     * @param amount
     * @return
     */
    @Update("update account_info set account_balance=account_balance+#{amount} where account_no=#{accountNo}")
    int updateAccountBalance(@Param("accountNo") String accountNo, @Param("amount") Double amount);

    /**
     * 查询幂等记录，用于幂等控制
     *
     * @param txNo
     * @return
     */
    @Select("select count(1) from de_duplication where tx_no = #{txNo}")
    int isExistTx(String txNo);

    /**
     * 添加事务记录，用于幂等控制
     *
     * @param txNo
     * @return
     */
    @Insert("insert into de_duplication values(#{txNo},now());")
    int addTx(String txNo);

}
