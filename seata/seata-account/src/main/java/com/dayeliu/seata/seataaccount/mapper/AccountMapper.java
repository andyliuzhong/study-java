package com.dayeliu.seata.seataaccount.mapper;

import com.dayeliu.seata.seataaccount.entities.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuch
 * @date 2020/10/10 - 23:24
 */
@Mapper
public interface AccountMapper {
    Account selectByUserId(@Param("userId") String userId);

    int updateById(@Param("account") Account record);
}
