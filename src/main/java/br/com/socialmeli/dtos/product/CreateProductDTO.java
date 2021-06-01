package br.com.socialmeli.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateProductDTO {

    @JsonProperty(value = "productName", index = 1)
    private String name;

    private String type;

    private String brand;

    private String color;

    private String notes;

    public CreateProductDTO() { }

    public CreateProductDTO(String name, String type, String brand, String color, String notes) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
