package br.com.ecm.content.adapter.rest.v1;

import br.com.ecm.content.domain.Content;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {


    @PostMapping("/conteudos")
    public ResponseEntity<Object> PostContent (@RequestBody Content content){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
