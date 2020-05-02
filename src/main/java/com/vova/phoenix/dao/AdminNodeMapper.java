package com.vova.phoenix.dao;

import com.vova.phoenix.model.repository.AdminNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface AdminNodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_node
     *
     * @mbg.generated
     */
    int insert(AdminNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_node
     *
     * @mbg.generated
     */
    List<AdminNode> selectAll();
}