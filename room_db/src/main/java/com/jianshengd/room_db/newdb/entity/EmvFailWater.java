package com.jianshengd.room_db.newdb.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * EMV失败流水
 *
 * @author chenkh
 * @date 2015/5/27
 */
@Entity(tableName = "T_EMV_FIAL_WATER")
public class EmvFailWater {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Integer id;

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
     * Emv交易的执行结果：
     * <li>1-脱机失败</li>
     * <li>2-脱机成功</li>
     * <li>3-联机失败</li>
     * <li>4-联机成功</li>
     */
    @ColumnInfo(name = "EMV_STATUS")
    private Integer emvStatus;


    /**
     * 主账号
     */
    @ColumnInfo(name = "PAN")
    private String pan;

    /**
     * 金额
     */
    @ColumnInfo(name = "AMOUNT")
    private Long amount;


    /**
     * 交易流水
     */
    @ColumnInfo(name = "TRACE")
    private String trace;

    /**
     * 交易时间，格式：
     * <li>HHmmss</li>
     */
    @ColumnInfo(name = "TIME")
    private String time;

    /**
     * 交易日期, 格式：
     * <li>yyyymmdd</li>
     * <li>yymmdd</li>
     * <li>mmdd</li>
     */
    @ColumnInfo(name = "DATE")
    private String date;


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
     * 二磁道数据
     */
    @ColumnInfo(name = "TRACK2")
    private String track2;


    /**
     * 三磁道数据
     */
    @ColumnInfo(name = "TRACK3")
    private String track3;

    /**
     * 批次号
     */
    @ColumnInfo(name = "BATCH_NUM")
    private String batchNum;

    /**
     * 操作员号
     */
    @ColumnInfo(name = "OPER")
    private String oper;

    /**
     * 国际组织代码
     */
    @ColumnInfo(name = "INTER_ORG")
    private String interOrg;

    /**
     * 批上送标志
     * <li>0-未上送</li>
     * <li>0xFD-已上送</li>
     * <li>0xFE-上送被拒</li>
     * <li>0xFF-上送失败</li>
     * <li>其他值-已上送次数</li>
     */
    @ColumnInfo(name = "BATCH_UP_FLAG")
    private Integer batchUpFlag;

    /**
     * EMV附加内容
     */
    @ColumnInfo(name = "EMV_ADDITION")
    private String emvAddition;

    /**
     * 附加流水内容
     */
    @ColumnInfo(name = "ADDITION")
    private String addition;

    /**
     * 授权响应码(tag-8A)
     */
    @ColumnInfo(name = "EMV_AUTH_RESP")
    private String emvAuthResp;

    /**
     * 终端验证结果(tag-95)
     */
    @ColumnInfo(name = "TVR")
    private String tvr;

    /**
     * 交易状态信息(tag-9B)
     */
    @ColumnInfo(name = "TSI")
    private String tsi;

    /**
     * 55域
     */
    @ColumnInfo(name = "FIELD55")
    private String field55;

    /**
     * 货币代码
     */
    @ColumnInfo(name = "CURRENCY")
    private String currency;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getEmvStatus() {
        return emvStatus;
    }

    public void setEmvStatus(Integer emvStatus) {
        this.emvStatus = emvStatus;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getTrack3() {
        return track3;
    }

    public void setTrack3(String track3) {
        this.track3 = track3;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getInterOrg() {
        return interOrg;
    }

    public void setInterOrg(String interOrg) {
        this.interOrg = interOrg;
    }

    public Integer getBatchUpFlag() {
        return batchUpFlag;
    }

    public void setBatchUpFlag(Integer batchUpFlag) {
        this.batchUpFlag = batchUpFlag;
    }

    public String getEmvAddition() {
        return emvAddition;
    }

    public void setEmvAddition(String emvAddition) {
        this.emvAddition = emvAddition;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getEmvAuthResp() {
        return emvAuthResp;
    }

    public void setEmvAuthResp(String emvAuthResp) {
        this.emvAuthResp = emvAuthResp;
    }

    public String getTvr() {
        return tvr;
    }

    public void setTvr(String tvr) {
        this.tvr = tvr;
    }

    public String getTsi() {
        return tsi;
    }

    public void setTsi(String tsi) {
        this.tsi = tsi;
    }

    public String getField55() {
        return field55;
    }

    public void setField55(String field55) {
        this.field55 = field55;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
