package com.phoenix.message.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import tk.mybatis.mapper.annotation.LogicDelete;

@Data
@Table(name = "auth_role")
public class AuthRole implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 父节点id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * code
     */
    @Column(name = "code")
    private String code;

    /**
     * 接口path
     */
    @Column(name = "path")
    private String path;

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
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String PARENT_ID = "parentId";

    public static final String DB_PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String CODE = "code";

    public static final String DB_CODE = "code";

    public static final String PATH = "path";

    public static final String DB_PATH = "path";

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
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", path=").append(path);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}