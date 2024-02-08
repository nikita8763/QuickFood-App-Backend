package com.example.QuickFood.Service;

import com.example.QuickFood.Repository.RestaurantRepository;
import com.example.QuickFood.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

//    @Override
//    public Restaurant addRestaurant(Restaurant restaurant) {
////        Optional<Restaurant> opt = restaurantRepository.findById(restaurant.getRestaurantId());
////        if(opt.isPresent()) {
////            return null;
////        }
////        else {
////            Restaurant restaurant = opt.get();
//            return restaurantRepository.save(restaurant);
////        }
//    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Optional<Restaurant> opt = restaurantRepository.findById(restaurant.getRestaurantId());
        if(opt.isPresent()){
            return restaurantRepository.save(restaurant);
        }
        else {
            return null;
        }
    }

    @Override
    public Restaurant removeRestaurant(Integer restaurantId) {
        Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
        if(opt.isPresent()){
            Restaurant restaurant = opt.get();
            restaurantRepository.delete(restaurant);
            return restaurant;
        }
        else{
            return null;
        }
    }

    @Override
    public Restaurant viewRestaurant(Integer restaurantId){
        Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
        if(opt.isPresent()){
            Restaurant restaurant = opt.get();
            return restaurant;
        }
        else {
            return null;
        }
    }

}
