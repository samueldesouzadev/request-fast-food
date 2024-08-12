package com.fast.food.request.domain.mapper;

import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.dtos.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<OrderDTO> mapList(List<Demand> demandList);
    default OrderDTO map(Demand demand){
        if ( demand == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setDemandNumber( demand.getDemandNumber() );
        orderDTO.setDemandStatus( demand.getDemandStatus() );
        orderDTO.setClientDTO(ClientMapper.INSTANCE.map(demand.getClient()));
        orderDTO.setProductDTOList(ProductMapper.INSTANCE.mapList(demand.getProducts()));

        return orderDTO;
    }

}
