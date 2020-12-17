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

    TaskConfigFilterDto toDto(RpcFindTaskConfigListWithPaginationReq rpcFindTaskConfigListWithPaginationReq);

    @Mappings({
            @Mapping(target = "recordsList", source = "records"),
    })
    RpcTaskConfigListPaginationResult fromDto(Pagination<TaskConfigDto> taskConfigDtoPagination);

    RpcTaskConfig fromDto(TaskConfigDto taskConfigDto);

    @Mappings({
            @Mapping(target = "genderList", source = "gender"),
            @Mapping(target = "regionCodeList", source = "regionCode")
    })
    RpcTaskConfigUserConfig fromDto(TaskConfigUserConfigDto taskConfigUserConfigDto);

    TaskConfigDto toDto(RpcTaskConfig rpcTaskConfig);

    @Mappings({
            @Mapping(target = "gender", source = "genderList"),
            @Mapping(target = "regionCode", source = "regionCodeList")
    })
    TaskConfigUserConfigDto toDto(RpcTaskConfigUserConfig rpcTaskConfigUserConfig);

}
