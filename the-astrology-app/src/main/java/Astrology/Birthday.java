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

    //@ManyToOne(targetEntity = BirthYear.class)
    @NotNull(message = "You must choose a month")
    private String birthYearUser;

    //@ManyToOne(targetEntity = BirthMonth.class)
    @NotNull(message = "You must choose a month")
    private String birthMonthUser;

    //@ManyToOne(targetEntity = Day.class)
    @NotNull(message = "You must choose a Day")
    private String birthDayUser;

    private String yearZodiac = "null";

    private String monthZodiac = "null";

    private String numerology = "null";



    @ManyToOne
    private User user;

}

/*
    public void addDesign(Birthday design) {
        //Birthday obj = new Birthday();

        design.setId(this.id);
        design.setBirthDayUser(this.birthDayUser);
        design.setBirthMonthUser(this.birthMonthUser);
        design.setBirthYearUser(this.birthYearUser);

        addDesign(design);
    }



   @NotBlank(message = "Name is required")
    private String name;
*/


