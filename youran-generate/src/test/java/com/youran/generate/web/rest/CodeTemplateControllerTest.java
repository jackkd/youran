package com.youran.generate.web.rest;

import com.google.common.collect.Lists;
import com.youran.common.util.JsonUtil;
import com.youran.generate.help.CodeTemplateHelper;
import com.youran.generate.pojo.dto.CodeTemplateAddDTO;
import com.youran.generate.pojo.dto.CodeTemplateUpdateDTO;
import com.youran.generate.pojo.po.CodeTemplatePO;
import com.youran.generate.web.AbstractWebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>Title: 【代码模板】单元测试</p>
 * <p>Description: </p>
 * @author cbb
 * @date 2019/10/24
 */
public class CodeTemplateControllerTest extends AbstractWebTest {

    @Autowired
    private CodeTemplateHelper codeTemplateHelper;


    /**
     * 新增【代码模板】
     */
    @Test
    public void save() throws Exception {
        CodeTemplateAddDTO addDTO = codeTemplateHelper.getCodeTemplateAddDTO();
        restMockMvc.perform(post(getApiPath() + "/codeTemplate")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(status().isCreated());
    }

    /**
     * 修改【代码模板】
     */
    @Test
    public void update() throws Exception {
        CodeTemplatePO codeTemplate = codeTemplateHelper.saveCodeTemplateExample();
        CodeTemplateUpdateDTO updateDTO = codeTemplateHelper.getCodeTemplateUpdateDTO(codeTemplate);
        restMockMvc.perform(put(getApiPath() + "/codeTemplate")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(status().isOk());
    }

    /**
     * 分页查询【代码模板】
     */
    @Test
    public void list() throws Exception {
        CodeTemplatePO codeTemplate = codeTemplateHelper.saveCodeTemplateExample();
        restMockMvc.perform(get(getApiPath() + "/codeTemplate"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.list.length()").value(is(1)));
    }

    /**
     * 查看【代码模板】详情
     */
    @Test
    public void show() throws Exception {
        CodeTemplatePO codeTemplate = codeTemplateHelper.saveCodeTemplateExample();
        restMockMvc.perform(get(getApiPath() + "/codeTemplate/{templateId}",codeTemplate.getTemplateId()))
            .andExpect(status().isOk());
    }

    /**
     * 删除单个【代码模板】
     */
    @Test
    public void del() throws Exception {
        CodeTemplatePO codeTemplate = codeTemplateHelper.saveCodeTemplateExample();
        restMockMvc.perform(delete(getApiPath() + "/codeTemplate/{templateId}",codeTemplate.getTemplateId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }

    /**
     * 批量删除【代码模板】
     */
    @Test
    public void deleteBatch() throws Exception {
        CodeTemplatePO codeTemplate = codeTemplateHelper.saveCodeTemplateExample();
        restMockMvc.perform(delete(getApiPath() + "/codeTemplate")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JsonUtil.toJSONString(Lists.newArrayList(codeTemplate.getTemplateId()))))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }



}
