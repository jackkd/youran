package com.youran.generate.pojo.dto.chart;

import com.youran.common.pojo.dto.AbstractDTO;

/**
 * 图表布局
 *
 * @author: cbb
 * @date: 2020-07-12
 */
public class LayoutDTO extends AbstractDTO {

    /**
     * 图表id
     */
    private Integer i;
    /**
     * x坐标
     */
    private Integer x;
    /**
     * y坐标
     */
    private Integer y;
    /**
     * 宽度
     */
    private Integer w;
    /**
     * 高度
     */
    private Integer h;

    /**
     * 是否显示标题
     */
    private Boolean showTitle;

    public Boolean getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }
}
