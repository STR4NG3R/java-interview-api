package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WidgetService {

  private final WidgetRepository widgetRepository;

  @Autowired
  private WidgetService(WidgetRepository widgetRepository) {
    Assert.notNull(widgetRepository, "widgetRepository must not be null");
    this.widgetRepository = widgetRepository;
  }

  public List<Widget> getAllWidgets(String name, Double price, String description) {
    return widgetRepository.findAll(name, price, description);
  }

  public Widget getById (String name) {
    Optional<Widget> widget = this.widgetRepository.findById(name);
    if (widget.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found");
    return widget.get();
  }
  public Widget createWidget (Widget widget) {return  widgetRepository.save(widget);}

  public  boolean deleteById (String name){
    return widgetRepository.deleteById(name);
  }
}
