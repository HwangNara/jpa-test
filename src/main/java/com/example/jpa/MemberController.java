package com.example.jpa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class MemberController {

  private final MemberService memberService;

  @GetMapping
  public ResponseEntity<List<String>> list() {
    List<MemberEntity> all = memberService.getAll();
    return ResponseEntity.ok().body(all.stream().map(MemberEntity::getLastName).collect(Collectors.toList()));
  }

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
