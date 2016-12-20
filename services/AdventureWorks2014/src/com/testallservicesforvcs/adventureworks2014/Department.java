/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Department generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Department`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`Name`"})})
public class Department implements Serializable {

    private Short departmentId;
    private String name;
    private String groupName;
    @Type(type = "DateTime")
    private LocalDateTime modifiedDate;
    private List<EmployeeDepartmentHistory> employeeDepartmentHistories = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`DepartmentID`", nullable = false, scale = 0, precision = 5)
    public Short getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "`Name`", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`GroupName`", nullable = false, length = 50)
    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Column(name = "`ModifiedDate`", nullable = false)
    public LocalDateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "department")
    public List<EmployeeDepartmentHistory> getEmployeeDepartmentHistories() {
        return this.employeeDepartmentHistories;
    }

    public void setEmployeeDepartmentHistories(List<EmployeeDepartmentHistory> employeeDepartmentHistories) {
        this.employeeDepartmentHistories = employeeDepartmentHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        final Department department = (Department) o;
        return Objects.equals(getDepartmentId(), department.getDepartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentId());
    }
}

