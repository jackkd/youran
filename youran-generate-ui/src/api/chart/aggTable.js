import { request, apiPath, checkResult } from '@/utils/request'

export default {

  /**
   * 获取聚合表详情
   */
  get (chartId) {
    return request.get(`/${apiPath}/meta_chart/agg_table/${chartId}`)
      .then(response => checkResult(response))
  },
  /**
   * 保存聚合表
   */
  saveOrUpdate (data, isUpdate) {
    let saveURL = `/${apiPath}/meta_chart/agg_table`
    let method = isUpdate ? 'put' : 'post'
    return request[method](saveURL, data)
      .then(response => checkResult(response))
  }

}
