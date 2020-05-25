package br.com.angular.service;

import br.com.angular.bean.Member;
import java.util.List;

public interface IMemberService {

    List<Member> getAllMembers();

    Member getMemberById(Integer memberId);

    Member createMember(Member member);

    Member updateMember(Integer memberId, Member memberDetails);

    List<Member> deleteMember(Integer memberId);
}
