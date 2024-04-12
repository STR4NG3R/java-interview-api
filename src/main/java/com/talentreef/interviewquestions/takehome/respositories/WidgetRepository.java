package com.talentreef.interviewquestions.takehome.respositories;

import com.talentreef.interviewquestions.takehome.models.Widget;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class WidgetRepository {

  private List<Widget> table = new ArrayList<>();

  public boolean deleteById(String name) {
    int originalSize = table.size();
    this.table = table.stream().filter((Widget widget) -> !name.equals(widget.getName())).collect(Collectors.toList());
    return originalSize != this.table.size();
  }

  public List<Widget> findAll(String name, Double price, String description) {
    Stream<Widget> stream = this.table.stream();
    if (name != null && !name.isEmpty())
      stream = stream.filter((Widget widget) -> name.equals(widget.getName()));
    if (price != null)
      stream = stream.filter((Widget widget) -> price > widget.getPrice());
    if (description != null)
        stream = stream.filter((Widget widget) -> widget.getDescription().contains(description));
    return stream.collect(Collectors.toList());
  }

  public Optional<Widget> findById(String name) {
    return table.stream()
                                   .filter((Widget widget) -> name.equals(widget.getName()))
                                   .findAny();
  }

  public Widget save(Widget widget) {
    deleteById(widget.getName());
    table.add(widget);
    return widget;
  }

}
