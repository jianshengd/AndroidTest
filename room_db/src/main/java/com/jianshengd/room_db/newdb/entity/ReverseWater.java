package com.jianshengd.room_db.newdb.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 冲正数据,
 * <p>冲正流水在数据库单中只会存在一条</p>
 *
 * @author linchunhui
 * @date 2015/5/12
 */
@Entity(tableName = "T_REVERSE_WATER")
public class ReverseWater {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Long id;


    /**
     * 交易类型
     */
    @ColumnInfo(name = "TRANS_TYPE")
    private Integer transType;


    /**
     * 交易属性，取值参考 {@link com.nlutils.common.TransConst.TransAttr}的定义
     */
    @ColumnInfo(name = "TRANS_ATTR")
    private Integer transAttr;

    /**
     * 主账号
     */
    @ColumnInfo(name = "PAN")
    private String pan;

    /**
     * 处理码
     */
    @ColumnInfo(name = "PROC_CODE")
    private String procCode;

    /**
     * 交易金额
     */
    @ColumnInfo(name = "AMOUNT")
    private Long amount;

    /**
     * POS流水号
     */
    @ColumnInfo(name = "TRACE")
    private String trace;

    /**
     * 二维码数据域
     */
    @ColumnInfo(name = "FIELD_59")
    private String field59;


    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Integer getTransAttr() {
        return transAttr;
    }

    public void setTransAttr(Integer transAttr) {
        this.transAttr = transAttr;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }

    public String getCardSerialNo() {
        return cardSerialNo;
    }

    public void setCardSerialNo(String cardSerialNo) {
        this.cardSerialNo = cardSerialNo;
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    public String getOldAuthCode() {
        return oldAuthCode;
    }

    public void setOldAuthCode(String oldAuthCode) {
        this.oldAuthCode = oldAuthCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getInputModeForTransIn() {
        return inputModeForTransIn;
    }

    public void setInputModeForTransIn(String inputModeForTransIn) {
        this.inputModeForTransIn = inputModeForTransIn;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getField55() {
        return field55;
    }

    public void setField55(String field55) {
        this.field55 = field55;
    }

    public String getField60() {
        return field60;
    }

    public void setField60(String field60) {
        this.field60 = field60;
    }

    public String getField61() {
        return field61;
    }

    public void setField61(String field61) {
        this.field61 = field61;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getField59() {
        return field59;
    }


    public void setField59(String field59) {
        this.field59 = field59;
    }


    /**
     * 卡有效期
     */
    @ColumnInfo(name = "EXP_DATE")
    private String expDate;

    /**
     * 输入模式
     */
    @ColumnInfo(name = "INPUT_MODE")
    private String inputMode;

    /**
     * 卡序列号
     */
    @ColumnInfo(name = "CARD_SERIAL_NO")
    private String cardSerialNo;

    /**
     * 25.服务点条件代码
     */
    @ColumnInfo(name = "SERVER_CODE")
    private String serverCode;

    /**
     * 38.授权码
     * <p>上送包的授权码</p>
     */
    @ColumnInfo(name = "OLD_AUTH_CODE")
    private String oldAuthCode;

    /**
     * 39.响应码
     * <p>冲正原因</p>
     */
    @ColumnInfo(name = "RESPONSE")
    private String response;


    /**
     * 48. 转入卡的输入模式
     * <p>48域用法五</p>
     */
    @ColumnInfo(name = "INPUT_MODE_FOR_TRANS_IN")
    private String inputModeForTransIn;

    /**
     * 49.货币代码
     */
    @ColumnInfo(name = "CURRENCY_CODE")
    private String currencyCode;


    @ColumnInfo(name = "FIELD_55")
    private String field55;

    @ColumnInfo(name = "FIELD_60")
    private String field60;

    @ColumnInfo(name = "FIELD_61")
    private String field61;

    @ColumnInfo(name = "ADDITION")
    private String addition;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


}
