package com.zql.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author lawliet.L
 */

/**
 * @Document用于标识，这是一个ES文档，并指定索引名称和类型，还可以通过shards指定分片数，通过replicas指定副本数
 */
@Document(indexName = "estest",type = "goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo implements Serializable {

    /**
     *  实体中必须要有一个id属性，@Id注解不是必须的
     */
    @Id
    private String id;

    /**
     * @Field注解指定该成员变量对应的文档中的字段
     * type属性指定其在ES中的字段类型，通过FieldType枚举指定
     * index属性指定该字段是否参加索引，默认是true
     * store属性指定该字段是否存储，默认false
     * analyzer指定分词器的名称
     */
    @Field(type = FieldType.Text)
    private String name;

    private String desc;

}
