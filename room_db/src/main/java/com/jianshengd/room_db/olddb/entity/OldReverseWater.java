package com.jianshengd.room_db.olddb.entity;


import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;

/**
 * 冲正数据,
 * <p>冲正流水在数据库单中只会存在一条</p>
 *
 * @author linchunhui
 * @date 2015/5/12
 */
@Table(name = "T_REVERSE_WATER")
public class OldReverseWater {
    @Column(name = "ID", primaryKey = true)
    private Long id;


    /**
     * 交易类型
     */
    @Column(name = "TRANS_TYPE")
    private Integer transType;


    /**
     * 交易属性，取值参考 {@link com.nlutils.common.TransConst.TransAttr}的定义
     */
    @Column(name = "TRANS_ATTR")
    private Integer transAttr;

    /**
     * 主账号
     */
    @Column(name = "PAN")
    private String pan;

    /**
     * 处理码
     */
    @Column(name = "PROC_CODE")
    private String procCode;

    /**
     * 交易金额
     */
    @Column(name = "AMOUNT")
    private Long amount;

    /**
     * POS流水号
     */
    @Column(name = "TRACE")
    private String trace;

    /**
     * 二维码数据域
     */
    @Column(name = "FIELD_59")
    private String field59;

    public String getField59() {
        return field59;
    }


    public void setField59(String field59) {
        this.field59 = field59;
    }


    /**
     * 卡有效期
     */
    @Column(name = "EXP_DATE")
    private String expDate;

    /**
     * 输入模式
     */
    @Column(name = "INPUT_MODE")
    private String inputMode;

    /**
     * 卡序列号
     */
    @Column(name = "CARD_SERIAL_NO")
    private String cardSerialNo;

    /**
     * 25.服务点条件代码
     */
    @Column(name = "SERVER_CODE")
    private String serverCode;

    /**
     * 38.授权码
     * <p>上送包的授权码</p>
     */
    @Column(name = "OLD_AUTH_CODE")
    private String oldAuthCode;

    /**
     * 39.响应码
     * <p>冲正原因</p>
     */
    @Column(name = "RESPONSE")
    private String response;


    /**
     * 48. 转入卡的输入模式
     * <p>48域用法五</p>
     */
    @Column(name = "INPUT_MODE_FOR_TRANS_IN")
    private String inputModeForTransIn;

    /**
     * 49.货币代码
     */
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;


    @Column(name = "FIELD_55")
    private String field55;

    @Column(name = "FIELD_60")
    private String field60;

    @Column(name = "FIELD_61")
    private String field61;

    @Column(name = "ADDITION")
    private String addition;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    /**
     * 获取交易类型
     */
    public Integer getTransType() {
        return transType;
    }


    /**
     * 设置交易类型
     */
    public void setTransType(Integer transType) {
        this.transType = transType;
    }


    /**
     * 获取交易属性
     *
     * @return 取值参考 {@link com.nlutils.common.TransConst.TransAttr}的定义
     */
    public Integer getTransAttr() {
        return transAttr;
    }


    /**
     * 设置交易属性
     *
     * @param transAttr 取值参考 {@link com.nlutils.common.TransConst.TransAttr}的定义
     */
    public void setTransAttr(Integer transAttr) {
        this.transAttr = transAttr;
    }


    /**
     * 获取主账号
     */
    public String getPan() {
        return pan;
    }


    /**
     * 设置主账号
     *
     * @param pan 主账号
     */
    public void setPan(String pan) {
        this.pan = pan;
    }


    /**
     * 获取处理码
     */
    public String getProcCode() {
        return procCode;
    }


    /**
     * 设置处理码
     *
     * @param procCode 处理码
     */
    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }


    /**
     * 获取金额
     */
    public Long getAmount() {
        return amount;
    }


    /**
     * 设置金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }


    /**
     * 获取POS流水号
     */
    public String getTrace() {
        return trace;
    }


    /**
     * 设置POS流水号
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }


    /**
     * 获取卡有效期
     */
    public String getExpDate() {
        return expDate;
    }


    /**
     * 设置卡有效期
     */
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }


    /**
     * 获取输入模式
     */
    public String getInputMode() {
        return inputMode;
    }


    /**
     * 设置输入模式
     */
    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }


    /**
     * 获取卡序列号
     */
    public String getCardSerialNo() {
        return cardSerialNo;
    }


    /**
     * 设置卡序列号
     */
    public void setCardSerialNo(String cardSerialNo) {
        this.cardSerialNo = cardSerialNo;
    }


    /**
     * 获取服务点条件代码
     */
    public String getServerCode() {
        return serverCode;
    }


    /**
     * 设置服务点条件代码
     */
    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }


    /**
     * 获取授权码
     * <p>上送包的授权码</p>
     */
    public String getOldAuthCode() {
        return oldAuthCode;
    }


    /**
     * 设置授权码
     * <p>上送包的授权码</p>
     *
     * @param oldAuthCode
     */
    public void setOldAuthCode(String oldAuthCode) {
        this.oldAuthCode = oldAuthCode;
    }


    /**
     * 获取响应码
     * <p>冲正原因</p>
     */
    public String getResponse() {
        return response;
    }


    /**
     * 39.响应码
     * <p>冲正原因</p>
     */
    public void setResponse(String response) {
        this.response = response;
    }


    /**
     * 获取转入卡的输入模式
     * <p>48域用法五</p>
     */
    public String getInputModeForTransIn() {
        return inputModeForTransIn;
    }


    /**
     * 设置 转入卡的输入模式
     * <p>48域用法五</p>
     */
    public void setInputModeForTransIn(String inputModeForTransIn) {
        this.inputModeForTransIn = inputModeForTransIn;
    }


    /**
     * 获取货币代码
     */
    public String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * 设置货币代码
     */
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


}
