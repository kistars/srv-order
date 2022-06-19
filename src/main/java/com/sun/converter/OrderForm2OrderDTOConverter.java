package com.sun.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.dataobject.OrderDetail;
import com.sun.dto.OrderDTO;
import com.sun.enums.ResultEnum;
import com.sun.exception.SellException;
import com.sun.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SqMax on 2018/3/20.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
