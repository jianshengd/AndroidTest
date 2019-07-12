package com.jianshengd.room_db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jianshengd.room_db.newdb.AcquireDatabase;
import com.jianshengd.room_db.newdb.dao.NewCommonDao;
import com.jianshengd.room_db.newdb.entity.ReverseWater;
import com.jianshengd.room_db.olddb.DbHelper;
import com.jianshengd.room_db.olddb.dao.OldCommonDao;
import com.jianshengd.room_db.olddb.entity.OldBlackCard;
import com.jianshengd.room_db.olddb.entity.OldCardBinA;
import com.jianshengd.room_db.olddb.entity.OldCardBinB;
import com.jianshengd.room_db.olddb.entity.OldCardBinC;
import com.jianshengd.room_db.olddb.entity.OldEmvFailWater;
import com.jianshengd.room_db.olddb.entity.OldReverseWater;
import com.jianshengd.room_db.olddb.entity.OldScriptResult;
import com.jianshengd.room_db.olddb.entity.OldSettlement;
import com.jianshengd.room_db.olddb.entity.OldUser;
import com.jianshengd.room_db.olddb.entity.OldWater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_create_old).setOnClickListener(v->{
            OldCommonDao oldCommonDao = new OldCommonDao(DbHelper.getInstance(this));

            OldBlackCard oldBlackCard = new OldBlackCard();
            oldBlackCard.setCardBin("111");
            oldCommonDao.insert(oldBlackCard);

            OldCardBinA oldCardBinA = new OldCardBinA();
            oldCardBinA.setCardBin("222");
            oldCommonDao.insert(oldCardBinA);

            OldCardBinB oldCardBinB = new OldCardBinB();
            oldCardBinB.setCardBin("333");
            oldCommonDao.insert(oldCardBinB);

            OldCardBinC oldCardBinC = new OldCardBinC();
            oldCardBinC.setCardBin("444");
            oldCommonDao.insert(oldCardBinC);

            OldSettlement settlement = new OldSettlement();
            settlement.setAmount(555L);
            oldCommonDao.insert(settlement);

            OldUser user = new OldUser();
            user.setUserNo("666");
            oldCommonDao.insert(user);

            OldReverseWater reverseWater = new OldReverseWater();
            reverseWater.setAmount(777L);
            oldCommonDao.insert(reverseWater);

            OldEmvFailWater emvFailWater = new OldEmvFailWater();
            emvFailWater.setAmount(888L);
            oldCommonDao.insert(emvFailWater);

            OldScriptResult scriptResult = new OldScriptResult();
            scriptResult.setAmount(999L);
            oldCommonDao.insert(scriptResult);

            OldWater water = new OldWater();
            water.setAmount(1L);
            oldCommonDao.insert(water);
        });
        findViewById(R.id.btn_test).setOnClickListener(v->{
            NewCommonDao newCommonDao = AcquireDatabase.getInstance(this).newCommonDao();
            TextView tvInfo = findViewById(R.id.tv_info);
            String info = newCommonDao.findA().getCardBin()
                    + newCommonDao.findB().getCardBin()
                    + newCommonDao.findC().getCardBin()
                    + newCommonDao.findBlack().getCardBin()
                    + newCommonDao.findSettle().getAmount()
                    + newCommonDao.findUser().getUserNo()
                    + newCommonDao.findReverseWater().getAmount()
                    + newCommonDao.findEmvFail().getAmount()
                    + newCommonDao.findScript().getAmount()
                    + newCommonDao.findWater().getAmount()
                    ;
            tvInfo.setText(info);
        });
    }
}
