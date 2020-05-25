package br.com.angular.controller;

import br.com.angular.bean.Member;
import br.com.angular.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT, RequestMethod.DELETE}, allowCredentials = "true", origins = "*", maxAge = 3600)
public class RestServiceController {

    private MemberService memberService;

    @Autowired
    public RestServiceController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        try {
            log.debug("No getAllMembers");
            return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erro no getAllMembers {}", e.getMessage(), e);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Integer memberId) {
        try {
            log.debug("No getAllMembers");
            return new ResponseEntity<>(memberService.getMemberById(memberId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erro no getMemberById {}", e.getMessage(), e);
            return new ResponseEntity<>(new Member(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        try {
            log.debug("No createMember {}", member.toString());
            return new ResponseEntity<>(memberService.createMember(member), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erro no createMember {}", e.getMessage(), e);
            return new ResponseEntity<>(new Member(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Integer memberId, @RequestBody Member memberDetails) {
        try {
            log.debug("No updateMember {}", memberDetails.toString());
            if (getMemberById(memberId) != null) {
                return new ResponseEntity<>(memberService.updateMember(memberId, memberDetails), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Member(), HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.error("Erro no updateMember {}", e.getMessage(), e);
            return new ResponseEntity<>(new Member(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<List<Member>> deleteMember(@PathVariable(value = "id") Integer memberId) {
        try {
            log.debug("No deleteMember {}", memberId);
            return new ResponseEntity<>(memberService.deleteMember(memberId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erro no deleteMember {}", e.getMessage(), e);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
