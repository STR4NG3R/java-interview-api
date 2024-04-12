package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.services.WidgetService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/v1/widgets", produces = MediaType.APPLICATION_JSON_VALUE)
public class WidgetController {

  @Autowired
  private final WidgetService widgetService;

  public WidgetController( WidgetService widgetService) {
    Assert.notNull(widgetService, "widgetService must not be null");
    this.widgetService = widgetService;
  }


  @PostMapping
  public ResponseEntity<Widget> createWidget(@Valid @RequestBody Widget widget){
    return ResponseEntity.ok(widgetService.createWidget(widget));
  }
  @GetMapping
  public ResponseEntity<List<Widget>> getAllWidgets(
          @PathParam("name") String name,
          @PathParam("price") Double price,
          @PathParam("description") String description
  ) {
    return ResponseEntity.ok(widgetService.getAllWidgets(name, price, description));
  }


  @GetMapping("{id}")
  public ResponseEntity<Widget> getWidgetById(
          @PathVariable String id
  ){
    return ResponseEntity.ok(this.widgetService.getById(id));
  }

  @DeleteMapping("{id}")
  public  Boolean deleteWidgetById(
          @PathVariable String id
  ) {
    return this.widgetService.deleteById(id);
  }

  @PutMapping()
  public ResponseEntity<Widget> update(@Valid @RequestBody Widget widget){
    return ResponseEntity.ok(this.widgetService.createWidget(widget));
  }

}
