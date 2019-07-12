package com.jianshengd.room_db.olddb.entity;


import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;

/**
 * 结算数据表
 *
 * @author chenkh
 * @date 2015/5/23
 */
@Table(name = "T_SETTLEMENT")
public class OldSettlement {
    @Column(name = "ID", primaryKey = true)
    private Long id;

    /**
     * 结算累计类型,参考 {com.newland.payment.common.TransConst.SettlementTableTypeConst}中的类型定义
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 卡别（0-内卡，1-外卡）
     */
    @Column(name = "ORGANIZATION")
    private Integer organization;

    /**
     * 金额
     */
    @Column(name = "AMOUNT")
    private Long amount;


    /**
     * 笔数
     */
    @Column(name = "NUM")
    private Integer num;

    /**
     * 优惠金额 wallct_c
     */
    @Column(name = "DISCOUNTAMT")
    private Long discountAmt;
    /**
     * 实付金额
     */
    @Column(name = "ACTUALAMT")
    private Long actualAmt;

    public Long getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Long discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Long getActualAmt() {
        return actualAmt;
    }

    public void setActualAmt(Long actualAmt) {
        this.actualAmt = actualAmt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
