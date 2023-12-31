package com.course.course.entities;

import java.io.Serializable;
import java.time.Instant;

import com.course.course.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern="yyyy-MM-dd'T'HH:mm:ss'Z'",
    timezone = "GMT"
  )
  private Instant moment;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column
  private Integer orderStatus;

  public Order() { }

  public Order(
    Long id,
    Instant moment,
    User client,
    OrderStatus orderStatus
  ) {
    this.id = id;
    this.moment = moment;
    this.user = client;
    setOrderStatus(orderStatus);
  }

  public Long getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public User getClient() {
    return user;
  }

  public void setClient(User client) {
    this.user = client;
  }
  
  public OrderStatus getOrderStatus() {
    return OrderStatus.valueOf(this.orderStatus);
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    if (orderStatus != null) {
      this.orderStatus = orderStatus.getCode();
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  };
}
