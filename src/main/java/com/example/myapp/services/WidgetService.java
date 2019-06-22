package com.example.myapp.services;

import com.example.myapp.models.Widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {


  private static List<Widget> widgets = new ArrayList<Widget>();

  static {
    widgets.add(new Widget(123, "Widget 1", "Heading", 1, "The Heading"));
    widgets.add(new Widget(234, "Widget 2", "Image", 2, "The image"));
    widgets.add(new Widget(345, "Widget 3", "List", 3, "List \n of \n items"));
    widgets.add(new Widget(456, "Widget 4", "Link", 4, "The link"));
    widgets.add(new Widget(567, "Widget 5", "Paragraph", 5, "The paragraph text"));
  }


  public List<Widget> findAllWidgets() {
    return widgets;
  }


  public List<Widget> deleteWidget(long widgetId) {
    widgets = widgets
            .stream()
            .filter(widget -> !widget.getId().equals(widgetId))
            .collect(Collectors.toList());
    return widgets;
  }

  public List<Widget> createWidget(Widget widget) {
    widgets.add(widget);
    return widgets;
  }

  public Widget findWidgetById(long id) {
     Widget particularWidget = widgets.stream().filter(widget -> widget.getId() == id).findAny().get();
     return particularWidget;
  }

  public List<Widget> updateWidget(long wid, Widget widgetTemp) {
    widgets = widgets.stream().map(temp -> temp.getId() == wid ? widgetTemp: temp).collect(Collectors.toList());
//    return widgets;
//    for(Widget temp: widgets){
//      if(temp.getId().intValue() == widgetTemp.getId().intValue()){
//        int index = widgets.indexOf(temp);
//        widgets.remove(temp);
//        widgets.add(index, widgetTemp);
//        break;
//      }
//    }
    return widgets;
  }
}
