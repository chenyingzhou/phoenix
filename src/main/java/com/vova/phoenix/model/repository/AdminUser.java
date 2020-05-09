package com.vova.phoenix.model.repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "admin_user")
public class AdminUser implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户角色类型:0-管理员1-普通用户
     */
    @Column(name = "role_id")
    private Byte roleId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 管理员
     */
    private Byte admin;

    /**
     * vova/airyclub
     */
    @Column(name = "app_platform")
    private String appPlatform;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态0-启用1-禁用
     */
    private Byte status;

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

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String ROLE_ID = "roleId";

    public static final String DB_ROLE_ID = "role_id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String REAL_NAME = "realName";

    public static final String DB_REAL_NAME = "real_name";

    public static final String ADMIN = "admin";

    public static final String DB_ADMIN = "admin";

    public static final String APP_PLATFORM = "appPlatform";

    public static final String DB_APP_PLATFORM = "app_platform";

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", name=").append(name);
        sb.append(", realName=").append(realName);
        sb.append(", admin=").append(admin);
        sb.append(", appPlatform=").append(appPlatform);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static AdminUser defaultInstance() {
        AdminUser instance = new AdminUser();
        instance.roleId = new Byte("0");
        instance.name = new String("");
        instance.realName = new String("");
        instance.admin = new Byte("0");
        instance.appPlatform = new String("vova");
        instance.email = new String("");
        instance.password = new String("");
        instance.status = new Byte("0");
        instance.operatorId = new Integer("0");
        return instance;
    }
}