package com.youran.generate.pojo.po.chart.source.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youran.generate.pojo.dto.chart.source.JoinDTO;
import com.youran.generate.pojo.po.BasePO;
import com.youran.generate.pojo.po.chart.source.MetaChartSourcePO;

/**
 * 图表数据项
 *
 * @author cbb
 * @date 2020/04/04
 */
public class MetaChartSourceItemPO extends BasePO {

    /**
     * 主键ID
     */
    private Integer sourceItemId;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 所属数据源id
     */
    private Integer sourceId;

    /**
     * 关联实体序号
     */
    private Integer joinIndex;

    /**
     * 数据项类型
     *
     * @see com.youran.generate.constant.SourceItemType
     */
    private Integer type;

    /**
     * 父数据项id
     */
    private Integer parentId;

    /**
     * 特性json
     */
    private String feature;

    /**
     * 所属数据源
     */
    @JsonIgnore
    private transient MetaChartSourcePO chartSource;
    /**
     * 所属关联
     */
    @JsonIgnore
    private transient JoinDTO join;
    /**
     * 父数据项
     */
    @JsonIgnore
    private transient MetaChartSourceItemPO parent;

    /**
     * 装配数据项
     *
     * @param chartSource
     */
    public void assembleItem(MetaChartSourcePO chartSource) {
        this.chartSource = chartSource;
        if(this.joinIndex > 0){
            this.join = this.chartSource.getJoins().get(this.joinIndex - 1);
        }
    }

    /**
     * 反序列化特性json
     * 从json字符串中解析出dto信息
     */
    public void featureDeserialize() {
        throw new RuntimeException("未实现");
    }

    /**
     * 序列化特性json
     * 将dto信息序列化成json字符串
     */
    public void featureSerialize() {
        throw new RuntimeException("未实现");
    }

    public Integer getSourceItemId() {
        return this.sourceItemId;
    }

    public void setSourceItemId(Integer sourceItemId) {
        this.sourceItemId = sourceItemId;
    }

    public Integer getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFeature() {
        return this.feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public MetaChartSourceItemPO getParent() {
        return parent;
    }

    public void setParent(MetaChartSourceItemPO parent) {
        this.parent = parent;
    }

    public Integer getJoinIndex() {
        return joinIndex;
    }

    public void setJoinIndex(Integer joinIndex) {
        this.joinIndex = joinIndex;
    }

    public JoinDTO getJoin() {
        return join;
    }

    public void setJoin(JoinDTO join) {
        this.join = join;
    }

    public MetaChartSourcePO getChartSource() {
        return chartSource;
    }

    public void setChartSource(MetaChartSourcePO chartSource) {
        this.chartSource = chartSource;
    }
}
