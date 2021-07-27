package com.xuben.flash_sale.mapper;

import com.xuben.flash_sale.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRecordMapper {
    int insertPurchaseRecord(PurchaseRecordPo pr);
}
