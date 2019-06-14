package com.example.myapp.Enums;

public enum WidgetType {
  HEADING("Heading"),
  IMAGE("Image"),
  LINK("Link"),
  PARAGRAPH("Paragraph"),
  LIST("List");

  String val;

  WidgetType(String val) {
    this.val = val;
  }

  public static WidgetType getWidgetType(String value){
    for(WidgetType eachType : WidgetType.values()){
      if(eachType.val.equals(value)){
        return eachType;
      }
    }
    return null;
  }
}
