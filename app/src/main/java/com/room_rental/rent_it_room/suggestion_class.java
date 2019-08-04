package com.room_rental.rent_it_room;

public class suggestion_class {
    public String featured_image;
    public String owner_name;
    public String price;
    public  suggestion_class(String image,String name,String price)
    {
        featured_image=image;
        owner_name=name;
        this.price=price;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
