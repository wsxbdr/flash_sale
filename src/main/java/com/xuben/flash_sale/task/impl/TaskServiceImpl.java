package com.xuben.flash_sale.task.impl;

import com.xuben.flash_sale.service.PurchaseService;
import com.xuben.flash_sale.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private PurchaseService purchaseService;

    private static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";
    private static final String PURCHAE_PRODUCT_LIST = "purchase_list_";
    private static final int ONE_TIME_SIZE = 1000;

    @Override
    @Scheduled(cron = "0 0 1 * * ?")
    public void purchaseTask() {

    }
}
