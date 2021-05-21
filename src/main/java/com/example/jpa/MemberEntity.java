package com.example.jpa;

import com.example.jpa.MemberController.Dto;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.StringUtils;

@DynamicUpdate
@Entity
@Table(name = "member")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  @Embedded
  private Address address;

  public void update(Dto dto) {
    if (StringUtils.hasText(dto.getFirstName())) {
      firstName = dto.getFirstName();
    }
    if (StringUtils.hasText(dto.getLastName())) {
      lastName = dto.getLastName();
    }
    if (StringUtils.hasText(dto.getCountry())) {
      address.country = dto.getCountry();
    }
    if (StringUtils.hasText(dto.getCity())) {
      address.city = dto.getCity();
    }
  }

  @Embeddable
  private static class Address {

    private String country;
    private String city;
  }
}
