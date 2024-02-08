package com.example.QuickFood.controller;

import com.example.QuickFood.Repository.RestaurantRepository;
import com.example.QuickFood.Service.RestaurantService;
import com.example.QuickFood.model.Restaurant;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @PostMapping("/add")
    public ResponseEntity<Restaurant> saveRestaurant(@Valid @RequestBody Restaurant restaurant){
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(newRestaurant , HttpStatus.CREATED);
    }

//    @PostMapping("/add/{id}/{restaurantName}")
//    public Restaurant addRestaurant(@PathVariable("id") Integer restaurantId, @PathVariable("restaurantName") String restaurantName){
//        Restaurant restaurant = new Restaurant();
//        restaurant.setRestaurantId(restaurantId);
//        restaurant.setRestaurantName(restaurantName);
////        return  restaurantService.addRestaurant(restaurant);
//        return restaurantRepository.save(restaurant);
//    }

    @PutMapping("/update")
    public ResponseEntity<Restaurant> updateResturant(@RequestBody Restaurant restaurant){

        Restaurant updatedResturant=restaurantService.updateRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(updatedResturant,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/remove/{restaurantId}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("restaurantId") Integer restaurantId){

        Restaurant removedRestaurant = restaurantService.removeRestaurant(restaurantId);
        return new ResponseEntity<Restaurant>(removedRestaurant, HttpStatus.OK);
    }


//    @GetMapping("/view/{restaurantId}")
//    public ResponseEntity<Restaurant> getByResturantId(@PathVariable ("restaurantId") Integer restaurantId ,@RequestParam String key) {
//
//        Restaurant restaurant =restaurantService.viewRestaurant(restaurantId);
//        return new ResponseEntity<Restaurant>(restaurant ,HttpStatus.ACCEPTED);
//
//    }

    @GetMapping("/view")
    public ResponseEntity<Restaurant> getByResturantId(Integer restaurantId ,@RequestParam String key) {

        Restaurant restaurant =restaurantService.viewRestaurant(restaurantId);
        return new ResponseEntity<Restaurant>(restaurant ,HttpStatus.ACCEPTED);

    }

}
