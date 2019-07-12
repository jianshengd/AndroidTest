package com.jianshengd.room_db.olddb.entity;


import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;

import java.util.Locale;

/**
 * 交易流水
 *
 * @author chenkh
 * @date 2015/5/6
 */
@Table(name = "t_water")
public class OldWater {
    @Column(name = "ID", primaryKey = true)
    private Integer id;


    /**
     * 电子签名标志
     */
    @Column(name = "SIGNATURE_FLAG")
    private Boolean signatureFlag;
//    /**
//     * 免签标志
//     */
//    @Column(name = "NO_SIGN_FLAG")
//    private Boolean noSignFlag;
//    /**
//     * 免密标志
//     */
//    @Column(name = "NO_PSW_FLAG")
//    private Boolean noPswFlag;


    public Boolean getSignatureFlag() {
        return signatureFlag;
    }

    public void setSignatureFlag(Boolean signatureFlag) {
        this.signatureFlag = signatureFlag;
    }
}
