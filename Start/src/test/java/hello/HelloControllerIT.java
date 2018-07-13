package hello;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.regex.Matcher;

/**
 * Created by CBR on 2018. 7. 12..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT
{
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate tempate;

    @Before
    public void setUp() throws Exception
    {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception
    {
        ResponseEntity<String> response = tempate.getForEntity(base.toString(), String.class);
        Assert.assertThat(response.getBody(), Matchers.equalTo("Greetings from Spring Boot!"));
    }
}