package com.jianshengd.room_db.olddb.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
public @interface Table {
    /**
     * 表名
     *
     * @return
     * @author jianshengd
     * @date 2018-2-27
     */
    public String name();
}
