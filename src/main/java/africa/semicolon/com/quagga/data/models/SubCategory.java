package africa.semicolon.com.quagga.data.models;

public enum SubCategory {
    WOOD_FRAMING(Category.STRUCTURAL, "Wood_framing"),
    FORM_WORK(Category.STRUCTURAL, "Form_work"),
    STEEL_ERECTION(Category.STRUCTURAL, "Steel_erection"),
    METAL_DECKING(Category.STRUCTURAL, "Metal_Decking"),
    CONCRETE_WORK(Category.STRUCTURAL, "Concrete_work"),
    PRECAST_CONCRETE(Category.STRUCTURAL, "Precast_concrete"),
    PILING(Category.STRUCTURAL, "PILING"),
    UNDERPINNING(Category.STRUCTURAL, "Underpinning"),
    DEMOLITION(Category.STRUCTURAL, "Demolition"),
    EXCAVATION(Category.STRUCTURAL, "Excavation"),
    HVAC(Category.MECHANICAL, "HVAC"),
    PLUMBING(Category.MECHANICAL, "Plumbing"),
    GAS_FITTING(Category.MECHANICAL, "Gas_fitting"),
    INDUSTRIAL_PIPE_SYSTEMS(Category.MECHANICAL, "Industrial_pipe_systems"),
    WELDING(Category.MECHANICAL, "Welding"),
    METAL_FABRICATION(Category.MECHANICAL, "Metal_fabrication"),


   RESIDENTIAL_WIRING(Category.ELECTRICAL,"Residential_wiring"),
    COMMERCIAL_WIRING(Category.ELECTRICAL,"Commercial_wiring"),
    LOW_VOLTAGE_SYSTEM(Category.ELECTRICAL,"Low_voltage_system"),
    ACCESS_CONTROL(Category.ELECTRICAL, "Access_control"),

    // Low Voltage Systems
    FIRE_ALARMS(Category.LOW_VOLTAGE_SYSTEMS, "Fire alarms"),
    DATA_CABLING(Category.LOW_VOLTAGE_SYSTEMS, "Data cabling"),
    SECURITY_SYSTEMS(Category.LOW_VOLTAGE_SYSTEMS, "Security systems"),

    // Lighting
    INDOOR_LIGHTING(Category.LIGHTING, "Indoor lighting systems"),
    OUTDOOR_LIGHTING(Category.LIGHTING, "Outdoor lighting systems"),


    // Renewable Energy
    SOLAR_PANEL_INSTALLATION(Category.RENEWABLE_ENERGY, "Solar panel installation"),
    WIND_TURBINES(Category.RENEWABLE_ENERGY, "Wind turbines"),

    // Finishing Trades
    INTERIOR_PAINTING(Category.FINISHING, "Interior painting"),
    EXTERIOR_PAINTING(Category.FINISHING, "Exterior painting"),
    DECORATIVE_FINISHES(Category.FINISHING, "Decorative finishes"),
    DRYWALL(Category.FINISHING, "Drywall"),
    PLASTERING(Category.FINISHING, "Plastering"),
    FLOORING(Category.FINISHING, "Flooring"),
    CEILINGS(Category.FINISHING,  "Ceilings"),
    MILLWORK(Category.FINISHING, "Millwork"),
    GLAZING(Category.FINISHING, "Glazing"),
    LATHING(Category.FINISHING, "Lathing"),

    // Exterior Trades
    ROOFING(Category.EXTERIOR, "Roofing"),
    SIDING(Category.EXTERIOR, "Siding"),
    INSULATION(Category.EXTERIOR, "Insulation"),
    WATERPROOFING(Category.EXTERIOR, "Waterproofing"),
    DECKING(Category.EXTERIOR, "Decking"),
    FENCING(Category.EXTERIOR, "Fencing"),

    // Site Work
    LANDSCAPING(Category.SITE_WORK, "Landscaping"),
    PAVING(Category.SITE_WORK, "Paving"),
    SITE_UTILITIES(Category.SITE_WORK, "Site utilities"),
    IRRIGATION(Category.SITE_WORK, "Irrigation"),
    SITE_LIGHTING(Category.SITE_WORK, "Site lighting"),

    // Specialized Trades
    FIRE_PROTECTION(Category.SPECIALIZED, "Fire protection"),
    ELEVATORS(Category.SPECIALIZED, "Elevators"),
    SCAFFOLDING(Category.SPECIALIZED, "Scaffolding"),
    RIGGING(Category.SPECIALIZED, "Rigging"),
    ACOUSTICS(Category.SPECIALIZED, "Acoustics"),
    SIGNAGE(Category.SPECIALIZED, "Signage"),
    TELECOMMUNICATIONS(Category.SPECIALIZED, "Telecommunications"),

    // Miscellaneous Trades
    STONE_AND_TILE(Category.MISCELLANEOUS, "Stone and tile"),
    STUCCO(Category.MISCELLANEOUS, "Stucco"),
    SOLAR_INSTALLATIONS(Category.MISCELLANEOUS, "Solar installations"),
    WIND_TURBINES_MISC(Category.MISCELLANEOUS, "Wind turbines"),
    SECURITY_SYSTEMS_MISC(Category.MISCELLANEOUS, "Security systems"),
    AUTOMATION_SYSTEMS(Category.MISCELLANEOUS, "Automation systems"),
    FURNITURE_INSTALLATION(Category.MISCELLANEOUS, "Furniture installation"),
    WINDOW_TREATMENTS(Category.MISCELLANEOUS, "Window treatments"),
    ORNAMENTAL_IRONWORK(Category.MISCELLANEOUS, "Ornamental ironwork"),

    // Interior Trades
    CABINETRY(Category.INTERIOR, "Cabinetry"),
    COUNTERTOPS(Category.INTERIOR, "Countertops"),
    CLOSETS(Category.INTERIOR, "Closets"),
    SHOWER_DOORS(Category.INTERIOR, "Shower doors"),
    MIRRORS(Category.INTERIOR, "Mirrors"),
    SHELVING(Category.INTERIOR, "Shelving"),
    PARTITIONS(Category.INTERIOR, "Partitions"),
    HANDRAILS(Category.INTERIOR, "Handrails"),

    // Environmental Systems
    GEOTHERMAL(Category.ENVIRONMENTAL_SYSTEMS, "Geothermal"),
    RAINWATER_HARVESTING(Category.ENVIRONMENTAL_SYSTEMS, "Rainwater harvesting"),
    GREEN_ROOFING(Category.ENVIRONMENTAL_SYSTEMS, "Green roofing"),
    SUSTAINABLE_MATERIALS(Category.ENVIRONMENTAL_SYSTEMS, "Sustainable materials"),

    // Renovation Trades
    RESTORATION(Category.RENOVATION, "Restoration"),
    REMODELING(Category.RENOVATION, "Remodeling"),
    RETROFIT(Category.RENOVATION, "Retrofit"),
    ADDITIONS(Category.RENOVATION, "Additions"),

    // Utility Trades
    ELECTRICAL_UTILITIES(Category.UTILITY, "Electrical utilities"),
    GAS_UTILITIES(Category.UTILITY, "Gas utilities"),
    WATER_UTILITIES(Category.UTILITY, "Water utilities"),
    SEWER_UTILITIES(Category.UTILITY, "Sewer utilities"),
    TELECOMMUNICATIONS_UTILITIES(Category.UTILITY, "Telecommunications utilities"),

    // Marine Trades
    DOCK_BUILDING(Category.MARINE, "Dock building"),
    MARINE_CONSTRUCTION(Category.MARINE, "Marine construction"),
    BOAT_LIFTS(Category.MARINE, "Boat lifts"),

    // Heavy Construction
    HIGHWAY_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Highway construction"),
    RAILROAD_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Railroad construction"),
    AIRPORT_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Airport construction"),
    DAM_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Dam construction"),

    // Specialty Contractors
    HAZARDOUS_MATERIALS(Category.SPECIALTY_CONTRACTORS, "Hazardous materials"),
    EXPLOSIVES(Category.SPECIALTY_CONTRACTORS, "Explosives"),
    UNDERWATER_WELDING(Category.SPECIALTY_CONTRACTORS, "Underwater welding"),
    CONCRETE_CUTTING(Category.SPECIALTY_CONTRACTORS, "Concrete cutting"),
    PEST_CONTROL(Category.SPECIALTY_CONTRACTORS, "Pest control"),
    BLASTING(Category.SPECIALTY_CONTRACTORS, "Blasting"),

    // Logistics and Support
    MATERIAL_HANDLING(Category.LOGISTICS_AND_SUPPORT, "Material handling"),
    TOOL_REPAIR(Category.LOGISTICS_AND_SUPPORT, "Tool repair"),
    VEHICLE_MAINTENANCE(Category.LOGISTICS_AND_SUPPORT, "Vehicle maintenance"),
    SAFETY_SERVICES(Category.LOGISTICS_AND_SUPPORT, "Safety services"),
    SURVEYING(Category.LOGISTICS_AND_SUPPORT, "Surveying"),
    ENGINEERING(Category.LOGISTICS_AND_SUPPORT, "Engineering"),
    ARCHITECTURE(Category.LOGISTICS_AND_SUPPORT, "Architecture"),

    // Fabrication Trades
    MODULAR_CONSTRUCTION(Category.FABRICATION, "Modular construction"),
    CUSTOM_METALWORK(Category.FABRICATION, "Custom metalwork"),
    WOODWORKING(Category.FABRICATION, "Woodworking"),

    // Agricultural Trades
    BARN_CONSTRUCTION(Category.MISCELLANEOUS, "Barn construction"),
    GREENHOUSES(Category.MISCELLANEOUS, "Greenhouses"),
    IRRIGATION_SYSTEMS(Category.MISCELLANEOUS, "Irrigation systems"),
    FENCING_AGRICULTURAL(Category.MISCELLANEOUS, "Fencing"),

    // Entertainment Trades
    SET_CONSTRUCTION(Category.ENTERTAINMENT, "Set construction"),
    EVENT_STAGING(Category.ENTERTAINMENT, "Event staging"),
    EXHIBIT_CONSTRUCTION(Category.ENTERTAINMENT, "Exhibit construction"),

    // Specialized Restoration
    STONE_RESTORATION(Category.SPECIALIZED, "Stone restoration"),
    WOOD_RESTORATION(Category.SPECIALIZED, "Wood restoration"),
    METAL_RESTORATION(Category.SPECIALIZED, "Metal restoration"),

    // Maintenance Trades
    JANITORIAL_SERVICES(Category.MAINTENANCE, "Janitorial services"),
    BUILDING_MAINTENANCE(Category.MAINTENANCE, "Building maintenance"),
    GROUNDSKEEPING(Category.MAINTENANCE, "Groundskeeping"),
    WINDOW_CLEANING(Category.MAINTENANCE, "Window cleaning"),

    // Renewable Energy Trades
    WIND_ENERGY(Category.RENEWABLE_ENERGY, "Wind energy"),
    HYDROELECTRIC(Category.RENEWABLE_ENERGY, "Hydroelectric"),
    BIOMASS(Category.RENEWABLE_ENERGY, "Biomass"),

    // Specialty Flooring
    EPOXY_FLOORING(Category.SPECIALTY_FLOORING, "Epoxy flooring"),
    TERRAZZO(Category.SPECIALTY_FLOORING, "Terrazzo"),
    CONCRETE_POLISHING(Category.SPECIALTY_FLOORING, "Concrete polishing"),

    // Security and Safety
    FIRE_ALARM_SYSTEMS(Category.SECURITY_AND_SAFETY, "Fire alarm systems"),
    SPRINKLER_SYSTEMS(Category.SECURITY_AND_SAFETY, "Sprinkler systems"),
    SECURITY_FENCING(Category.SECURITY_AND_SAFETY, "Security fencing"),
    ACCESS_CONTROL_SYSTEMS(Category.SECURITY_AND_SAFETY, "Access control systems"),

    // Finishes and Decorations
    DECORATIVE_CONCRETE(Category.FINISHES_AND_DECORATIONS, "Decorative concrete"),
    VENETIAN_PLASTER(Category.FINISHES_AND_DECORATIONS, "Venetian plaster"),
    MURALS(Category.FINISHES_AND_DECORATIONS, "Murals"),
    WALLPAPERING(Category.FINISHES_AND_DECORATIONS, "Wallpapering"),




    CUSTOM_GLASS(Category.SPECIALIZED, "Custom glass"),
    CUSTOM_STEEL(Category.SPECIALIZED, "Custom steel"),
    CUSTOM_WOOD(Category.SPECIALIZED, "Custom wood"),

    // Industrial Trades
    INDUSTRIAL_PIPING(Category.MECHANICAL, "Industrial piping"),
    INDUSTRIAL_ELECTRICAL(Category.ELECTRICAL, "Industrial electrical"),

    DIVING_SERVICES(Category.MARINE, "Diving services"),

    // Structural Trades
    REBAR_INSTALLATION(Category.STRUCTURAL, "Rebar installation"),
    STEEL_DETAILING(Category.STRUCTURAL, "Steel detailing"),
    SHORING_UNDERPINNING(Category.STRUCTURAL, "Shoring and underpinning"),

    // Mechanical Trades
    REFRIGERATION(Category.MECHANICAL, "Refrigeration"),
    BOILER_MAKING(Category.MECHANICAL, "Boiler making"),
    CHILLER_SYSTEMS(Category.MECHANICAL, "Chiller systems"),
    HYDRONICS(Category.MECHANICAL, "Hydronics"),

    // Electrical Trades
    INSTRUMENTATION(Category.ELECTRICAL, "Instrumentation"),
    SUBSTATION_CONSTRUCTION(Category.ELECTRICAL, "Substation construction"),
    BATTERY_SYSTEMS(Category.ELECTRICAL, "Battery systems"),

    // Finishing Trades
    STAIR_INSTALLATION(Category.FINISHING, "Stair installation"),
    TRIM_CARPENTRY(Category.FINISHING, "Trim carpentry"),
    PANELING(Category.FINISHING, "Paneling"),
    DECORATIVE_PLASTER(Category.FINISHING, "Decorative plaster"),

    // Exterior Trades
    STUCCO_EIFS(Category.EXTERIOR, "Stucco and EIFS"),
    GUTTER_INSTALLATION(Category.EXTERIOR, "Gutter installation"),
    HARDSCAPING(Category.EXTERIOR, "Hardscaping"),
    DECK_BUILDING(Category.EXTERIOR, "Deck building"),

    // Site Work
    CLEARING_GRUBBING(Category.SITE_WORK, "Clearing and grubbing"),
    SUBGRADE_PREPARATION(Category.SITE_WORK, "Subgrade preparation"),
    UTILITIES_INSTALLATION(Category.SITE_WORK, "Utilities installation"),
    STORMWATER_MANAGEMENT(Category.SITE_WORK, "Stormwater management"),

    // Specialized Trades
    RADON_MITIGATION(Category.SPECIALIZED, "Radon mitigation"),
    BUILDING_AUTOMATION(Category.SPECIALIZED, "Building automation"),
    AQUATIC_SYSTEMS(Category.SPECIALIZED, "Aquatic systems"),


    // Miscellaneous Trades
    PAVING_STONES(Category.MISCELLANEOUS, "Paving stones"),
    GARDEN_STRUCTURES(Category.MISCELLANEOUS, "Garden structures"),
    OUTDOOR_KITCHENS(Category.MISCELLANEOUS, "Outdoor kitchens"),
    FIRE_FEATURES(Category.MISCELLANEOUS, "Fire features"),

    // Interior Trades
    HOME_THEATERS(Category.INTERIOR, "Home theaters"),
    SAUNA_INSTALLATION(Category.INTERIOR, "Sauna installation"),
    WINE_CELLARS(Category.INTERIOR, "Wine cellars"),
    CUSTOM_SHELVING(Category.INTERIOR, "Custom shelving"),

    // Environmental Systems
    SOLAR_THERMAL(Category.ENVIRONMENTAL_SYSTEMS, "Solar thermal"),
    GREYWATER_SYSTEMS(Category.ENVIRONMENTAL_SYSTEMS, "Greywater systems"),
    ENERGY_AUDITS(Category.ENVIRONMENTAL_SYSTEMS, "Energy audits"),
    PASSIVE_SOLAR(Category.ENVIRONMENTAL_SYSTEMS, "Passive solar"),

    // Utility Trades
    FIBER_OPTIC_INSTALLATION(Category.UTILITY, "Fiber optic installation"),
    TRAFFIC_SIGNALS(Category.UTILITY, "Traffic signals"),
    STREET_LIGHTING(Category.UTILITY, "Street lighting"),

    // Marine Trades
    MARINE_ELECTRICAL(Category.MARINE, "Marine electrical"),
    SHIP_FITTING(Category.MARINE, "Ship fitting"),
    MARINE_CARPENTRY(Category.MARINE, "Marine carpentry"),

    // Heavy Construction
    PIPELINE_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Pipeline construction"),
    TUNNEL_BORING(Category.HEAVY_CONSTRUCTION, "Tunnel boring"),
    BRIDGE_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Bridge construction"),
    MINING_CONSTRUCTION(Category.HEAVY_CONSTRUCTION, "Mining construction"),

    // Specialty Contractors
    HAZARDOUS_WASTE_DISPOSAL(Category.SPECIALTY_CONTRACTORS, "Hazardous waste disposal"),
    ENVIRONMENTAL_DRILLING(Category.SPECIALTY_CONTRACTORS, "Environmental drilling"),
    SEISMIC_RETROFITTING(Category.SPECIALTY_CONTRACTORS, "Seismic retrofitting"),
    UNDERWATER_CONSTRUCTION(Category.SPECIALTY_CONTRACTORS, "Underwater construction"),

    // Logistics and Support
    EQUIPMENT_RENTAL(Category.LOGISTICS_AND_SUPPORT, "Equipment rental"),
    TEMPORARY_STRUCTURES(Category.LOGISTICS_AND_SUPPORT, "Temporary structures"),
    TRAFFIC_CONTROL(Category.LOGISTICS_AND_SUPPORT, "Traffic control"),
    CONSTRUCTION_CLEANING(Category.LOGISTICS_AND_SUPPORT, "Construction cleaning");


    private final Category category;
    private final String subCategoryName;

    SubCategory(Category category, String subCategoryName) {
        this.category = category;
        this.subCategoryName = subCategoryName;
    }
}
