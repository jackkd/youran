package com.youran.generate.template.context.chart;

import com.youran.generate.pojo.dto.chart.ChartItemDTO;
import com.youran.generate.pojo.po.MetaProjectPO;
import com.youran.generate.pojo.po.chart.DetailListPO;
import com.youran.generate.pojo.po.chart.source.item.DetailColumnPO;

import java.util.List;

/**
 * 明细表上下文对象
 *
 * @author: cbb
 * @date: 2020-04-12
 */
public class DetailListContext extends AbstractChartContext<DetailListPO> {

    /**
     * 明细列
     */
    private final List<ChartItemDTO<DetailColumnPO>> columnList;
    /**
     * 默认每页记录数
     */
    private final Integer defaultPageSize;
    /**
     * 是否支持excel导出
     */
    private final Boolean excelExport;

    public DetailListContext(MetaProjectPO project, DetailListPO detailList) {
        super(project, detailList);
        this.columnList = detailList.getColumnList();
        this.defaultPageSize = detailList.getDefaultPageSize();
        this.excelExport = detailList.getExcelExport();
    }

    public List<ChartItemDTO<DetailColumnPO>> getColumnList() {
        return columnList;
    }

    public Integer getDefaultPageSize() {
        return defaultPageSize;
    }

    public Boolean getExcelExport() {
        return excelExport;
    }
}
