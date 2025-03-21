package ru.kdv.study.x6notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringJoiner;

@AllArgsConstructor
@Builder
@Getter
public class Order  {
    private Long id;
    private String orderNumber;
    private LocalDate orderDate;
    private Long userId;
    private LocalDateTime createDate;
    @Setter
    private List<OrderProduct> orderPositionList;

    @Override
    public String toString() {

        String result = String.format("Order: {id = %d,\norderNumber = %s,\norderDate = %s,\nuserId = %d,\ncreateDate = %s,\norderPosition[,\n${OrderPositionList},\n]}",
                this.id,
                this.orderNumber,
                this.orderDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                this.userId,
                createDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        );

        if (this.orderPositionList != null && !this.orderPositionList.isEmpty()) {
            StringJoiner stringJoiner = new StringJoiner(",\n");
            orderPositionList.stream()
                    .map(OrderProduct::toString)
                    .toList()
                    .forEach(stringJoiner::add);

            result = result.replace("${OrderPositionList}", stringJoiner.toString());
        };

        return result;
    }
}