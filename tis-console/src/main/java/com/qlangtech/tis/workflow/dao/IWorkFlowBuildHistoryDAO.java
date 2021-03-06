/**
 * Copyright (c) 2020 QingLang, Inc. <baisui@qlangtech.com>
 *
 * This program is free software: you can use, redistribute, and/or modify
 * it under the terms of the GNU Affero General Public License, version 3
 * or later ("AGPL"), as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.qlangtech.tis.workflow.dao;

import com.qlangtech.tis.workflow.pojo.WorkFlowBuildHistory;
import com.qlangtech.tis.workflow.pojo.WorkFlowBuildHistoryCriteria;
import java.util.List;

/**
 * @author 百岁（baisui@qlangtech.com）
 * @date 2020/04/13
 */
public interface IWorkFlowBuildHistoryDAO {

    int countByExample(WorkFlowBuildHistoryCriteria example);

    int countFromWriteDB(WorkFlowBuildHistoryCriteria example);

    int deleteByExample(WorkFlowBuildHistoryCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    Integer insert(WorkFlowBuildHistory record);

    Integer insertSelective(WorkFlowBuildHistory record);

    List<WorkFlowBuildHistory> selectByExample(WorkFlowBuildHistoryCriteria criteria);

    List<WorkFlowBuildHistory> selectByExample(WorkFlowBuildHistoryCriteria example, int page, int pageSize);

    WorkFlowBuildHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(WorkFlowBuildHistory record, WorkFlowBuildHistoryCriteria example);

    int updateByExample(WorkFlowBuildHistory record, WorkFlowBuildHistoryCriteria example);

    WorkFlowBuildHistory loadFromWriteDB(Integer id);
}
