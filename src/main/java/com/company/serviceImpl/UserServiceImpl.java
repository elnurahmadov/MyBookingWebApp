package com.company.serviceImpl;

import com.company.dto.UserDto;
import com.company.model.BookingFlights;
import com.company.model.FlightsInfo;
import com.company.model.User;
import com.company.repository.BookingFlightsRepository;
import com.company.repository.FlightsInfoRepository;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final FlightsInfoRepository flightsInfoRepository;

    private final BookingFlightsRepository bookingFlightsRepository;

    @Override
    public List<UserDto> getAll() {
        List<User> all = userRepository.findAll();
        List<UserDto> collect = all.stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public UserDto create(Long id, UserDto userDto) {
        FlightsInfo flightsInfo = flightsInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This flight info is not available"));

        Long collect = userDto.getBookingFlightsList().stream().mapToLong(BookingFlights::getFreeSeats).sum();

        Long stock = flightsInfo.getFreeSeats() - collect;

        if (flightsInfo.getFreeSeats() > collect) {
            flightsInfo.setFreeSeats(stock);
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setBookingFlightsList(userDto.getBookingFlightsList());
        } else throw new RuntimeException("Empty seats not found");

        User user = modelMapper.map(userDto, User.class);
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDto.class);

    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(user.getLastName());
        user.setBookingFlightsList(userDto.getBookingFlightsList());
        User save = userRepository.save(user);
        return modelMapper.map(save, userDto.getClass());
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
