package User_Validation_System;

public class Main {
    public static void main(String[] args) {
        User user = new User("Sushant", "anonymous@example.com", "secret2025");

        try {
            Validator.validate(user);
        } catch (Exception e) {
            System.err.println("❌ Validation error: " + e.getMessage());
        }
    }
}

