package com.gymfinity.flexpal.platform.counseling.interfaces.rest;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMemberByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.MemberCommandService;
import com.gymfinity.flexpal.platform.counseling.domain.services.queryservices.MemberQueryService;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateMemberResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.MemberResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CreateMemberCommandFromResourceAssembler;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.MemberResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/members")
@Tag(name = "Members", description = "Member Management Endpoints")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    public MemberController(MemberCommandService memberCommandService, MemberQueryService memberQueryService) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
    }

    @PostMapping
    public ResponseEntity<MemberResource>createMember(@RequestBody CreateMemberResource resource){
        var createMemberCommand = CreateMemberCommandFromResourceAssembler.toCommandFromResource(resource);
        var memberId = memberCommandService.handle(createMemberCommand);
        if (memberId.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var getMemberByIdQuery = new GetMemberByIdQuery(memberId.get().getId());
        var member = memberQueryService.handle(getMemberByIdQuery);
        var memberResource = MemberResourceFromEntityAssembler.toResourceFromEntity(member);
        return ResponseEntity.ok(memberResource);
    }

    @GetMapping(value = "/{memberId}")
    public ResponseEntity<MemberResource> getMemberById(@PathVariable Long memberId){
        var getMemberByIdQuery = new GetMemberByIdQuery(memberId);
        var member = memberQueryService.handle(getMemberByIdQuery);
        if (member.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var memberResource = MemberResourceFromEntityAssembler.toResourceFromEntity(member);
        return ResponseEntity.ok(memberResource);
    }
}
