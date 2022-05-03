package io.kebblar.petstore.api.model.domain;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtBody {
    private int userId;
    private String mail;
    private List<String> roles;
    private long creation;
}
