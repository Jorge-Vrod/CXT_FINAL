public class City {
    int city_id;
    String city_name;
    String city_province;

    public City (int city_id, String city_name, String city_province) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.city_province = city_province;
    }

    public getCityId() {
        return city_id;
    }

    public getCityName() {
        return city_name;
    }

    public getCityProvince() {
        return city_province;
    }
}