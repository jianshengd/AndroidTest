package com.jianshengd.room_db.olddb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;
import com.jianshengd.room_db.olddb.entity.OldBlackCard;
import com.jianshengd.room_db.olddb.entity.OldCardBinA;
import com.jianshengd.room_db.olddb.entity.OldCardBinB;
import com.jianshengd.room_db.olddb.entity.OldCardBinC;
import com.jianshengd.room_db.olddb.entity.OldEmvFailWater;
import com.jianshengd.room_db.olddb.entity.OldReverseWater;
import com.jianshengd.room_db.olddb.entity.OldScriptResult;
import com.jianshengd.room_db.olddb.entity.OldSettlement;
import com.jianshengd.room_db.olddb.entity.OldUser;

import java.lang.reflect.Field;

/**
 * 数据库工具
 *
 * @author jianshengd
 * @date 2018/3/2
 */
public class DbHelper extends SQLiteOpenHelper {
    private static DbHelper sHelper;
    private static final String TAG = DbHelper.class.getName();
    /**
     * 数据库名称
     */
    private static final String DB_NAME = "test.db";
    /**
     * 数据库版本号
     */
    private static final int DB_VERSION = 5;

    public static synchronized DbHelper getInstance(Context context) {
        if (sHelper == null) {
            sHelper = new DbHelper(context);
        }
        return sHelper;
    }

    private DbHelper(Context context) {
        //创建数据库
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(getCreateTableSql(OldBlackCard.class));
            db.execSQL(getCreateTableSql(OldCardBinA.class));
            db.execSQL(getCreateTableSql(OldCardBinB.class));
            db.execSQL(getCreateTableSql(OldCardBinC.class));
            db.execSQL(getCreateTableSql(OldSettlement.class));
            db.execSQL(getCreateTableSql(OldUser.class));
            db.execSQL(getCreateTableSql(OldReverseWater.class));
            db.execSQL(getCreateTableSql(OldScriptResult.class));
            db.execSQL(getCreateTableSql(OldEmvFailWater.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    private String getCreateTableSql(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();
        String idColumn = "";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Column c = field.getAnnotation(Column.class);
            if (c != null && c.primaryKey()) {
                idColumn = c.name();
                break;
            }
        }

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS ");
        sqlBuilder.append(tableName);
        sqlBuilder.append(" ( ");

        sqlBuilder.append("\"").append(idColumn).append("\"  ").append("INTEGER PRIMARY KEY AUTOINCREMENT,");

        fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Column c = field.getAnnotation(Column.class);
            if (c != null && !c.primaryKey()) {
                sqlBuilder.append("\"").append(c.name()).append("\"  ");

                sqlBuilder.append(getDBColumnType(field));

                if (c.unique()) {
                    sqlBuilder.append(" UNIQUE");
                }
                sqlBuilder.append(",");
            }
        }
        sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
        sqlBuilder.append(" )");

        return sqlBuilder.toString();
    }

    private String getDBColumnType(Field field) {
        Class<?> javaType = field.getType();
        if (javaType == Integer.class) {
            return "INTEGER";
        } else if (javaType == Long.class) {
            return "INTEGER";
        } else if (javaType == String.class) {
            return "VARCHAR(" + field.getAnnotation(Column.class).len() + ")";
        } else {
            return "VARCHAR(" + field.getAnnotation(Column.class).len() + ")";
        }
    }

}
