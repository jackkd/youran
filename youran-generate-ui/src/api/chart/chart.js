import { request, apiPath, checkResult } from '@/utils/request'

export default {

  /**
   * 查询项目下的图表列表
   */
  getList (projectId) {
    return request.get(`/${apiPath}/meta_chart`,
      {
        params: {
          projectId,
          moduleSortSign: 1
        }
      })
      .then(response => checkResult(response))
  },
  /**
   * 批量删除图表
   */
  deleteBatch (data) {
    return request.delete(`/${apiPath}/meta_chart`, { data })
      .then(response => checkResult(response))
  }

}
