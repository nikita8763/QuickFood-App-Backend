package com.example.QuickFood.Service;

import com.example.QuickFood.model.Restaurant;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant) ;
    public Restaurant updateRestaurant(Restaurant restaurant);
    public Restaurant removeRestaurant(Integer restaurantId);
    public Restaurant viewRestaurant(Integer restaurantId);
}
