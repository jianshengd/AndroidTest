package com.jianshengd.room_db.olddb.entity;


import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;

/**
 * 黑名单中的卡bin
 *
 * @author chenkh
 * @date 2015/5/29
 */
@Table(name = "T_BLACK_CARD")
public class OldBlackCard {

    @Column(name = "ID", primaryKey = true)
    private Integer id;

    /**
     * 卡bin
     */
    @Column(name = "CARD_BIN")
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
