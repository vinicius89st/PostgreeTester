package com.example.postgreetester.resource.support;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

public abstract class AbstractRestController<T, K> {
    public abstract CrudRepository<T, K> getRepository();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> find(@PathVariable("id") K id ){
        Optional<T> object = getRepository().findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(object.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<T>> list(){
        return new ResponseEntity(getRepository().findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> save(@RequestBody T t){
        return new ResponseEntity(getRepository().save(t), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> find(@PathVariable("id") K id, @RequestBody T t){
        Optional<T> object = getRepository().findById(id);
        if(object.isPresent()){
            return new ResponseEntity(getRepository().save(t), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> delete(@PathVariable("id") K id){
        getRepository().deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
