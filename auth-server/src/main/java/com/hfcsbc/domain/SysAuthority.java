package com.hfcsbc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 权限
 * Created by wangyunfei on 2017/6/9.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public  class SysAuthority extends AbstractAuditingEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;
}
