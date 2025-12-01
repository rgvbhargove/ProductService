package DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String productImageUrl;
    private String categoryName;
}
