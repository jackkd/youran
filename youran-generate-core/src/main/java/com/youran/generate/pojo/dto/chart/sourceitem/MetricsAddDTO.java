package com.youran.generate.pojo.dto.chart.sourceitem;

import com.youran.common.validator.Const;
import com.youran.generate.constant.AggFunction;
import com.youran.generate.constant.CustomFieldType;
import com.youran.generate.constant.SourceItemSubType;
import com.youran.generate.constant.SourceItemType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 新增【指标】入参
 *
 * @author: cbb
 * @date: 2020-04-04
 */
@ApiModel(description = "新增【指标】入参")
public class MetricsAddDTO extends AbstractSourceItemDTO {

    @ApiModelProperty(notes = "数据项子类型", example = "31", required = true, allowableValues = "31,32")
    @NotNull
    @Const(constClass = SourceItemSubType.class)
    private Integer subType;

    @ApiModelProperty(notes = "字段id", example = "1")
    private Integer fieldId;

    @ApiModelProperty(notes = "别名", example = "alias1")
    private String alias;

    @ApiModelProperty(notes = "聚合函数", example = "1", allowableValues = AggFunction.VALUES_STR)
    @Const(constClass = AggFunction.class)
    private Integer aggFunction;

    @ApiModelProperty(notes = "是否自定义", example = "true", required = true)
    @NotNull
    private Boolean custom;

    @ApiModelProperty(notes = "自定义内容")
    private String customContent;

    @ApiModelProperty(notes = "自定义字段类型", example = "1", allowableValues = CustomFieldType.VALUES_STR)
    @Const(constClass = CustomFieldType.class)
    private Integer customFieldType;


    @Override
    public Integer getType() {
        return SourceItemType.METRICS.getValue();
    }

    @Override
    public Integer getSubType() {
        return this.subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getAggFunction() {
        return aggFunction;
    }

    public void setAggFunction(Integer aggFunction) {
        this.aggFunction = aggFunction;
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public String getCustomContent() {
        return customContent;
    }

    public void setCustomContent(String customContent) {
        this.customContent = customContent;
    }

    public Integer getCustomFieldType() {
        return customFieldType;
    }

    public void setCustomFieldType(Integer customFieldType) {
        this.customFieldType = customFieldType;
    }
}
