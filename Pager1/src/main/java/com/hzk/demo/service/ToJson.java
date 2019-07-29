package com.hzk.demo.service;

import com.github.pagehelper.PageInfo;
import com.hzk.demo.entity.User;

import java.util.Arrays;
import java.util.List;

public class ToJson {
    public static String toJson(PageInfo<User> pageInfo){
        StringBuffer sb = new StringBuffer();
        sb.append("{\"pageNum\":" + pageInfo.getPageNum());
        sb.append(",");
        sb.append("\"pageSize\":" + pageInfo.getPageSize());
        sb.append(",");
        sb.append("\"size\":" + pageInfo.getSize());
        sb.append(",");
        sb.append("\"total\":" + pageInfo.getTotal());

        sb.append(",");
        sb.append("\"pages\":" + pageInfo.getPages());

        sb.append(",");
        sb.append("\"list\":[");
        List<User> users = pageInfo.getList();
        if(users.size() > 0){
            User u = users.get(0);
            sb.append("{\"id\":" + u.getId() + ",\"name\":\"" + u.getName() + "\",\"age\":" +
                    u.getAge() + "}");
        }
        for(int i=1; i <users.size(); ++i){
            User u = users.get(i);
            sb.append(",{\"id\":" + u.getId() + ",\"name\":\"" + u.getName() + "\",\"age\":" +
                    u.getAge() + "}");
        }
        sb.append("],\"prePage\":" + pageInfo.getPrePage());
        sb.append(",\"nextPage\":" + pageInfo.getNextPage());
        sb.append(",\"hasPreviousPage\":" + pageInfo.isHasPreviousPage());
        sb.append(",\"hasNextPage\":" + pageInfo.isHasNextPage());
        sb.append(",\"navigatePages\":" + pageInfo.getNavigatePages());
        sb.append(",\"navigatepageNums\":");
        sb.append(Arrays.toString(pageInfo.getNavigatepageNums()));
        sb.append(",\"navigateFirstPage\":" + pageInfo.getNavigateFirstPage());
        sb.append(",\"navigateLastPage\":" + pageInfo.getNavigateLastPage());
        sb.append("}");
        return sb.toString();
    }
}
