package com.gymfinity.flexpal.platform.iam.interfaces.acl;

import com.gymfinity.flexpal.platform.iam.domain.model.commands.SignUpCommand;
import com.gymfinity.flexpal.platform.iam.domain.model.entities.Role;
import com.gymfinity.flexpal.platform.iam.domain.model.queries.GetUserByIdQuery;
import com.gymfinity.flexpal.platform.iam.domain.model.queries.GetUserByUsernameQuery;
import com.gymfinity.flexpal.platform.iam.domain.services.UserCommandService;
import com.gymfinity.flexpal.platform.iam.domain.services.UserQueryService;
import io.jsonwebtoken.lang.Strings;

import java.util.ArrayList;
import java.util.List;

public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public Long createUser(String userName, String password, String firstName, String lastName,String email) {
        var signUpCommand = new SignUpCommand(userName, password, firstName, lastName, email,List.of(Role.getDefaultaRole()));
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return  0L;
        return result.get().getId();
    }

    public Long createUser(String userName, String password, String firstName, String lastName, String email,List<String> roleNames) {
        var roles = roleNames != null ? roleNames.stream().map(Role::toRoleFromName).toList() : new ArrayList<Role>();
        var signUpCommand = new SignUpCommand(userName, password, firstName, lastName, email, roles);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return  0L;
        return result.get().getId();
    }

    public Long fetchUserIdByUsername(String userName) {
        var getUserByUsernameQuery = new GetUserByUsernameQuery(userName);
        var result = userQueryService.handle(getUserByUsernameQuery);
        if (result.isEmpty()) return  0L;
        return result.get().getId();
    }

    public String fetchUserUsernameById(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getUsername();
    }
}
