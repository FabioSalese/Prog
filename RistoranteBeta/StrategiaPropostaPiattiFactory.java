public class StrategiaPropostaPiattiFactory {
    public static StrategiaPropostaPiatti creaStrategia() {
        return new StrategiaPropostaPiattiCategoria();
    }
}