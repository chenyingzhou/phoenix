package com.phoenix.message.web.mapstruct;

import com.phoenix.message.common.mapstruct.BaseMapStruct;
import com.phoenix.message.proto.*;
import com.phoenix.message.web.model.BaseResponse;
import com.phoenix.message.web.model.provider.TaskConfig;
import com.phoenix.message.web.model.provider.TaskConfigUserConfig;
import com.phoenix.message.web.model.request.TaskConfigListReq;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TaskConfigMapStruct extends BaseMapStruct, WrapperConverter {
    TaskConfigMapStruct INSTANCE = Mappers.getMapper(TaskConfigMapStruct.class);

    RpcFindTaskConfigListWithPaginationReq toRpc(TaskConfigListReq taskConfigListReq);

    BaseResponse<BaseResponse.Pagination<TaskConfig>> fromRpc(RpcFindTaskConfigListWithPaginationResp rpcFindTaskConfigListWithPaginationResp);

    @Mappings({
            @Mapping(target = "records", source = "recordsList")
    })
    BaseResponse.Pagination<TaskConfig> fromRpc(RpcTaskConfigListPaginationResult rpcTaskConfigListPaginationResult);

    @Mappings({
            @Mapping(target = "gender", source = "genderList"),
            @Mapping(target = "regionCode", source = "regionCodeList")
    })
    TaskConfigUserConfig fromRpc(RpcTaskConfigUserConfig rpcTaskConfigUserConfig);

    BaseResponse<TaskConfig> fromRpc(RpcFindTaskConfigByIdResp rpcFindTaskConfigByIdResp);

}
