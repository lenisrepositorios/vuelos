package com.demo.booking.dtos;

import com.demo.booking.models.Booking;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    BookingDto toDto(Booking booking);
    Booking toEntity(BookingDto bookingDto);

    Booking saveDtoToEntity(BookingToSaveDto bookingToSaveDto);
}
