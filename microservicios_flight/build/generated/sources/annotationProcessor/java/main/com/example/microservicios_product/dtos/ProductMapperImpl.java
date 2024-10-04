package com.example.microservicios_product.dtos;

import com.example.microservicios_product.models.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-27T18:02:08-0500",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        double price = 0.0d;
        int stock = 0;

        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        stock = product.getStock();

        ProductDto productDto = new ProductDto( id, name, description, price, stock );

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productDto.id() );
        product.name( productDto.name() );
        product.description( productDto.description() );
        product.price( productDto.price() );
        product.stock( productDto.stock() );

        return product.build();
    }

    @Override
    public Product saveDtoToEntity(ProductToSaveDto productToSaveDto) {
        if ( productToSaveDto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productToSaveDto.id() );
        product.name( productToSaveDto.name() );
        product.description( productToSaveDto.description() );
        product.price( productToSaveDto.price() );
        product.stock( productToSaveDto.stock() );

        return product.build();
    }
}
