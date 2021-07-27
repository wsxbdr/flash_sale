package com.xuben.flash_sale.service.impl;

import com.xuben.flash_sale.mapper.ProductMapper;
import com.xuben.flash_sale.mapper.PurchaseRecordMapper;
import com.xuben.flash_sale.pojo.ProductPo;
import com.xuben.flash_sale.pojo.PurchaseRecordPo;
import com.xuben.flash_sale.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    PurchaseRecordMapper purchaseRecordMapper;

    @Override
    @Transactional
    public boolean purchase(Long userId, Long productId, int quantity) {
        ProductPo product = productMapper.getProduct(productId);
        if (product.getStock() < quantity) {
            return  false;
        }
        productMapper.decreaseProduct(productId,quantity);
        PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
        purchaseRecordMapper.insertPurchaseRecord(pr);
        return true;
    }

    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity){
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间"+System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
