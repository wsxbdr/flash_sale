package com.xuben.flash_sale.service;

public interface PurchaseService {

    boolean purchase(Long userId, Long productId, int quantity);
}
