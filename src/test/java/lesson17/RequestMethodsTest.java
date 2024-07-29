package lesson17;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lesson17.POJOClasses.deleteClasses.POJODeleteClass;
import lesson17.POJOClasses.getClasses.POJOGetClass;
import lesson17.POJOClasses.patchClasses.POJOPatchClass;
import lesson17.POJOClasses.postClasses.POJOPostClass;
import lesson17.POJOClasses.putClasses.POJOPutClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.given;

@DisplayName("Postman-echo requests methods tests")
public class RequestMethodsTest {


    private static final String BASE_REST_URL = "https://postman-echo.com";

    private final String HOST = "postman-echo.com";
    private final String FORWARDED_PROTOCOL = "https";
    private final String FORWARDED_PORT = "443";
    private final String ACCEPT_VALUE = "*/*";
    private final String ACCEPT_ENCODING_VALUE = "gzip,deflate";
    private final String CONTENT_TYPE_FORM_VALUE = "application/x-www-form-urlencoded; charset=utf-8";
    private final String CONTENT_TYPE_TEXT_VALUE = "text/plain; charset=ISO-8859-1";

    @BeforeAll
    public static void doBeforeAll() {
        //Не использую SpecBuilder так как нужно задавать только baseURI
        RestAssured.baseURI = BASE_REST_URL;
    }


    @ParameterizedTest
    @DisplayName("1. Get Request Test")
    @CsvSource({"foo1, bar1, foo2, bar2, /get"})
    public void getCheck(String firstParam, String firstValue, String secondParam, String secondValue, String path) {


        //У нас не создаться объект, если какого-то поля (ключа) нет
        POJOGetClass pojoGetClass = given()
                .param(firstParam, firstValue)
                .param(secondParam, secondValue)
                .when()
                .get(path)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(POJOGetClass.class);

        //Проверка полей
        assertAll(
                () -> assertFalse(pojoGetClass.isSomeFieldNull()),
                () -> assertEquals(firstValue, pojoGetClass.getArgs().get(firstParam).asText()),
                () -> assertEquals(secondValue, pojoGetClass.getArgs().get(secondParam).asText()),
                () -> assertEquals(HOST, pojoGetClass.getHeaders().getHost()),
                () -> assertEquals(FORWARDED_PROTOCOL, pojoGetClass.getHeaders().getXForwardedProto()),
                () -> assertEquals(FORWARDED_PORT, pojoGetClass.getHeaders().getXForwardedPort()),
                () -> assertEquals(ACCEPT_VALUE, pojoGetClass.getHeaders().getAccept()),
                () -> assertEquals(ACCEPT_ENCODING_VALUE, pojoGetClass.getHeaders().getAcceptEncoding()),
                () -> assertEquals(String.format("%s%s?%s=%s&%s=%s", BASE_REST_URL, path, firstParam, firstValue, secondParam, secondValue), pojoGetClass.getUrl())
        );


    }

    @ParameterizedTest
    @DisplayName("2. Post Request Test")
    @CsvSource({"foo1, bar1, foo2, bar2, /post"})
    public void postCheck(String firstParam, String firstValue, String secondParam, String secondValue, String path) {

        //У нас не создаться объект, если какого-то поля (ключа) нет
        POJOPostClass pojoPostClass = given()
                .contentType(CONTENT_TYPE_FORM_VALUE)
                .formParam(firstParam, firstValue)
                .formParam(secondParam, secondValue)
                .when()
                .post(path)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(POJOPostClass.class);

        //Проверка полей
        assertAll(
                () -> assertFalse(pojoPostClass.isSomeFieldNull()),
                () -> assertEquals(firstValue, pojoPostClass.getForm().get(firstParam).asText()),
                () -> assertEquals(secondValue, pojoPostClass.getForm().get(secondParam).asText()),
                () -> assertEquals(HOST, pojoPostClass.getHeaders().getHost()),
                () -> assertEquals(FORWARDED_PROTOCOL, pojoPostClass.getHeaders().getXForwardedProto()),
                () -> assertEquals(FORWARDED_PORT, pojoPostClass.getHeaders().getXForwardedPort()),
                () -> assertEquals(ACCEPT_VALUE, pojoPostClass.getHeaders().getAccept()),
                () -> assertEquals(CONTENT_TYPE_FORM_VALUE, pojoPostClass.getHeaders().getContentType()),
                () -> assertEquals(ACCEPT_ENCODING_VALUE, pojoPostClass.getHeaders().getAcceptEncoding()),
                () -> assertEquals(firstValue, pojoPostClass.getJson().get(firstParam).asText()),
                () -> assertEquals(secondValue, pojoPostClass.getJson().get(secondParam).asText()),
                () -> assertEquals(String.format("%s%s", BASE_REST_URL, path), pojoPostClass.getUrl())
        );
    }

    @ParameterizedTest
    @DisplayName("3. Put Request Test")
    @CsvSource({"This is expected to be sent back as part of response body., /put"})
    public void putCheck(String responseData, String path) {

        //У нас не создаться объект, если какого-то поля (ключа) нет
        POJOPutClass pojoPutClass = given()
                .contentType(ContentType.TEXT)
                .body(responseData)
                .when()
                .put(path)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().as(POJOPutClass.class);

        //Проверка полей
        assertAll(
                () -> assertFalse(pojoPutClass.isSomeFieldNull()),
                () -> assertEquals(responseData, pojoPutClass.getData()),
                () -> assertEquals(HOST, pojoPutClass.getHeaders().getHost()),
                () -> assertEquals(Integer.toString(responseData.length()), pojoPutClass.getHeaders().getContentLength()),
                () -> assertEquals(FORWARDED_PROTOCOL, pojoPutClass.getHeaders().getXForwardedProto()),
                () -> assertEquals(FORWARDED_PORT, pojoPutClass.getHeaders().getXForwardedPort()),
                () -> assertEquals(ACCEPT_VALUE, pojoPutClass.getHeaders().getAccept()),
                () -> assertEquals(CONTENT_TYPE_TEXT_VALUE, pojoPutClass.getHeaders().getContentType()),
                () -> assertEquals(ACCEPT_ENCODING_VALUE, pojoPutClass.getHeaders().getAcceptEncoding()),
                () -> assertEquals(String.format("%s%s", BASE_REST_URL, path), pojoPutClass.getUrl())
        );
    }

    @ParameterizedTest
    @DisplayName("4. Patch Request Test")
    @CsvSource({"This is expected to be sent back as part of response body., /patch"})
    public void patchCheck(String responseData, String path) {

        //У нас не создаться объект, если какого-то поля (ключа) нет
        POJOPatchClass pojoPatchClass = given()
                .contentType(ContentType.TEXT)
                .body(responseData)
                .when()
                .patch(path)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(POJOPatchClass.class);

        //Проверка полей
        assertAll(
                () -> assertFalse(pojoPatchClass.isSomeFieldNull()),
                () -> assertEquals(responseData, pojoPatchClass.getData()),
                () -> assertEquals(HOST, pojoPatchClass.getHeaders().getHost()),
                () -> assertEquals(Integer.toString(responseData.length()), pojoPatchClass.getHeaders().getContentLength()),
                () -> assertEquals(FORWARDED_PROTOCOL, pojoPatchClass.getHeaders().getXForwardedProto()),
                () -> assertEquals(FORWARDED_PORT, pojoPatchClass.getHeaders().getXForwardedPort()),
                () -> assertEquals(ACCEPT_VALUE, pojoPatchClass.getHeaders().getAccept()),
                () -> assertEquals(CONTENT_TYPE_TEXT_VALUE, pojoPatchClass.getHeaders().getContentType()),
                () -> assertEquals(ACCEPT_ENCODING_VALUE, pojoPatchClass.getHeaders().getAcceptEncoding()),
                () -> assertEquals(String.format("%s%s", BASE_REST_URL, path), pojoPatchClass.getUrl())
        );

    }

    @ParameterizedTest
    @DisplayName("5. Delete Request Test")
    @CsvSource({"This is expected to be sent back as part of response body., /delete"})
    public void deleteCheck(String responseData, String path) {

        //У нас не создаться объект, если какого-то поля (ключа) нет
        POJODeleteClass pojoDeleteClass = given()
                .contentType(ContentType.TEXT)
                .body(responseData)
                .when()
                .delete(path)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body().as(POJODeleteClass.class);

        //Проверка полей
        assertAll(
                () -> assertFalse(pojoDeleteClass.isSomeFieldNull()),
                () -> assertEquals(responseData, pojoDeleteClass.getData()),
                () -> assertEquals(HOST, pojoDeleteClass.getHeaders().getHost()),
                () -> assertEquals(Integer.toString(responseData.length()), pojoDeleteClass.getHeaders().getContentLength()),
                () -> assertEquals(FORWARDED_PROTOCOL, pojoDeleteClass.getHeaders().getXForwardedProto()),
                () -> assertEquals(FORWARDED_PORT, pojoDeleteClass.getHeaders().getXForwardedPort()),
                () -> assertEquals(ACCEPT_VALUE, pojoDeleteClass.getHeaders().getAccept()),
                () -> assertEquals(CONTENT_TYPE_TEXT_VALUE, pojoDeleteClass.getHeaders().getContentType()),
                () -> assertEquals(ACCEPT_ENCODING_VALUE, pojoDeleteClass.getHeaders().getAcceptEncoding()),
                () -> assertEquals(String.format("%s%s", BASE_REST_URL, path), pojoDeleteClass.getUrl())
        );
    }
}
