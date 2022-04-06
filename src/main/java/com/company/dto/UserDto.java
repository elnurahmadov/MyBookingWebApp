package com.company.dto;
import com.company.model.BookingFlights;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

        Long id;

        String firstName;

        String lastName;

        List<BookingFlights> bookingFlightsList;

}