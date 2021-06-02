package br.com.socialmeli.services;

import br.com.socialmeli.controllers.SortParam;
import org.springframework.data.domain.Sort;

public class SortService {
    public static Sort build(SortParam sortParam, String previousProperty) {

        if(sortParam != null && sortParam.getOrder() != null) {
            String[] paramAndOrder = sortParam.getOrder().split("_");
            if(paramAndOrder.length == 2) return Sort.by(build(previousProperty + paramAndOrder[0], paramAndOrder[1]));
        }

        return Sort.unsorted();
    }

    public static Sort build(SortParam sortParam) {
        return build(sortParam, "");
    }

    private static Sort.Order build(String properyName, String order) {
        if (order.equals("asc")) return Sort.Order.asc(properyName);

        return Sort.Order.desc(properyName);
    }
}
