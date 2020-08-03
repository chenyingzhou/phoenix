package com.phoenix.message.common.model.po.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "admin_user")
public class AdminUser implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 管理员
     */
    @Column(name = "admin")
    private Integer admin;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户状态0-启用1-禁用
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 操作人
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * vova/airyclub
     */
    @Column(name = "app_platform_list")
    private List<String> appPlatformList;

    /**
     * push/coupon
     */
    @Column(name = "message_type_list")
    private List<String> messageTypeList;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String REAL_NAME = "realName";

    public static final String DB_REAL_NAME = "real_name";

    public static final String ADMIN = "admin";

    public static final String DB_ADMIN = "admin";

    public static final String EMAIL = "email";

    public static final String DB_EMAIL = "email";

    public static final String PASSWORD = "password";

    public static final String DB_PASSWORD = "password";

    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    public static final String OPERATOR_ID = "operatorId";

    public static final String DB_OPERATOR_ID = "operator_id";

    public static final String CREATE_TIME = "createTime";

    public static final String DB_CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "updateTime";

    public static final String DB_UPDATE_TIME = "update_time";

    public static final String APP_PLATFORM_LIST = "appPlatformList";

    public static final String DB_APP_PLATFORM_LIST = "app_platform_list";

    public static final String MESSAGE_TYPE_LIST = "messageTypeList";

    public static final String DB_MESSAGE_TYPE_LIST = "message_type_list";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", realName=").append(realName);
        sb.append(", admin=").append(admin);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", appPlatformList=").append(appPlatformList);
        sb.append(", messageTypeList=").append(messageTypeList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}