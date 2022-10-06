public class Auto {
    private String model;
    private String make;
    private String description;
    private String color;
    private String condition;

    public Auto(String make, String model,  String description, String condition, String color) {
        this.model = model;
        this.make = make;
        this.description = description;
        this.color = color;
        this.condition = condition;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Auto model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", condition='" + condition + '\'';
    }
}
