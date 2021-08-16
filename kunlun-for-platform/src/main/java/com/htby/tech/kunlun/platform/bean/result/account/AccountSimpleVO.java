package com.htby.tech.kunlun.platform.bean.result.account;

import com.htby.tech.kunlun.runtime.web.bean.result.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 账号列表
 *
 * @author vincent0116
 * @date 2020/03/09
 */
@ApiModel
@Data
public class AccountSimpleVO extends BaseVO {

    /**
     * 账号ID
     */
    @ApiModelProperty(value = "账号ID")
    private String accountId;

    /**
     * 账号名称
     */
    @ApiModelProperty(value = "账号名称")
    private String accountName;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
}
