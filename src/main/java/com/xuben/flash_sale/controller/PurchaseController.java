package com.xuben.flash_sale.controller;

import com.xuben.flash_sale.mapper.ProductMapper;
import com.xuben.flash_sale.pojo.ProductPo;
import com.xuben.flash_sale.service.PurchaseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class PurchaseController {
    @Value("${CUSTOM_KEY:source}")
    private String name;

    @Value("${CUSTOM_VALUE:front}")
    private String value;

    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/mv")
    public ModelAndView testPage(){
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    @PostMapping("/purchase")
    public Result purchase(Long userId, Long productId, Integer quantity){
        boolean flag = purchaseService.purchase(userId, productId, quantity);
        String message = flag ? "抢购成功" : "抢购失败";
        return new Result(flag, message);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Result{
        private boolean flag = false;
        private String message = null;
    }

    @Autowired
    ProductMapper productMapper;

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        return name+": "+value;
    }
}
