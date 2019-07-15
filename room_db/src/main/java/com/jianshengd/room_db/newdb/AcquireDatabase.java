package com.jianshengd.room_db.newdb;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jianshengd.room_db.newdb.dao.NewCommonDao;
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
 * 数据库
 *
 * @author jianshengd
 * @date 2019/6/24 18:30
 */
@Database(entities = {BlackCard.class, CardBinA.class, CardBinB.class, CardBinC.class,
        Settlement.class, User.class, ReverseWater.class, EmvFailWater.class,
        ScriptResult.class}, version = 6)
public abstract class AcquireDatabase extends RoomDatabase {
    /**数据库名称*/
    private final static String DB_NAME = "test.db";

    /**数据库实例，只有一个*/
    private static volatile AcquireDatabase instance;

    public static AcquireDatabase getInstance(final Context context) {
        if (instance == null){
            synchronized (AcquireDatabase.class){
                if (instance == null){
                    instance =  Room.databaseBuilder(context, AcquireDatabase.class, DB_NAME)
                            //添加数据库变动迁移
                            .addMigrations(DbUpdater.MIGRATION5_6)
                            //允许主线程进行数据库操作
                            .allowMainThreadQueries()
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase supportDb) {
                                    super.onCreate(supportDb);
                                    Log.e("db","----------------------");
                                }
                            })
                            .build();
                 }
            }
        }
        return instance;
    }
    /**
     * DAO
     */
    public abstract NewCommonDao newCommonDao();
}
