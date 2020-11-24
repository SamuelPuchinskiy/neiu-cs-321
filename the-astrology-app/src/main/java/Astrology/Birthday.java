package Astrology;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Birthday_Data")
public class Birthday implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "You must choose a month")
    private String birthYearUser;

    @NotNull(message = "You must choose a month")
    private String birthMonthUser;

    @NotNull(message = "You must choose a Day")
    private String birthDayUser;

    private String yearZodiac = "null";

    private String monthZodiac = "null";

    private String numerology = "null";

    @ManyToOne
    private User user;
}