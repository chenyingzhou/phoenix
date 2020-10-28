package com.phoenix.message.web.mapper;

import com.phoenix.message.proto.RpcFindTaskConfigListResp;
import com.phoenix.message.proto.RpcPaginationResult;
import com.phoenix.message.web.model.FindTaskConfigResp;
import com.phoenix.message.web.model.PaginationResult;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TaskConfigMapper {
    TaskConfigMapper INSTANCE = Mappers.getMapper(TaskConfigMapper.class);

    FindTaskConfigResp toPojo(RpcFindTaskConfigListResp rpcFindTaskConfigListResp);

    @Mappings({
            @Mapping(source = "listList", target = "list")
    })
    PaginationResult toPojo(RpcPaginationResult rpcPaginationResult);

    RpcFindTaskConfigListResp toProtobuf(FindTaskConfigResp findTaskConfigListResp);

    @Mappings({
            @Mapping(source = "list", target = "listList")
    })
    RpcPaginationResult toProtobuf(PaginationResult paginationResult);
}
