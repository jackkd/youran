<template>
  <el-dialog title="配置排序" :visible.sync="formVisible" width="50%">
    <el-form ref="aggOrderForm"
             :rules="rules" :model="form"
             label-width="120px" size="small">
      <el-form-item label="排序列" prop="parentItem">
        <el-select v-model="form.parentItem" value-key="key"
                   style="width:100%;" placeholder="请选择排序列"
                   filterable>
          <el-option-group label="维度">
            <el-option v-for="dimension in dimensionList"
                       :key="dimension.key" :label="dimension | displayDimension"
                       :value="dimension">
            </el-option>
          </el-option-group>
          <el-option-group label="指标">
            <el-option v-for="metrics in metricsList"
                       :key="metrics.key" :label="metrics | displayMetrics"
                       :value="metrics">
            </el-option>
          </el-option-group>
        </el-select>
      </el-form-item>
      <el-form-item label="排序方式" prop="sortType">
        <el-radio-group v-model="form.sortType">
          <el-radio border :label="1">升序▲</el-radio>
          <el-radio border :label="2">降序▼</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit()">确定</el-button>
        <el-button v-if="edit" type="danger" @click="remove()">删除</el-button>
        <el-button @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
import aggOrderModel from './aggOrderModel'
import dimensionModel from './dimensionModel'
import metricsModel from './metricsModel'

export default {
  name: 'agg-order-form',
  data () {
    return {
      edit: false,
      position: 0,
      formVisible: false,
      dimensionList: [],
      metricsList: [],
      // 最终返回给调用组件的表单数据
      form: aggOrderModel.initFormBean(),
      oldForm: null,
      rules: aggOrderModel.getRules()
    }
  },
  filters: {
    displayDimension: dimensionModel.displayText,
    displayMetrics: metricsModel.displayText
  },
  methods: {
    /**
     * 显示表单窗口
     * @param dimensionList 可选的维度列
     * @param metricsList 可选的指标列
     * @param formBean 编辑的aggOrder条件，如果新增则为空
     * @param position 当前编辑的aggOrder条件在数组中的位置
     */
    show (dimensionList, metricsList, formBean, position) {
      this.position = position
      this.dimensionList = dimensionList
      this.metricsList = metricsList
      if (formBean) {
        this.edit = true
        this.oldForm = formBean
        this.form = Object.assign({}, formBean)
      } else {
        this.edit = false
        this.form = aggOrderModel.initFormBean()
      }
      this.formVisible = true
      this.$refs.aggOrderForm.clearValidate()
    },
    submit () {
      this.$refs.aggOrderForm.validate()
        .then(() => {
          aggOrderModel.repairAggOrderForSubmit(this.form)
          this.$emit('submit', this.position, this.form)
          this.formVisible = false
        })
    },
    remove () {
      this.$emit('remove', this.position, this.oldForm)
      this.formVisible = false
    },
    cancel () {
      this.formVisible = false
    }
  }
}
</script>

<style lang="scss">
</style>
