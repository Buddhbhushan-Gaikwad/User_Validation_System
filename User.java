package User_Validation_System;

public class User {
    @NotNull
    private String name;

    @Email
    private String email;

    @Length(min = 5 , max = 12)
    private String password;

    public User(String name , String email , String password )
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    //Getter (optional Use Via Reflaction)
    public String getName() { return name;}
    public String getEmail() { return email;}
    public String getPassword () { return password;}

}
