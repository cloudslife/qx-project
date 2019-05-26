package com.qianxun.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianxun.admin.api.entity.SysDeptRelation;

public interface SysDeptRelationMapper extends BaseMapper<SysDeptRelation> {
	/**
	 * 删除部门关系表数据
	 *
	 * @param id 部门ID
	 */
	void deleteDeptRelationsById(Integer id);

	/**
	 * 更改部分关系表数据
	 *
	 * @param deptRelation
	 */
	void updateDeptRelations(SysDeptRelation deptRelation);

}
