package com.youran.generate.data;


import com.youran.common.util.SafeUtil;
import com.youran.generate.pojo.dto.MetaEntityAddDTO;
import com.youran.generate.pojo.dto.MetaEntityUpdateDTO;
import com.youran.generate.pojo.po.MetaEntityPO;

import static com.youran.generate.pojo.example.MetaEntityExample.*;

/**
 * Title:测试数据
 * Description:
 * Author: cbb
 * Create Time:2017/5/12 15:21
 */
public class MetaEntityData {

    /**
     * 生成add测试数据
     * @return
     */
    public static MetaEntityAddDTO getAddDTO(Integer projectId, int i){
        MetaEntityAddDTO dto = new MetaEntityAddDTO();
        dto.setProjectId(projectId);
        dto.setSchemaName(E_SCHEMANAME);
        dto.setClassName(E_CLASSNAME+i);
        dto.setTableName(E_TABLENAME+i);
        dto.setDesc(E_DESC+i);
        dto.setTitle(E_TITLE+i);
        dto.setCommonCall(SafeUtil.getInteger(E_COMMONCALL));
        return dto;
    }


    /**
     * 生成update测试数据
     * @return
     */
    public static MetaEntityUpdateDTO getUpdateDTO(MetaEntityPO metaEntity){
        MetaEntityUpdateDTO dto = new MetaEntityUpdateDTO();
        dto.setProjectId(metaEntity.getProjectId());
        dto.setEntityId(metaEntity.getEntityId());
        dto.setSchemaName(metaEntity.getSchemaName()+"1");
        dto.setClassName(metaEntity.getClassName()+"1");
        dto.setTableName(metaEntity.getTableName()+"1");
        dto.setTitle(metaEntity.getTitle()+"1");
        dto.setDesc(metaEntity.getDesc()+"1");
        dto.setCommonCall(metaEntity.getCommonCall());
        return dto;
    }

}