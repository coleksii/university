package our.best.university.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.*;
import our.best.university.entity.base.AbstractEntity;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Lector extends AbstractEntity {

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 30)
    private String name;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 30)
    private String lastName;


    @NotNull
    @NotEmpty
    @Length(min = 1, max = 20)
    private String degree;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 15)
    private String phone;

    @NotNull
    private int salary;
}
