package com.phoenix.message.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import tk.mybatis.mapper.annotation.LogicDelete;

@Data
@Table(name = "auth_user")
public class AuthUser implements Serializable {
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
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 是否删除
     */
    @Column(name = "deleted")
    @LogicDelete
    private Integer deleted;

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

    public static final String USERNAME = "username";

    public static final String DB_USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String DB_PASSWORD = "password";

    public static final String REAL_NAME = "realName";

    public static final String DB_REAL_NAME = "real_name";

    public static final String EMAIL = "email";

    public static final String DB_EMAIL = "email";

    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    public static final String DELETED = "deleted";

    public static final String DB_DELETED = "deleted";

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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}