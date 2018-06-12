package com.qianxun.admin.entity;

import java.util.Date;

/**
 * 用户表
 *
 * @author cloudy
 * @date 2018-06-08 12:04:33
 */
public class SysUser {
    /**
     *
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 加密后的密码
     */
    private String passwordEncrypted;
    /**
     * 状态(冻结、非冻结)
     */
    private Integer status;
    /**
     * 身份证
     */
    private String identification;
    /**
     * 重置密码的令牌
     */
    private String resetPasswordToken;
    /**
     * 令牌生成时间
     */
    private Date resetPasswordSentAt;
    /**
     * 累积登录次数
     */
    private Integer signInCount = 0;
    /**
     * 当前登录时间
     */
    private Date currentSignInAt;
    /**
     * 上一次登录时间
     */
    private Date lastSignInAt;
    /**
     *
     */
    private Date createdAt;
    /**
     *
     */
    private Date updatedAt;
    /**
     * 当前的认证令牌
     */
    private String currentToken;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordSentAt(Date resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    public Date getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public String getCurrentToken() {
        return currentToken;
    }
}