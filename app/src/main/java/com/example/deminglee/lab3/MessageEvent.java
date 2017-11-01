package com.example.deminglee.lab3;

/**
 * Created by Deming Lee on 2017/10/31.
 */

public class MessageEvent {
  private String msg_name;
  private String msg_price;
  private String msg_info;
  
  public MessageEvent(String msg_name, String msg_price, String msg_info) {
    super();
    this.msg_name = msg_name;
    this.msg_price = msg_price;
    this.msg_info = msg_info;
  }
  public String getMsg_name() {
    return msg_name;
  }
  public String getMsg_price() {
    return msg_price;
  }
  public String getMsg_info() {
    return msg_info;
  }
}
