package cristina.tech.blog.travel.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "holiday_packages")
/**
 * Models an Open Travel Wanderlust API Holiday.
 * A Holiday has for now one {@link Destination} only and it is offered by one or many travel {@link Agent}(s).
 */
public class Holiday extends BaseEntity {
    private static final long serialVersionUID = 1126074635410771213L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="destination")
    @NotNull
    @Valid
    private Destination destination;

    @Future
    private LocalDate startOn;

    @Range(min = 3, max = 90)
    private Integer daysCount;

    private String departFrom;

    private BigDecimal price;

    @NotNull(message = "flightIncluded flag must be set")
    private Boolean flightIncluded;

    @NotNull(message = "accomodationIncluded flag must be set")
    private Boolean accomodationIncluded;

    private String packageInfo;

    public Holiday() { }

    public Holiday(Destination destination, LocalDate startOn, Integer daysCount, String departFrom,
                   BigDecimal price, Boolean flightIncluded, Boolean accomodationIncluded, String packageInfo) {
        this.destination = destination;
        this.startOn = startOn;
        this.daysCount = daysCount;
        this.departFrom = departFrom;
        this.price = price;
        this.flightIncluded = flightIncluded;
        this.accomodationIncluded = accomodationIncluded;
        this.packageInfo = packageInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Holiday that = (Holiday) o;

        return Objects.equals(destination, that.destination)
                && Objects.equals(startOn, that.startOn)
                && Objects.equals(daysCount, that.daysCount)
                && Objects.equals(departFrom, that.departFrom)
                && Objects.equals(price, that.price)
                && Objects.equals(flightIncluded, that.flightIncluded)
                && Objects.equals(accomodationIncluded, that.accomodationIncluded);

    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, startOn, daysCount, departFrom, price, flightIncluded, accomodationIncluded);
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "destination=" + destination +
                ", startOn=" + startOn +
                ", daysCount=" + daysCount +
                ", departFrom='" + departFrom + '\'' +
                ", price=" + price +
                ", flightIncluded=" + flightIncluded +
                ", accomodationIncluded=" + accomodationIncluded +
                ", packageInfo='" + packageInfo + '\'' +
                '}';
    }
}