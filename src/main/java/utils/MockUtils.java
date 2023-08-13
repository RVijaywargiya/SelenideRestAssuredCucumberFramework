package utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.matching.UrlPattern;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockUtils {

    WireMockServer wireMockServer;

    public void startMockServer() {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
    }

    public void setWireMockServer() {
        configureFor("localhost", 8080);
        stubFor(get(urlPathEqualTo("/test"))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{\"message\": \"Mocked response\"}")));
    }

    public void stopMockServer() {
        wireMockServer.stop();
    }
}
