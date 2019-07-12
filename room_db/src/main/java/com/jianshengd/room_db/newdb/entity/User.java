package com.jianshengd.room_db.newdb.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * 操作员（包括四类操作员）
 *
 * @author CB
 * @date 2015/4/23
 */
@Entity(tableName = "T_USER")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Long id;
    /**
     * 操作员号
     */
    @ColumnInfo(name = "USER_NO")
    private String userNo;

    /**
     * 密码
     */
    @ColumnInfo(name = "PASSWORD")
    private String password;

    /**
     * 操作员类别
     */
    @ColumnInfo(name = "USER_TYPE")
    private Integer userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
