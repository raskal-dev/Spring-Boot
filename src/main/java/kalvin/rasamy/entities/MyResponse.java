package kalvin.rasamy.entities;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class MyResponse {

    private String message;

    private Object object;

}
