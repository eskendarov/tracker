package ru.job4j.stream;

/**
 * Car POJO class.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class Car {

    private final String volume;
    private final String model;
    private final String color;
    private final String vinCode;
    private final String weight;

    public static class Builder {

        private String volume;
        private String model;
        private String color;
        private String vinCode;
        private String weight;

        public Builder() {
        }

        public Builder(String volume,
                       String model,
                       String color,
                       String vinCode,
                       String weight) {
            this.volume = volume;
            this.model = model;
            this.color = color;
            this.vinCode = vinCode;
            this.weight = weight;
        }

        public Builder volume(String volume) {
            this.volume = volume;
            return Builder.this;
        }

        public Builder model(String model) {
            this.model = model;
            return Builder.this;
        }

        public Builder color(String color) {
            this.color = color;
            return Builder.this;
        }

        public Builder vinCode(String vinCode) {
            this.vinCode = vinCode;
            return Builder.this;
        }

        public Builder weight(String weight) {
            this.weight = weight;
            return Builder.this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private Car(Builder builder) {
        this.volume = builder.volume;
        this.model = builder.model;
        this.color = builder.color;
        this.vinCode = builder.vinCode;
        this.weight = builder.weight;
    }

    @Override
    public String toString() {
        return String.format(
                "Car {Model: %s, Color: %s, Vol: %s, VIN: %s, Weight: %s}",
                model, color, volume, vinCode, weight
        );
    }
}
