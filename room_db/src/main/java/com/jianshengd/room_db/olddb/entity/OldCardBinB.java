package com.jianshengd.room_db.olddb.entity;


import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;

/**
 * 卡binB数据
 *
 * @author unknow
 */
@Table(name = "T_Card_BIN_B")
public class OldCardBinB {

    @Column(name = "ID", primaryKey = true)
    private Integer id;

    /**
     * 卡bin
     */
    @Column(name = "CARD_BIN", unique = true)
    private String cardBin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin;
    }
}
