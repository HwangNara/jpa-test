package com.example.jpa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

  private final MemberService memberService;

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
      @PathVariable Long id,
      @RequestBody Dto dto) {
    memberService.update(id, dto);
    return ResponseEntity.ok().build();
  }

  @Getter
  public static class Dto {

    private String firstName;
    private String lastName;
    private String country;
    private String city;
  }
}
