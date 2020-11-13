package com.phoenix.message.web.mapstruct;

import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.mapstruct.BaseMapStruct;
import com.phoenix.message.proto.RpcFindTaskConfigListWithPaginationReq;
import com.phoenix.message.proto.WrapperConverter;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TaskConfigMapStruct extends BaseMapStruct, WrapperConverter {
    TaskConfigMapStruct INSTANCE = Mappers.getMapper(TaskConfigMapStruct.class);

    RpcFindTaskConfigListWithPaginationReq dto2RpcFindTaskConfigListWithPaginationReq(TaskConfigFilterDto dto);

}
