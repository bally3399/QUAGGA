package africa.semicolon.com.quagga.data.models;

public enum Category {
    STRUCTURAL("Structural"),
    MECHANICAL("Mechanical"),
    ELECTRICAL("Electrical"),
    FINISHING("Finishing"),
    EXTERIOR("Exterior"),
    SITE_WORK("Site Work"),
    SPECIALIZED("Specialized"),
    INTERIOR("Interior"),
    ENVIRONMENTAL_SYSTEMS("Environment systems"),
    RENOVATION("Renovations"),
    UTILITY("Utility"),
    MARINE("Marine"),
    HEAVY_CONSTRUCTION("Heavy construction"),
    SPECIALTY_CONTRACTORS("Specialty contractors"),
    LOGISTICS_AND_SUPPORT("Logistics and Support"),
    FABRICATION("Fabrication"),
    AGRICULTURAL_CONSTRUCTION("Agricultural construction"),
    ENTERTAINMENT("Entertainment"),
    MAINTENANCE("Maintenance"),
    RENEWABLE_ENERGY("Renewal energy"),
    SPECIALTY_FLOORING("Specialty Flooring"),
    SECURITY_AND_SAFETY("Security and Safety"),
    FINISHES_AND_DECORATIONS("Finishes and Decorations"),
    LOW_VOLTAGE_SYSTEMS("Low Voltage System"),
    LIGHTING("Lighting"),
    MISCELLANEOUS("Miscellaneous");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }



}
