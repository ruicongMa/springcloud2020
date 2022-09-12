package com.moe.coupon.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.moe.coupon.serialization.MySerialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mark
 * @date 2022/5/24 13:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = MySerialization.class)
public class Student {

    private String name;
    // @JsonIgnore
    // @JsonProperty("myAge")
    private Integer age;
    private String address;
    private List<String> hobbies;
}
