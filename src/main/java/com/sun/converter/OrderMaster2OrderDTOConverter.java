package com.sun.converter;

import com.sun.dataobject.OrderMaster;
import com.sun.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SqMax on 2018/3/19.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e->
            convert(e)
        ).collect(Collectors.toList());
    }
}
