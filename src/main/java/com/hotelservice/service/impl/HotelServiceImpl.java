package com.hotelservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.repository.HotelRepository;
import com.hotelservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelrepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelrepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelrepository.findAll();
	}

	@Override
	public Hotel getOneHotel(String id) {
		return hotelrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found ..!!"));
	}

	@Override
	public Hotel updateHotelById(Hotel hotel) {
		Hotel existingHotel = hotelrepository.findById(hotel.getId()).get();

		existingHotel.setName(hotel.getName());
		existingHotel.setLocation(hotel.getLocation());
		existingHotel.setAbout(hotel.getAbout());
		Hotel updatedHotel = hotelrepository.save(existingHotel);
		return updatedHotel;
	}

	@Override
	public void deleteHotel(String id) {
		hotelrepository.deleteById(id);
	}

}
