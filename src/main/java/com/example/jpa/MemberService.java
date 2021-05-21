package com.example.jpa;

import com.example.jpa.MemberController.Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public void update(Long id, Dto dto) {
    MemberEntity member = memberRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Not found member"));

    member.update(dto);

    memberRepository.save(member);
  }
}
