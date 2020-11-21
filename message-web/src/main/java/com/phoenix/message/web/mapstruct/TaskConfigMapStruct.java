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

    RpcFindTaskConfigListWithPaginationReq req2RpcReq(TaskConfigListReq req);

    BaseResponse<BaseResponse.Pagination<TaskConfig>> rpcResp2Resp(RpcFindTaskConfigListWithPaginationResp rpcResp);

    @Mappings({
            @Mapping(target = "records", source = "recordsList")
    })
    BaseResponse.Pagination<TaskConfig> rpcPagination2Pagination(RpcTaskConfigListPaginationResult rpcPagination);

    @Mappings({
            @Mapping(target = "gender", source = "genderList"),
            @Mapping(target = "regionCode", source = "regionCodeList")
    })
    TaskConfigUserConfig rpcTaskConfigUserConfig2TaskConfigUserConfig(RpcTaskConfigUserConfig rpcTaskConfigUserConfig);

}
