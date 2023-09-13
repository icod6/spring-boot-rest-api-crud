package test.java.com.yourcompany.controller;

// ProductControllerTest.java (in src/test/java)

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductById_ReturnsProductWithCategoryDetails() throws Exception {
        // Create a sample product and category
        Category category = new Category();
        category.setId(1L);
        category.setName("Electronics");

        Product product = new Product();
        product.setId(1L);
        product.setName("Smartphone");
        product.setPrice(499.99);
        product.setCategory(category);

        // Mock the service to return the sample product
        Mockito.when(productService.getProductById(1L)).thenReturn(product);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Smartphone")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(499.99)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.category.id", Matchers.is(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.category.name", Matchers.is("Electronics")));
    }

    // Other test cases for CRUD operations...
}
