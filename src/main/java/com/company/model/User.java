package com.company.model;


import com.company.dto.FlightsInfoDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends FlightsInfoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;

    String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_booking_id")
    List<BookingFlights> bookingFlightsList;
}

