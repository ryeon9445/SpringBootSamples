package sample.hateoas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by CBR on 2018. 7. 22..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleHateoasApplicationTests
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hasHalLinks()
    {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/customers/1", String.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).startsWith(
                "{\"id\":1,\"firstName\":\"Oliver\"" + ",\"lastName\":\"Gierke\""
        );
        assertThat(entity.getBody()).contains("_links\":{\"self\":{\"href\"");
    }

    @Test
    public void producesJsonWhenXmlIsPreferred()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/xml;q=0.9,application/json;q=0.8");
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = this.restTemplate.exchange("/customers/1", HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentType())
                .isEqualTo(MediaType.parseMediaType("application/json;charset=UTF-8"));
    }

}


