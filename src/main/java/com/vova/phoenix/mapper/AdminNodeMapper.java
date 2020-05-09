package com.vova.phoenix.mapper;

import com.vova.phoenix.model.repository.AdminNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminNodeMapper extends Mapper<AdminNode> {
    List<AdminNode> selectAll();
}