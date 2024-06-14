package com.hotelservice.service;

import java.util.List;

import com.hotelservice.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getAllHotels();

	Hotel getOneHotel(String id);

	Hotel updateHotelById(Hotel hotel);

	void deleteHotel(String id);
}
