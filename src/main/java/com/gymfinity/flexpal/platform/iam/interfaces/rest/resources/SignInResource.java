package com.gymfinity.flexpal.platform.iam.interfaces.rest.resources;

public record SignInResource(String username, String password, String firstName, String lastName, String email) {
}
