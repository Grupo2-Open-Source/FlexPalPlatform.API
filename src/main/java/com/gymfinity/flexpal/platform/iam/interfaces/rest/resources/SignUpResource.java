package com.gymfinity.flexpal.platform.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String username, String password, String firstName, String lastName, String email,
                             List<String> roles) {
}
