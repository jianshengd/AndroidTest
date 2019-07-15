package com.jianshengd.room_db.newdb.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.jianshengd.room_db.newdb.entity.BlackCard;
import com.jianshengd.room_db.newdb.entity.CardBinA;
import com.jianshengd.room_db.newdb.entity.CardBinB;
import com.jianshengd.room_db.newdb.entity.CardBinC;
import com.jianshengd.room_db.newdb.entity.EmvFailWater;
import com.jianshengd.room_db.newdb.entity.ReverseWater;
import com.jianshengd.room_db.newdb.entity.ScriptResult;
import com.jianshengd.room_db.newdb.entity.Settlement;
import com.jianshengd.room_db.newdb.entity.User;

/**
 * Created by Administrator on 2019/7/11
 */
@Dao
public interface NewCommonDao {

    @Query("SELECT * FROM T_Card_BIN_A ORDER BY id DESC LIMIT 1")
    CardBinA findA();

    @Query("SELECT * FROM T_Card_BIN_B ORDER BY id DESC LIMIT 1")
    CardBinB findB();


    @Query("SELECT * FROM T_Card_BIN_C ORDER BY id DESC LIMIT 1")
    CardBinC findC();

    @Query("SELECT * FROM T_BLACK_CARD ORDER BY id DESC LIMIT 1")
    BlackCard findBlack();

    @Query("SELECT * FROM T_SETTLEMENT ORDER BY id DESC LIMIT 1")
    Settlement findSettle();

    @Query("SELECT * FROM T_USER ORDER BY id DESC LIMIT 1")
    User findUser();

    @Query("SELECT * FROM T_REVERSE_WATER ORDER BY id DESC LIMIT 1")
    ReverseWater findReverseWater();


    @Query("SELECT * FROM T_EMV_FIAL_WATER ORDER BY id DESC LIMIT 1")
    EmvFailWater findEmvFail();


    @Query("SELECT * FROM t_script_result ORDER BY id DESC LIMIT 1")
    ScriptResult findScript();


}
