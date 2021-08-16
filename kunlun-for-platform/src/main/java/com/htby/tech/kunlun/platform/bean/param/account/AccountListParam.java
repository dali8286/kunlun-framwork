package com.htby.tech.kunlun.platform.bean.param.account;

import com.htby.tech.kunlun.runtime.web.bean.param.ApiBasePagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 账号列表参数
 *
 * @author vincent0116
 * @date 2020/03/09
 */
@ApiModel
@Data
public class AccountListParam extends ApiBasePagerParam {

    @ApiModelProperty(name = "手机号")
    private String mobile;
}
