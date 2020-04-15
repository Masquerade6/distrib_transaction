package com.mobei.tx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LocalTxDao {
    /**
     * 更新账户金额
     * @return
     */
    @Update("insert into local_tx(name) values(#{name})")
    int insert(@Param("name") String name);
}
