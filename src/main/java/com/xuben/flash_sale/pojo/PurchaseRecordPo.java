package com.xuben.flash_sale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

@Alias("purchaseRecord")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRecordPo implements Serializable {
    private static final long serialVersionUID = -360816189433370174L ;
    private Long id;
    private Long userId;
    private Long productId ;
    private double price ;
    private int quantity ;
    private double sum;
    private Timestamp purchaseTime;
    private String note;
}

