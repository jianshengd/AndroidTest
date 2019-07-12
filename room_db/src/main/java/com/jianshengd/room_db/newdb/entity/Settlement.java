package com.jianshengd.room_db.newdb.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.util.TableInfo;

/**
 * 结算数据表
 *
 * @author chenkh
 * @date 2015/5/23
 */
@Entity(tableName = "T_SETTLEMENT")
public class Settlement {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Long id;

    /**
     * 结算累计类型,参考 {com.newland.payment.common.TransConst.SettlementTableTypeConst}中的类型定义
     */
    @ColumnInfo(name = "TYPE")
    private String type;

    /**
     * 卡别（0-内卡，1-外卡）
     */
    @ColumnInfo(name = "ORGANIZATION")
    private Integer organization;

    /**
     * 金额
     */
    @ColumnInfo(name = "AMOUNT")
    private Long amount;

    /**
     * 笔数
     */
    @ColumnInfo(name = "NUM")
    private Integer num;
    /**
     * 银联钱包 优惠金额
     */
    @ColumnInfo(name = "DISCOUNTAMT")
    private Long discountAmt;
    /**
     * 银联钱包 实付金额
     */
    @ColumnInfo(name = "ACTUALAMT")
    private Long actualAmt;

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
}
