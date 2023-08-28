package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Data
@AllArgsConstructor
@Slf4j
public class BookingDetails {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Map<Bookingdates, Object> bookingdates;
    private String additionalneeds;
}
