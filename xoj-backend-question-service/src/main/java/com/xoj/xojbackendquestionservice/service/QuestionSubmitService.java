package com.xoj.xojbackendquestionservice.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xoj.xojbackendmodel.model.dto.QuestionSubmit.QuestionSubmitAddRequest;
import com.xoj.xojbackendmodel.model.dto.QuestionSubmit.QuestionSubmitQueryRequest;
import com.xoj.xojbackendmodel.model.entity.QuestionSubmit;
import com.xoj.xojbackendmodel.model.entity.User;
import com.xoj.xojbackendmodel.model.vo.QuestionSubmitVO;

/**
* @author 29923
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-02-24 13:22:02
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目提交封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
