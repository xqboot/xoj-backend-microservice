package com.xoj.xojbackendjudgeservice.judge.codesandbox.Impl;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xoj.xojbackendcommon.common.ErrorCode;
import com.xoj.xojbackendcommon.exception.BusinessException;
import com.xoj.xojbackendjudgeservice.judge.codesandbox.CodeSandBox;
import com.xoj.xojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.xoj.xojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xq
 * @create 2024/3/31 11:53
 */
public class RemoteCodeSandBox implements CodeSandBox {
    //定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";
    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
