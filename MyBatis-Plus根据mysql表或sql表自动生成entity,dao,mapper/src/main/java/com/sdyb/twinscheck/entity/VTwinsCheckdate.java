package com.sdyb.twinscheck.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyr
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VTwinsCheckdate implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    @TableField("idNo")
    private String idNo;

    @TableField("resultDetail")
    private String resultDetail;

    @TableField("checkDate")
    private LocalDateTime checkDate;

    private String result;


}
