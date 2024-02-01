package com.example.QuickFood.Service;

import com.example.QuickFood.Repository.RestaurantRepository;
import com.example.QuickFood.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
//        return RestaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant removeRestaurant(Integer restaurantId) {
        return null;
    }

    @Override
    public Restaurant viewRestaurant(Integer restaurantId){
        Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
        if(opt.isPresent()){
            Restaurant restaurant = opt.get();
            return restaurant;
        }
    }
}
