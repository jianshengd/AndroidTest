package com.jianshengd.room_db.newdb.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * 卡binB数据
 *
 * @author unknow
 */
@Entity(tableName = "T_Card_BIN_B")
public class CardBinB {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Integer id;

    /**
     * 卡bin
     */
    @ColumnInfo(name = "CARD_BIN")
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
