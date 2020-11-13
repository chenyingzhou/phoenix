package com.phoenix.message.grpc.mapstruct;

import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigUserConfigDto;
import com.phoenix.message.common.mapstruct.BaseMapStruct;
import com.phoenix.message.proto.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TaskConfigMapStruct extends BaseMapStruct, WrapperConverter {
    TaskConfigMapStruct INSTANCE = Mappers.getMapper(TaskConfigMapStruct.class);

    TaskConfigFilterDto rpcFindTaskConfigListWithPaginationReq2Dto(RpcFindTaskConfigListWithPaginationReq req);

    @Mappings({
            @Mapping(target = "recordsList", source = "records"),
    })
    RpcTaskConfigListPaginationResult dto2RpcTaskConfigListPaginationResult(Pagination<TaskConfigDto> dtoPagination);

    RpcTaskConfig dto2RpcTaskConfig(TaskConfigDto taskConfigDto);

    @Mappings({
            @Mapping(target = "genderList", source = "gender"),
            @Mapping(target = "regionCodeList", source = "regionCode")
    })
    RpcTaskConfigUserConfig dto2RpcTaskConfigUserConfig(TaskConfigUserConfigDto taskConfigUserConfigDto);

}
