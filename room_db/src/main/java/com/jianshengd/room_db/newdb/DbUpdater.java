package com.jianshengd.room_db.newdb;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.migration.Migration;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.jianshengd.room_db.newdb.entity.CardBinA;
import com.jianshengd.room_db.newdb.entity.CardBinB;
import com.jianshengd.room_db.newdb.entity.CardBinC;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 数据库升级工具
 *
 * @author jianshengd
 * @date 2019/7/15 13:42
 */
class DbUpdater {
    /**数据库升级5->6*/
    final static Migration MIGRATION5_6 = new Migration(5,6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportDb) {
            //流水表插入“REMARKS”字段
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN REMARKS t");
            //流水表插入新的电子签名、免密、免签标志的列名
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN ELEC_SIGN_FLAG INTEGER");
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN NO_ELEC_SIGN_FLAG INTEGER");
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN NO_PIN_FLAG INTEGER");
            Cursor cursor = supportDb.query("SELECT * FROM t_water",null);
            if (cursor !=null){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    //修改电子签名标志
                    String flag = cursor.getString(cursor.getColumnIndex("SIGNATURE_FLAG"));
                    if ("true".equals(flag)){
                        supportDb.execSQL("update t_water set ELEC_SIGN_FLAG = 1");
                    }else if ("false".equals(flag)){
                        supportDb.execSQL("update t_water set ELEC_SIGN_FLAG = 0");
                    }
                    //修改免签标志
                    flag = cursor.getString(cursor.getColumnIndex("NO_SIGN_FLAG"));
                    if ("true".equals(flag)){
                        supportDb.execSQL("update t_water set NO_ELEC_SIGN_FLAG = 1");
                    }else if ("false".equals(flag)){
                        supportDb.execSQL("update t_water set NO_ELEC_SIGN_FLAG = 0");
                    }
                    //修改免密标志
                    flag = cursor.getString(cursor.getColumnIndex("NO_PSW_FLAG"));
                    if ("true".equals(flag)){
                        supportDb.execSQL("update t_water set NO_PIN_FLAG = 1");
                    }else if ("false".equals(flag)){
                        supportDb.execSQL("update t_water set NO_PIN_FLAG = 0");
                    }
                    cursor.moveToNext();
                }
            }
        }
    };
    /**数据库升级4->5*/
    final static Migration MIGRATION4_5 = new Migration(4,5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportDb) {

        }
    };
    /**数据库升级3->4*/
    final static Migration MIGRATION3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportDb) {
            //流水表插入新字段
            //年份
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN YEAR TEXT");
            //外部订单号
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN OUT_ORDER_NO TEXT");
            //付款码
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN QR_TRACE_NO TEXT");
            //扫码付款凭证号
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN QR_PAY_NO TEXT");
            //59域
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN field59 TEXT");
            //银联钱包 积分
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN WALLETBONUS TEXT");
            //真实金额
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN ACTUALPAYAMT TEXT");
            //优惠券信息
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN QUANDATA TEXT");
            //tl日期
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN TLDATE TEXT");
            //tl批次号
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN TLBATCH TEXT");
            //tl凭证号
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN TLTRACE TEXT");
            //卡付金额
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN CARDPAYAMOUNT TEXT");
            //优惠金额
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN COUPONAMOUNT TEXT");
            //打印内容
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN COUPONNOTES TEXT");
            //电子票名称
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN TICKETNAME TEXT");
            //电子票张数
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN TICKETCOUNT TEXT");
            //支付渠道
            supportDb.execSQL("ALTER TABLE t_water ADD COLUMN CHANNEL TEXT");

            //结算表新增字段
            //优惠金额
            supportDb.execSQL("ALTER TABLE T_SETTLEMENT ADD COLUMN DISCOUNTAMT TEXT");
            //实付金额
            supportDb.execSQL("ALTER TABLE T_SETTLEMENT ADD COLUMN ACTUALAMT TEXT");

            //创建binA、B、C表
            supportDb.execSQL(getCreateTableSql(CardBinA.class));
            supportDb.execSQL(getCreateTableSql(CardBinB.class));
            supportDb.execSQL(getCreateTableSql(CardBinC.class));
        }
    };

    //****************************************************************************************************************************

    /**
     * 数据库插入字段
     *
     * @param supportDb 数据库工具
     * @param clz       表对象
     * @param columns   新增字段名
     */
    static void addColumn(SupportSQLiteDatabase supportDb, Class<?> clz, String... columns) {
        String table = clz.getAnnotation(Entity.class).tableName();
        Field[] fields = clz.getDeclaredFields();

        Map<String, Class> items = new ArrayMap<>();
        for (String column : columns) {
            for (Field field : fields) {
                ColumnInfo columnInfo = field.getAnnotation(ColumnInfo.class);
                if (columnInfo == null) {
                    continue;
                }
                if (column.equals(columnInfo.name())) {
                    items.put(column, field.getType());
                    break;
                }
            }
        }
        for (Map.Entry<String, Class> entry : items.entrySet()) {
            String name = entry.getKey();
            String typeName = getDbType(entry.getValue());
            supportDb.execSQL("ALTER TABLE "+table+" ADD COLUMN "+name+" "+typeName);
        }
    }

    /**
     * 获取创建表SQL语句
     *
     * @param clazz 表类
     * @return sql 语句
     */
    private static String getCreateTableSql(Class<?> clazz) {
        Entity entity = clazz.getAnnotation(Entity.class);
        String tableName = entity.tableName();
        //主键
        String primaryKey = null;
        //主键自增
        boolean isAutoInc = false;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            PrimaryKey p = field.getAnnotation(PrimaryKey.class);
            ColumnInfo c = field.getAnnotation(ColumnInfo.class);
            if (p != null) {
                //找到主键，跳出循环
                primaryKey = c.name();
                isAutoInc = p.autoGenerate();
                break;
            }
        }
        // e.g. CREATE TABLE IF NOT EXISTS T_Card_BIN_A ('ID' INTEGER PRIMARY KEY AUTOINCREMENT,
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS ");
        sqlBuilder.append(tableName);
        sqlBuilder.append(" ('");
        sqlBuilder.append(primaryKey);
        sqlBuilder.append("' INTEGER PRIMARY KEY");
        if (isAutoInc){
            sqlBuilder.append("AUTOINCREMENT,");
        }else{
            sqlBuilder.append(",");
        }
        for (Field field : fields) {
            ColumnInfo c = field.getAnnotation(ColumnInfo.class);
            if (c != null && field.getAnnotation(PrimaryKey.class) == null) {
                //添加列表字段
                String type = getDbType(field.getType());
                String name = c.name();
                // e.g. 'CARD_BIN' TEXT,
                sqlBuilder.append("'");
                sqlBuilder.append(name);
                sqlBuilder.append("'  ");
                sqlBuilder.append(type);
                sqlBuilder.append(",");
            }
        }
        sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
        sqlBuilder.append(" )");
        return sqlBuilder.toString();
    }

    /**
     * 返回数据库类型
     * @param javaType java类型
     * @return 数据库类型
     */
    private static String getDbType(Class<?> javaType) {
        if (javaType == Integer.class || javaType == Boolean.class
                || javaType == Long.class || javaType == Byte.class || javaType == Short.class) {
            return "INTEGER";
        } else if (javaType == int.class || javaType == boolean.class
                || javaType == long.class || javaType == byte.class||javaType == short.class) {
            return "INTEGER DEFAULT 0 NOT NULL";
        } else if (javaType == String.class) {
            return "TEXT";
        } else if (javaType == Float.class || javaType == Double.class) {
            return "REAL";
        }else if (javaType == float.class || javaType == double.class) {
            return "REAL DEFAULT 0.00 NOT NULL";
        } else {
            return "INTEGER";
        }
    }
}
