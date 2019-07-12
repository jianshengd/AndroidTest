package com.jianshengd.room_db.newdb.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Locale;


/**
 * 交易流水
 *
 * @author chenkh
 * @date 2015/5/6
 */
@Entity(tableName = "t_water")
public class Water {
    //设置主键，并且定义自增增
    @PrimaryKey(autoGenerate = true)
    //数据库记录唯一值
    @ColumnInfo(name = "ID")
    private Integer id;

    /**
     * 电子签名标志
     */
    @ColumnInfo(name = "SIGNATURE_FLAG")
    private String signatureFlag;
//    /**
//     * 免签标志
//     */
//    @ColumnInfo(name = "NO_SIGN_FLAG")
//    private String noSignFlag;
//    /**
//     * 免密标志
//     */
//    @ColumnInfo(name = "NO_PSW_FLAG")
//    private String noPswFlag;
    // TODO

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignatureFlag() {
        return signatureFlag;
    }

    public void setSignatureFlag(String signatureFlag) {
        this.signatureFlag = signatureFlag;
    }
}
