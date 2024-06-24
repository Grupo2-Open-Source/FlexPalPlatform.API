package com.gymfinity.flexpal.platform.iam.application.internal.commandservices;

import com.gymfinity.flexpal.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.gymfinity.flexpal.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.gymfinity.flexpal.platform.iam.domain.model.aggregates.User;
import com.gymfinity.flexpal.platform.iam.domain.model.commands.SignInCommand;
import com.gymfinity.flexpal.platform.iam.domain.model.commands.SignUpCommand;
import com.gymfinity.flexpal.platform.iam.domain.services.UserCommandService;
import com.gymfinity.flexpal.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.gymfinity.flexpal.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService,
                                  TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }


    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username alredy exists");
        var roles = command.roles().stream().map(
                role -> roleRepository.findByName(role.getName()).
                        orElseThrow(
                                ()-> new RuntimeException("Role name not" + "found"))).toList();
        var user = new User(command.username(),
                hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("user not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}
