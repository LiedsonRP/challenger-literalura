package challenge.edu.oracle.literalura.service.API;

public interface JSONDataConversion {
    <T> T getData(String json, Class<T> finalClass);
}
