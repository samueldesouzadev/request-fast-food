package com.fast.food.request.domain.mapper;

import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.dtos.DemandStatusDTO;
import com.fast.food.request.domain.dtos.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "paymentStatus", source = "paymentStatus")
    List<OrderDTO> mapList(List<Demand> demandList);

    default DemandStatusDTO mapStatus(Demand demand) {
        if (demand == null) {
            return null;
        }

        DemandStatusDTO demandStatusDTO = new DemandStatusDTO();
        demandStatusDTO.setDemandNumber(demand.getDemandNumber());
        demandStatusDTO.setStatusPayment(demand.getPaymentStatus());
        return demandStatusDTO;
    }

    default OrderDTO map(Demand demand) {
        if (demand == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setDemandNumber(demand.getDemandNumber());
        orderDTO.setDemandStatus(demand.getDemandStatus());
        orderDTO.setPaymentStatus(demand.getPaymentStatus());
        orderDTO.setProductDTOList(ProductMapper.INSTANCE.mapList(demand.getProducts()));

        return orderDTO;
    }

}
