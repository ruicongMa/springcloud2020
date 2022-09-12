package com.moe.coupon.serialization;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.moe.coupon.vo.Student;

import java.io.IOException;

/**
 * @author Mark
 * @date 2022/5/24 13:32
 */
public class MySerialization extends JsonSerializer<Student> {

    @Override
    public void serialize(Student student, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        // 开始序列化
        generator.writeStartObject();

        generator.writeStringField("name", student.getName());
        generator.writeNumberField("age", student.getAge() + 5);
        generator.writeStringField("addressTest", student.getAddress() + " 尧都区");
        generator.writeStringField("hobby", JSON.toJSONString(student.getHobbies()));
        generator.writeObjectField("hobbyTest", student.getHobbies());

        // 结束序列化
        generator.writeEndObject();
    }
}
