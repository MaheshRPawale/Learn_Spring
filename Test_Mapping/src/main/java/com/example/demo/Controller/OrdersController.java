package com.example.demo.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderEntity;
import com.example.demo.repositries.OrderRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    @Qualifier("orderModelMapper") 
    private ModelMapper modelMapper;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
        orderRepo.save(orderEntity);
        return "Order is placed";
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable(name = "orderId") Integer orderId) {
        OrderEntity  orderEntity = orderRepo.findById(orderId).get();
        OrderDTO orderDto = modelMapper.map(orderEntity, OrderDTO.class);
        return orderDto;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> orderEntityList = orderRepo.findAll();
        List<OrderDTO> listDTO = new ArrayList<>();

        Iterator<OrderEntity> iterator = orderEntityList.iterator();
        while(iterator.hasNext()) {
            OrderEntity obj = iterator.next();
            OrderDTO orderDto = modelMapper.map(obj, OrderDTO.class);
            listDTO.add(orderDto);
        }

        return listDTO;
    }
}