package com.qianxun.admin.api.dto.sysOrder.request;

import com.qianxun.admin.api.dto.base.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

/**
 * @author Cloudy
 *  */
@Data
public class SysOrderDeleteInputDTO extends RequestDTO implements Serializable{
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
