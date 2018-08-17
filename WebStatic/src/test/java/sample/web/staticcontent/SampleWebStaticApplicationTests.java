package sample.web.staticcontent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by CBR on 2018. 8. 17..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleWebStaticApplicationTests
{
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHome()
    {
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("<title>Static");
    }

    @Test
    public void testCss()
    {
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
                "/webjars/bootstrap/3.2.0/css/bootstrap.min.css", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("body");
        assertThat(entity.getHeaders().getContentType())
                .isEqualTo(MediaType.valueOf("text/css"));
    }
}