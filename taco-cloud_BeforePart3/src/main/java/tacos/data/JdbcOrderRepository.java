package tacos.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import tacos.Order;
import tacos.Taco;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");

        this.objectMapper = new ObjectMapper();

    }

    @Override
    public Order saves(Order order) {
        order.setPlacedAt(LocalDateTime.now());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        for(Taco taco : order.getTacos())
            saveTacoToOrder(taco, orderId);
        return null;
    }

    private void saveTacoToOrder(Taco taco, long orderId) {
        Map<String, Object> values = new HashMap<>();
        values.put("tacoOrder", orderId);
        values.put("taco", taco.getId());
        orderTacoInserter.execute(values);
    }

    private long saveOrderDetails(Order order) {
        Map<String, Long> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt", Timestamp.valueOf(order.getPlacedAt()));
        long orderId = orderInserter.executeAndReturnKey(values).longValue();
        return orderId;
    }
}
