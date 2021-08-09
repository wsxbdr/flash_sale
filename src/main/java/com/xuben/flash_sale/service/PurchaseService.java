package com.xuben.flash_sale.service;

import com.xuben.flash_sale.pojo.PurchaseRecordPo;

import java.util.List;

public interface PurchaseService {

    boolean purchase(Long userId, Long productId, int quantity);

    boolean purchaseRedis(Long userId, Long productId, int quantity);

    boolean dealRedisPurchase(List<PurchaseRecordPo> prpList);

}
