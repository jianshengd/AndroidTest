package com.jianshengd.room_db.olddb.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.jianshengd.room_db.olddb.DbHelper;
import com.jianshengd.room_db.olddb.ann.Column;
import com.jianshengd.room_db.olddb.ann.Table;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2019/7/12
 */
public class OldCommonDao {
    private DbHelper dbHelper;

    public OldCommonDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
    /**
     * 插入一条记录
     *
     * @param object 记录
     */
    public long insert(Object object) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = getColumsObject(object);
        String table = object.getClass().getAnnotation(Table.class).name();
        return db.insert(table, null, cv);
    }

    /**
     * 获取对象集合
     *
     * @param object 记录
     */
    private ContentValues getColumsObject(Object object) {
        ContentValues cv = new ContentValues();
        Field[] fds = object.getClass().getDeclaredFields();
        for (Field field : fds) {
            Column cl = field.getAnnotation(Column.class);
            if (cl != null) {
                String clName = cl.name();
                Object value = forceGetProperty(object, field.getName());
                if (value != null) {
                    cv.put(clName, value.toString());
                }
            }
        }
        return cv;
    }
    private Object forceGetProperty(Object object, String propertyName) {

        Field field = getDeclaredField(object, propertyName);

        if (field == null) {
            return null;
        }
        boolean accessible = field.isAccessible();
        field.setAccessible(true);

        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {

        }
        field.setAccessible(accessible);
        return result;
    }

    /**
     * 获取数据表列字段
     *
     * @param object       目标对象
     * @param propertyName 变量名
     */
    private static Field getDeclaredField(Object object, String propertyName) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(propertyName)) {
                return field;
            }
        }
        return null;
    }
}
