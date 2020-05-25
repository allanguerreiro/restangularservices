package br.com.angular.service;

import br.com.angular.bean.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MemberService implements IMemberService {

    private List<Member> members;

    public MemberService() {
        this.members = getAllMembers();
    }

    @Override
    public List<Member> getAllMembers() {
        if (members == null || members.isEmpty()) {
            this.members = new ArrayList<>();
            members.add(new Member(1, "Allan Teste 1", "Bio Teste 1", 18));
            members.add(new Member(2, "Allan Teste 2", "Bio Teste 2", 19));
            members.add(new Member(3, "Allan Teste 3", "Bio Teste 3", 20));
        }
        return members;
    }

    @Override
    public Member getMemberById(Integer memberId) {
        for (Member member : members) {
            if (Objects.equals(memberId, member.getId())) {
                return member;
            }
        }
        return null;
    }

    @Override
    public Member createMember(Member member) {
        if (member.getName() != null || !member.getName().isEmpty()) {
            this.members.add(new Member(members.size() + 1, member.getName(), member.getBio(), member.getAge()));
        }
        return member;
    }

    @Override
    public Member updateMember(Integer memberId, Member memberDetails) {
        Member member = this.getMemberById(memberId);
        member.setName(memberDetails.getName());
        member.setBio(memberDetails.getBio());
        member.setAge(memberDetails.getAge());
        return member;
    }

    @Override
    public List<Member> deleteMember(Integer memberId) {
        Member member = this.getMemberById(memberId);
        this.members.remove(member);
        return this.members;
    }
}
