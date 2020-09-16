package tacos.data;


import tacos.Order;

public interface OrderRepository {

    Order saves(Order order);

}
