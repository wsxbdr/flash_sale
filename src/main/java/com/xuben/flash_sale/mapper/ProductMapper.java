package com.xuben.flash_sale.mapper;

import com.xuben.flash_sale.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    //获取产品
    ProductPo getProduct(Long id);

    //减库存
    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
