package com.example.Firstproject.controller;

import com.example.Firstproject.dto.MemberForm;
import com.example.Firstproject.entity.Article;
import com.example.Firstproject.entity.Member;
import com.example.Firstproject.repository.ArticleRepository;
import com.example.Firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class MemberController {

    @Autowired // 스트링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private MemberRepository memberRepository;
    @GetMapping("/signup")
    public String newMember(){

        return "/members/new";
    }
    @GetMapping("/login")
    public String log_in_site(){
        return "/members/log_in";
    }
    @PostMapping("/members/join")
    public String createMember(MemberForm form){
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());
//        System.out.println(member);
        // 2. 엔티티를 리파지토리 저장
        Member saved = memberRepository.save(member);
        log.info((saved.toString()));
//        System.out.println(saved);
        return "redirect:/members/"+saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable long id, Model model){

        // 1. DB에서 데이터 가져오기
        Member MemberEntity = memberRepository.findById(id).orElse(null);
        // 2. 데이터를 모델에 등록하기
        model.addAttribute("member",MemberEntity);
        // 3. 뷰 페이지 반환하기
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){

        // 1. DB에서 모든 members가져온다.
        List<Member> memberEntityList = (List<Member>)memberRepository.findAll();
        // 2. model에 데이터들을 등록한다.
        model.addAttribute("members",memberEntityList);
        // 3. 뷰 페이지를 반환한다.
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable long id,Model model){
        // 1. DB에서 엔티티를 가져온다.
        Member memberEntitiy = memberRepository.findById(id).orElse(null);
        // 2. 엔티티를 모델에 등록한다.
        model.addAttribute("member",memberEntitiy);
        // 3. 뷰 페이지를 반환한다.
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){

        log.info(form.toString());
        // 1. 데이터를 엔티티 형태로
        Member memberEntity = form.toEntity();
        // 2. 엔티티를 레포지스토리에 등록
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);

        if (target != null){
            memberRepository.save(memberEntity);
        }
        return "redirect:/members/"+memberEntity.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable long id, RedirectAttributes rttr){
        // 1. id를 이용해 삭제할 값 찾기
        Member target = memberRepository.findById(id).orElse(null);
        // 2. 있으면 삭제
        if (target != null){
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제됐습니다!");
        }
        // 3. 리다이렉트 반환
        return "redirect:/members";
    }
}
