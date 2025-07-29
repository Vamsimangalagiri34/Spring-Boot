package com.API.APIGateWay.Controller;

import com.API.APIGateWay.Model.PostReview;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/public")
@Slf4j
public class PublicController {

    private final RestTemplate restTemplete = new RestTemplate();
    private String ratingServiceUrl = "http://localhost:8092";

    public ResponseEntity<Object> addReview(@RequestBody PostReview postReview){
        PostReview postReview1;
        try{
            postReview1=restTemplete.postForObject(ratingServiceUrl+"/insta/post",postReview, PostReview.class);
           return  ResponseEntity.ok(postReview1);
        }
        catch (HttpStatusCodeException ex) {
//            log.info("error" + ex.getMessage());
            return ResponseEntity.status(ex.getStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getResponseBodyAsString());
        }
    }
}
